import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.security.*;

public class Synchronizer {

    public void synchronize(FileSystem fs1, FileSystem fs2) throws Exception{
        FileSystem refCopy1 = fs1.getReference();
        FileSystem refCopy2 = fs2.getReference();

        List<String> dirtyPath1 = computeDirty(refCopy1,fs1,"","");
        List<String> dirtyPath2 = computeDirty(refCopy2,fs2,"","");

        /*....*/

    }


    public static List<String> computeDirty(FileSystem lastSync, FileSystem fs, String currRelPath, String lastRelPath) throws Exception{

        List<String> lsDirty = new ArrayList<String>();

        File fichier = new File(currRelPath);

        File lastFichier = new File(lastRelPath);



        if (fichier.isDirectory() && lastFichier.isDirectory()) {
            int length = fichier.list().length;
            for (int i = 0; i<length;i++) {
                List<String> lis = computeDirty(lastSync, fs, currRelPath+"/"+fs.getChildren(currRelPath, i), lastRelPath+"/"+lastSync.getChildren(lastRelPath,i));
                for (String s : lis) {
                    lsDirty.add(s);
                }
            }
        }

        else /*(fichier.isFile() && lastFichier.isFile()) */{

            String checksumfs = getMD5Checksum(fichier.getAbsolutePath());
            String checksumls = getMD5Checksum(lastFichier.getAbsolutePath());
            if (!checksumfs.equals(checksumls) ) {
                lsDirty.add(fichier.getPath());
            }
        }

        return lsDirty;

    }

    public static void mirror(FileSystem fs1, List<String> dirtyPath1, FileSystem fs2, List<String> dirtyPath2, String currRelPath){

    }

    private static byte[] createChecksum(String filename) throws Exception {
        InputStream fis =  new FileInputStream(filename);

        byte[] buffer = new byte[1024];
        MessageDigest complete = MessageDigest.getInstance("MD5");
        int numRead;

        do {
            numRead = fis.read(buffer);
            if (numRead > 0) {
                complete.update(buffer, 0, numRead);
            }
        } while (numRead != -1);

        fis.close();
        return complete.digest();
    }

    // see this How-to for a faster way to convert
    // a byte array to a HEX string
    private static String getMD5Checksum(String filename) throws Exception {
        byte[] b = createChecksum(filename);
        String result = "";

        for (int i=0; i < b.length; i++) {
            result += Integer.toString( ( b[i] & 0xff ) + 0x100, 16).substring( 1 );
        }
        return result;
    }

}

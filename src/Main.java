import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception{
        System.out.println("Hello World!");

        String path = "/home/doriane/Bureau/replication";

        FileSystem fs1 = new LocalFileSystem(path+"/Sys2",null);
        FileSystem fs2 = new LocalFileSystem(path+"/Sys1",null);

        List<String> alDirty = Synchronizer.computeDirty(fs2,fs1, path+"/Sys2",path+"/Sys1");

        System.out.println(alDirty.size());

        for (String s : alDirty) {
            System.out.println(s);
        }

    }
}
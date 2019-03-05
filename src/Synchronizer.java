import java.util.List;

public class Synchronizer {

    public void synchronize(FileSystem fs1, FileSystem fs2){
        FileSystem refCopy1 = fs1.getReference();
        FileSystem refCopy2 = fs2.getReference();

        List<String> dirtyPath1 = computeDirty(refCopy1,fs1,"");
        List<String> dirtyPath2 = computeDirty(refCopy2,fs2,"");

        /*....*/

    }


    public static List<String> computeDirty(FileSystem lastSync, FileSystem fs, String currRelPath){

    }

    public static void mirror(FileSystem fs1, List<String> dirtyPath1, FileSystem fs2, List<String> dirtyPath2, String currRelPath){

    }

}

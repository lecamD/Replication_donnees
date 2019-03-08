import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception{
        System.out.println("Hello World!");

        String path = "/home/doriane/Bureau/replication";

        FileSystem fs1 = new LocalFileSystem(path+"/Sys1",null);
        FileSystem fs2 = new LocalFileSystem(path+"/Sys2",null);

        //System.out.println(fs2.getParent(path+"/Sys1/test.txt"));
        //System.out.println(fs2.getChildren(path+"/Sys1/",0));

        List<String> alDirty = Synchronizer.computeDirty(fs1,fs2, path+"/Sys1",path+"/Sys2");

        System.out.println(alDirty.size());

        for (String s : alDirty) {
            System.out.println(s);
        }

    }




/*    public static void main(String[] args) {
        String path = "/home/samsambt/Bureau/M2/Options/Data_Replication_Consistency/FileSystem/src";
        LocalFileSystem fs = new LocalFileSystem(path + "/Files1");
        LocalFileSystem lastSync= new LocalFileSystem(path+"/Files2");

        //Synchronizer synchronizer = new Synchronizer();
        System.out.println("Yes");
        ArrayList<String> l;
        l = (ArrayList<String>) Synchronizer.computeDirty(lastSync, fs, path+"/Files1");

        System.out.println(l.size());
        for (int i=0; i<l.size(); i++) {
            System.out.println(i+" : "+ l.get(i));
        }
    }*/
}
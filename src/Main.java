import java.io.File;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        File root = new File(".");

        root.mkdir();


        File fichier1 = new File(root,"./root/fichier1/fichierTest1");
        File fichierTest1 = new File("./root/fichier1/fichierTest1");

        System.out.println(fichier1.getParent());
        System.out.println(fichierTest1.getParent());

        File fichier2 = new File (root,"root/fichier2/fichierTest2");
        //File fichierTest2 = new File(fichier2,null);





        FileSystem fs1 = new LocalFileSystem(fichier1.getAbsolutePath(),null);
        FileSystem fs2 = new LocalFileSystem(fichier2.getAbsolutePath(),fs1);





    }
}
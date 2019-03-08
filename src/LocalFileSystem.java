import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LocalFileSystem implements FileSystem {

    private String root;
    //private String parent;
    //private List<String> lChildren;
    private FileSystem reference;

    public LocalFileSystem(String root,/* String parent, List<String> lChildren,*/ FileSystem reference) {
        this.reference = reference;
        this.root = root;
    }

    @Override
    public String getRoot() {
        return this.root;
    }

    @Override
    public String getParent(String path) {
        File fichier = new File(path);
        return fichier.getParent();
    }

    @Override
    public String getChildren(String path, int i) {
        List<String> lChildren = new ArrayList<String>();
        File fichier = new File(path);
        if (fichier.isDirectory()) {
            String children[] = fichier.list();
            return children[i];
        }
        return null;
    }

    @Override
    public void replace(String absolutePathTargetFs, FileSystem sourceFs, String absolutePathSourceFs) {

    }

    @Override
    public void fileCopy(File input, File output) {

    }

    @Override
    public FileSystem getReference() {
        return this.reference;
    }
}
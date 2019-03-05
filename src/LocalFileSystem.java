import java.io.File;
import java.util.List;

public class LocalFileSystem implements FileSystem {

    private String root;
    private String parent;
    private List<String> lChildren;
    private FileSystem reference;
    private int size;

    public LocalFileSystem(String root, String parent, List<String> lChildren, FileSystem reference, int size) {
        this.parent = parent;
        this.size = size;
        this.reference = reference;
        this.root = root;
        this.lChildren = new List<String>;
        for(String s : lChildren) {
            this.lChildren.add(s);
        }
    }

    @Override
    public String getRoot() {
        return this.root;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String getParent(String path) {
        return this.parent;
    }

    @Override
    public List<String> getChildren(String path) {
        return this.lChildren;
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
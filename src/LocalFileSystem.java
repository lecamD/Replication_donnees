import java.io.File;
import java.util.List;

public class LocalFileSystem implements FileSystem {

    private String root;
    private String parent;
    private String children;
    private FileSystem reference;

    public class LocalFileSystem() {

    }

    @Override
    public String getRoot() {
        return this.root;
    }

    @Override
    public String getParent(String path) {
        return this.parent;
    }

    @Override
    public List<String> getChildren(String path) {
        return this.children;
    }

    @Override
    public void replace(String absolutePathTargetFs, FileSystem sourceFs, String absolutePathSourceFs) {

    }

    @Override
    public void fileCopy(File input, File output) {

    }

    @Override
    public FileSystem getReference() {
        return null;
    }
}
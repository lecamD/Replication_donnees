import java.io.File;
import java.util.List;

public interface FileSystem {

    public String getRoot();
    public String getParent(String path);
    public String getChildren(String path, int i);
    public void replace(String absolutePathTargetFs, FileSystem sourceFs, String absolutePathSourceFs);
    public void fileCopy(File input, File output);

    public FileSystem getReference();
}
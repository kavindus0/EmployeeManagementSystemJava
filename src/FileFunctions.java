import java.io.IOException;

public interface FileFunctions {

    void createFileBaseHTML() throws IOException;
    void listUserdataFiles() throws IOException;
    void removeFile(String id) throws IOException;
    void viewFile(String id) throws IOException;
    void updateFile(String id, String oldData, String newData) throws IOException;


}

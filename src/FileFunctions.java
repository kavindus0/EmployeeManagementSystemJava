import java.io.File;
import java.io.IOException;

public interface FileFunctions {

    static final File USER_DATA_FILE = new File("userdata.txt");
    static final String USER_DATA_DIR = "./userdata/";
    static final String EMERGENCY_DATA_DIR = "./emergencydata/";
    static final String SALARY_DATA_DIR = "./salarydata/";

    void createFileBaseHTML() throws IOException;
    void listUserdataFiles() throws IOException;
    void removeFile(String id) throws IOException;
    void viewFile(String id) throws IOException;
    void updateFile(String id, String oldData, String newData) throws IOException;


}

import java.util.ArrayList;

public interface FileHandling {
    void writeFile();
    default void readFile(){
        return;
    }
}

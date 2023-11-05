import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatasetReader {
    public static int[] read(String path) throws IOException {
        return Files.lines(Paths.get(path))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

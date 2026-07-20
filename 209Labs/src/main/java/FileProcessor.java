import java.io.BufferedReader;
import java.io.IOException;

public abstract class FileProcessor<R> {
    protected abstract void startFile();
    protected abstract void processLine(String line);
    protected abstract R endFile();

    public final R processFile(BufferedReader in) throws IOException {
        startFile();

        try {
            String line;
            // Read until the end of the file
            while ((line = in.readLine()) != null) {
                processLine(line);
            }
        }
        catch (IOException e) {
            System.err.println("File error: " + e.getMessage());
        }

        return endFile();
    }
}

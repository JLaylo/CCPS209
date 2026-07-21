import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExercises {
    public static int countLines(Path path, int thres) throws IOException {
        long lineCount = 0;

        try (Stream<String> lines = Files.lines(path)) {
            lineCount = (int) lines.filter(line -> line.length() >= thres).count();
        }

        return Math.toIntExact(lineCount);
    }

    public static List<String> collectWords(Path path) throws IOException {
        List<String> words = new ArrayList<>();

        try (Stream<String> lines = Files.lines(path)) {
            words = lines
                    .map(String::toLowerCase)
                    .flatMap(line -> Stream.of(line.split("[^a-z]+")))
                    .filter(line -> !line.isEmpty())
                    .sorted()
                    .distinct()
                    .collect(Collectors.toList());

        }

        return words;
    }
}

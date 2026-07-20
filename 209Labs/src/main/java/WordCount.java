import java.util.List;

public class WordCount extends FileProcessor<List<Integer>> {
    int charCount;
    int wordCount;
    int lineCount;

    @Override
    protected void startFile() {
        int charCount = 0;
        int wordCount = 0;
        int lineCount = 0;
    }

    @Override
    protected void processLine(String line) {
        char c;
        char prev_c = ' ';

        for (int i = 0; i < line.length(); i++) {
            c = line.charAt(i);

            // If the character is not a whitespace and we weren't already tracking a word
            if (!Character.isWhitespace(c) && Character.isWhitespace(prev_c)) {
                wordCount++;
            }

            prev_c = c;
        }

        charCount += line.length();
        lineCount++;
    }

    @Override
    protected List<Integer> endFile() {
        System.out.println("" + List.of(charCount, wordCount, lineCount));
        return List.of(charCount, wordCount, lineCount);
    }
}

import java.util.*;

public class Tail extends FileProcessor<List<String>>{
    private int numLines;
    Queue<String> queue=new LinkedList<>();

    public Tail(int n) {
        numLines = n;
    }

    @Override
    protected void startFile() {
    }

    @Override
    protected void processLine(String line) {
        if(queue.size() < numLines) {
           queue.add(line);
        }
        else {
            queue.remove();
            queue.add(line);
        }
    }

    @Override
    protected List<String> endFile() {
        ArrayList<String> list=new ArrayList<>(queue);
        //System.out.println(list);

        return new ArrayList<>(queue);
    }
}

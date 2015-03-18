import java.io.IOException;

/**
 * Created by User on 13.02.2015.
 */
public class JuiceCrasher {
    public static void main(String[] args) throws IOException {
       JuiceWorker worker = new JuiceWorker();
        worker.addJuices("input.in");
        worker.showUniqueComponents();
        worker.showSortComponents();
        worker.numberOfWash();
    }
}

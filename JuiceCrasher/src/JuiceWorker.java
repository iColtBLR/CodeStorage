import java.io.*;
import java.util.*;

/**
 * Created by User on 13.02.2015.
 */
public class JuiceWorker {
    private LinkedList<String> uniqueComponents;
    private Juice components;
    private List<Juice> juices;
    private Juice allComponents;
    static ComparatorForJuices comparatorForJuices = new ComparatorForJuices();

    public JuiceWorker() throws IOException {
        uniqueComponents = new LinkedList<String>();
        components = new Juice();
        juices = new ArrayList<Juice>();
        allComponents = new Juice();
    }

    static class ComparatorForJuices implements Comparator {
        public int compare(Object o1, Object o2) {
            return ((Juice) o2).getNumberOfComponent() - ((Juice) o1).getNumberOfComponent();
        }
    }

    public void addJuices(String name) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(new File(name)));
        StringTokenizer st;
        String component;
        int countOfJuices = 0;
        while (bf.ready()) {
            st = new StringTokenizer(bf.readLine(), " ,");
            while (st.hasMoreTokens()) {
                component = st.nextToken();
                if (!uniqueComponents.contains(component))
                    uniqueComponents.add(component);
                allComponents.add(component);
                components.add(component);
            }
            juices.add(countOfJuices, components);
            countOfJuices++;
            components = new Juice();
        }
        allComponents.sortComponents();
    }

    public void showUniqueComponents() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("juice1.out")));
        for (String hs : uniqueComponents) {
            writer.write(hs);
            writer.newLine();
        }
        writer.close();
    }

    public void showSortComponents() throws IOException {
        allComponents.showComponents("juice2.out");
    }

    public void numberOfWash() throws IOException {
        int numOfWash = 0;
        int counterOfJuices = 1;
        boolean trigger = false;
        String componentFirst, componentSecond;
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("juice3.out")));
        Juice bufferJuice = new Juice();
        juices.sort(comparatorForJuices);
        for(Juice j:juices) {
            j.usedJuice();
            componentFirst = j.toString();
            for(int i = counterOfJuices; i<juices.size(); i++) {
                bufferJuice = juices.get(i);
                componentSecond = bufferJuice.toString();
                if(!bufferJuice.isUsed()) {
                    if (componentFirst.contains(componentSecond)) {
                       trigger = true;
                        bufferJuice.usedJuice();
                        break;
                    }
                }
            }
            if(!trigger)
                numOfWash++;
            counterOfJuices++;
            trigger = false;
        }
        writer.write(Integer.toString(numOfWash));
        writer.close();
    }
}

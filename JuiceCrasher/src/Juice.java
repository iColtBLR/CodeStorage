import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by User on 13.02.2015.
 */
public class Juice {
    private ArrayList<String> components;
    private boolean isUsed;
    static ComparatorForComponents comparatorForComponents = new ComparatorForComponents();

    public Juice() {
        components = new ArrayList<String>();
    }
    static class ComparatorForComponents implements Comparator {
        public int compare(Object o1, Object o2) {
            return ((String)o1).compareToIgnoreCase((String)o2);
        }
    }

    public int getNumberOfComponent()
    {
        int countOfComponents = components.size();
        return countOfComponents;
    }

    public void add(String component) {
        components.add(component);
    }

    public void sortComponents() {
        components.sort(comparatorForComponents);
    }

    public void showComponents(String filename) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filename)));
        for(String hs: components)
        {
            writer.write(hs);
            writer.newLine();
        }
        writer.close();
    }

    public String toString()
    {
        String component = new String();
        for(String buffer: components) {
            component = component.concat(buffer);
            component.concat(" ");
        }
        return component;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void usedJuice() {
        isUsed = true;
    }
}

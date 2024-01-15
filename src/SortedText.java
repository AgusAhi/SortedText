import java.io.*;
import java.util.*;

public class SortedText {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Usage: TextFileSorter <file name>");
            System.exit(1);
        }
        long timeStart = System.currentTimeMillis();
        List<String> list = readTextFile(args[0]);
        long timeEnd = System.currentTimeMillis();
        System.out.println(timeEnd - timeStart);
        sortedList(list);
        writeListToFile(args[0], list);
    }

    private static List<String> readTextFile(String fileName) throws IOException {
        BufferedReader input = null;
        List<String> list = new LinkedList<>();
        try {
            input = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = input.readLine()) != null) {
                list.add(line);
            }
            return list;
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

    private static void writeListToFile(String filename, List<String> list) throws IOException {
        File original = new File(filename);
        File outputFile = new File("temp.txt");
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter(outputFile));
            /* for (String line: list) {
                out.println(line);
            } Equivalente con el Iterator */
            Iterator<String> iterator = list.listIterator();
            while (iterator.hasNext()) {
                out.println(iterator.next());
            }
            original.delete();
            outputFile.renameTo(original);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    private static void sortedList(List<String> list) {
        Collections.sort(list);
    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    private static void writeListToFile(String arg, List<String> list) {

    }

    private static void sortedList(List<String> list) {
    }
}

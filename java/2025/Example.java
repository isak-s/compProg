import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.util.stream.Collectors;


public class Example {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var ints = Stream.of(sc.nextLine().split(" "))
                .map(x -> Integer.parseInt(x))
                .toArray();

        var filteredInts = Stream.of(sc.nextLine())
                .map(x -> Integer.parseInt(x))
                .filter(x -> x > 10).collect(Collectors.toList());

        Pattern pattern = Pattern.compile("\"([^\"]*)\"");
        // Pattern pattern2 = Pattern.compile("'([^']*)'");
        var longString = " 'quoted' not quoted \"penis\" arst";
        var matches = pattern.matcher(longString).results().map(match -> match.group());

        matches.forEach(x -> System.out.println(x));
        System.out.println(ints[0]);
        filteredInts.forEach(i -> System.out.println(i));  // ;System.out.println(filteredInts);
        sc.close();


        int i = 1;
        int a = 2;
        int b = 3;
        int[] boxes = {a, b};
        Map<Integer, int[]> itemBoxes = new HashMap<>();
        itemBoxes.put(i, boxes);
    }
}
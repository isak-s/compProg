import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Medium99Probs {

    // binary search until requirement is met.

    /*
                3 4
                10 10 11
                2 10
                2 10
                2 10
                2 15
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("input.txt"));  // new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        TreeMap<Integer, Integer> probs = new TreeMap<>();

        // instead of Scanner for quicker input
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int d = Integer.parseInt(st.nextToken());
            probs.put(d, probs.getOrDefault(d, 0) + 1);
        }
        // use stringbuilder and then print all output simultaneously
            // instead of printing line by line.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {

            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            sb.append(deleteProblem(t, probs, d)).append("\n");
        }
        System.out.print(sb.toString());

        br.close();

    }

    public static int deleteProblem(int t, TreeMap<Integer, Integer> tree, int d) {
        Integer key;
        if (t == 1) {  // find first that is strictly harder than d.
            key = tree.higherKey(d);
        } else { // t = 2 : remove first not harder than d
            key = tree.floorKey(d);
        }
        if (key == null) {
            return -1;
        }

        int curr = tree.get(key);
        if (curr == 1) {
            tree.remove(key);
        } else {
        tree.put(key, curr-1);
        }

        return key;
    }
}
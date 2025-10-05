import java.io.*;
import java.util.*;

public class Medium99ProbsFenwick {

    static class Fenwick {
        int[] bit;
        int n;

        Fenwick(int n) {
            this.n = n;
            bit = new int[n + 2];
        }

        void add(int idx, int val) {
            for (; idx <= n; idx += idx & -idx) bit[idx] += val;
        }

        int sum(int idx) {
            int res = 0;
            for (; idx > 0; idx -= idx & -idx) res += bit[idx];
            return res;
        }

        int total() {
            return sum(n);
        }

        // Find smallest index with prefix sum >= k
        int kth(int k) {
            int idx = 0;
            int mask = Integer.highestOneBit(n);
            for (; mask > 0; mask >>= 1) {
                int next = idx + mask;
                if (next <= n && bit[next] < k) {
                    k -= bit[next];
                    idx = next;
                }
            }
            return idx + 1;
        }

        // Find next index >= start that has a nonzero value
        Integer successor(int start) {
            int totalBefore = sum(start);
            if (total() == totalBefore) return null; // no greater element
            return kth(totalBefore + 1);
        }

        // Find previous index <= start that has a nonzero value
        Integer predecessor(int start) {
            int totalUpTo = sum(start);
            if (totalUpTo == 0) return null; // no smaller/equal element
            return kth(totalUpTo);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] init = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) init[i] = Integer.parseInt(st.nextToken());

        int[] t = new int[q];
        int[] d = new int[q];
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
        }

        // coordinate compression
        TreeSet<Integer> all = new TreeSet<>();
        for (int x : init) all.add(x);
        for (int x : d) all.add(x);

        List<Integer> vals = new ArrayList<>(all);
        Map<Integer, Integer> comp = new HashMap<>();
        for (int i = 0; i < vals.size(); i++) comp.put(vals.get(i), i + 1); // 1-based index

        Fenwick bit = new Fenwick(vals.size());
        for (int x : init) bit.add(comp.get(x), 1);

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int queryType = t[i];
            int queryVal = d[i];
            int idx = comp.getOrDefault(queryVal, -1);

            Integer chosenIdx = null;
            if (queryType == 1) { // strictly harder
                if (idx == -1) {
                    // if value not in map, find where it would be
                    idx = Collections.binarySearch(vals, queryVal);
                    if (idx < 0) idx = -idx - 1;
                }
                chosenIdx = bit.successor(idx);
            } else { // not harder
                if (idx == -1) {
                    idx = Collections.binarySearch(vals, queryVal);
                    if (idx < 0) idx = -idx - 1; // position to insert
                }
                chosenIdx = bit.predecessor(idx);
            }

            if (chosenIdx == null) {
                out.append(-1).append("\n");
            } else {
                int realVal = vals.get(chosenIdx - 1);
                out.append(realVal).append("\n");
                bit.add(chosenIdx, -1);
            }
        }

        System.out.print(out);
    }
}
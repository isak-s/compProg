import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DuneDash {

    StringBuilder sb;
    BufferedReader br;
    StringTokenizer st;

    /*
     * Choose an arbitrary point. Calculate distance to all other points.
     * Find the one furthest away. ---> This is a starting node.
     * From this node, calculate the distance to all other points.
     * Order the points based on the distance from the starting pos.
     * print the ordered list
     */
    public DuneDash() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        ArrayList<Point> points = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point(x, y));
        }

        ArrayList<Boolean> visitedNodes = new ArrayList<>();
        ArrayList<Point> vectorsFromCurrent = new ArrayList<>();

        int currNode;
        // int nextNode;

        currNode = 0;
        visitedNodes.add(0, true);

        for (int i = 1; i < n; i++) {
            vectorsFromCurrent.add(points.get(currNode).vectorBetween(points.get(i)));
        }
    }
/*
    public int chooseNextNode(ArrayList<Boolean> visitedList, ArrayList<Point> vectorList) {
        ArrayList<Integer[]> ListWithIndex = new ArrayList<>();
        for(int i = 0;  i < vectorList.size(); i++) {
            ListWithIndex.add( new {vectorList.get(i), i});

        }
    } */

    @Override
    public String toString() {
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        DuneDash d = new DuneDash();
        System.out.print(d.toString());
    }



    public class Point {// implements Comparable<Point>{
            double x;
            double y;

            public Point(double x, double y) {
                this.x = x;
                this.x = x;
            }

            public double distanceBetween(Point p) {
                return Math.sqrt(Math.pow((p.x - x), 2) + Math.pow((p.y - y), 2));
            }

            /*
             *   . this
             *    \
             *     \
             *      . p
             *
             */
            public Point vectorBetween(Point p) {
                return new Point(p.x - x, p.y - y);
            }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Point)) {
                return false;
            }
            Point p = (Point) obj;
            return p.x == this.x && p.y == this.y;
        }
    }
}



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArithmeticAdaptation {
    public static void main(String[] args) throws IOException {


        System.err.println(Integer.parseInt("01"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String nextLine = br.readLine();

        var st = new StringTokenizer(nextLine);

        int s = (Integer.parseInt(st.nextToken()));

        int a;
        int b;

        // -999 <= a <= 999 != 0

        if (s > 0) {
            if (s == 1) {
                a = 2;
                b = -1;
            } else {
                b = s - 1;
                a = 1;
            }
        }
        else if (s < 0) {
            if (s == -1) {
                a = -2;
                b = 1;
            } else {
                b = s + 1;
                a = -1;
            }
                   } else { // s == 0
            a = 1;
            b = -a;
        }
        System.out.println(a + " " + b);
    }

}

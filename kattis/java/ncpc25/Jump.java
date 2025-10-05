import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jump {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String nextLine = br.readLine();
        StringTokenizer st = new StringTokenizer(nextLine);

        int n = Integer.parseInt(st.nextToken());
        long e = Long.parseLong(st.nextToken());
        long secondsPassed = 0;

        while (e != 0) {
            secondsPassed += e;

            if (secondsPassed % n == 0) {

                if (e + ++e == n) {
                    System.out.println("infinity");
                    return;
                }
            } else {
                e--;
            }

       }
       System.out.println(secondsPassed);
   }
}

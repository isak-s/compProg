import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Kmh {
public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int n  = Integer.parseInt(br.readLine());

        int maxSeen = 0;
        int curr = 0;

        for (int i = 0; i < n; i++) {

            String nextLine = br.readLine();
            StringTokenizer st = new StringTokenizer(nextLine);
            var token = st.nextToken();
            if (token.equals("/")) {
                curr = ((maxSeen + 10) / 10) * 10;
            } else {
                int spd = Integer.parseInt(token);
                curr = spd;
                if (spd > maxSeen) {
                    maxSeen = spd;
                }
            }

            sb.append(curr).append("\n");
        }

        System.out.print(sb.toString());
    }
}

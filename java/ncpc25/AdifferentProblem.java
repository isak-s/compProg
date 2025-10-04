import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AdifferentProblem {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String nextLine = br.readLine();

        while (nextLine != null) {
            StringTokenizer st = new StringTokenizer(nextLine);

            sb.append(Math.abs(Long.parseLong(st.nextToken()) - Long.parseLong(st.nextToken())))
                .append("\n");


            nextLine = br.readLine();
        }

        System.out.print(sb.toString());
    }
}



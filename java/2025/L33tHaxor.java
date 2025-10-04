import java.util.Scanner;

public class L33tHaxor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String font = sc.nextLine();
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        int r2 = sc.nextInt();
        int g2 = sc.nextInt();
        int b2 = sc.nextInt();

        String output;

        int correctFont = (font.equals("monospace")) ? 1 : 0;
        int correctBgC = (r+ b + g <= 25) ? 1 : 0;
        int correctFC = (r2 + b2 + 255 - g2 <= 35) ? 1 : 0;

        if (correctFC + correctFont + correctBgC >= 2) {
            output = "L33T H4X0R";
        } else {
            output = "n00b";
        }

        System.out.println(output);

        sc.close();
    }
}


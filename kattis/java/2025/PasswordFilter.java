import java.util.Scanner;

public class PasswordFilter {
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String input = sc.nextLine();

    String[] strings = input.split(" ");

    for (int i = 0; i < strings.length; i++) {

        var a = strings[i].chars()
            .anyMatch(c -> Character.isAlphabetic(c));
        var b = strings[i].chars()
            .anyMatch(c -> Character.isDigit(c));

        if (a && b) {
            strings[i] = strings[i].replaceAll(".","*");
        }
    }


    StringBuilder sb = new StringBuilder();

    for (String str : strings) {
        sb.append(str);
        sb.append(" ");
    }

    sb.deleteCharAt(sb.length() - 1);
    System.out.println(sb.toString());

    sc.close();
   }
}

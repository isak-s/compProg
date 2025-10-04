import java.util.HashMap;
import java.util.Scanner;

public class CrochetCompetition {
    public static void main(String[] args) {
           Scanner sc = new Scanner(System.in);
            // String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
            HashMap<String, Integer> days = new HashMap<>();
            days.put("Mon", 1);
            days.put("Tue", 2);
            days.put("Wed", 3);
            days.put("Thu", 4);
            days.put("Fri", 5);
            days.put("Sat", 6);
            days.put("Sun", 7);

            String[] firstInput = sc.nextLine().split(" ");
            int day1 = days.get(firstInput[0]);
            int hours1 = Integer.parseInt(firstInput[1].split(":")[0]);
            int minutes1 = Integer.parseInt(firstInput[1].split(":")[1]);


            String[] secondInput = sc.nextLine().split(" ");
            int day2 = days.get(secondInput[0]);
            int hours2 = Integer.parseInt(secondInput[1].split(":")[0]);
            int minutes2 = Integer.parseInt(secondInput[1].split(":")[1]);

            StringBuilder sb = new StringBuilder();







            int totalMinutes = (7 * 60 * 24 - (day1 * 24 * 60 + hours1 * 60 + minutes1 - day2 * 24 * 60 - hours2 * 60 - minutes2)) % (7 * 60 * 24);

           /*  if ( day1 <= day2) {
                totalMinutes = day2mins - day1mins;
            } else {
                totalMinutes = 7 * 24 * 60 - day1mins + day2mins;
            }
            */

           /*  int realDaysBetween = totalMinutes / (60*24);
            int realHoursBetween = (totalMinutes - realDaysBetween*60*24) / 60;
            int realMinutesBetween = (totalMinutes - realDaysBetween*60*24 - realHoursBetween*60);
           */
            if (totalMinutes == 0) {
                System.out.println("7 days");
                sc.close();
                return;
        }

        int realDaysBetween = (totalMinutes >= 60*24) ? totalMinutes / (60*24) : 0;
        totalMinutes -= realDaysBetween*60*24;
        int realHoursBetween = (totalMinutes >= 60) ? (totalMinutes / 60) : 0;
        totalMinutes -= realHoursBetween*60;
        int realMinutesBetween = totalMinutes;
        String seperator;
        int[] arr = {realDaysBetween, realHoursBetween, realMinutesBetween};
        int counter = 0;
        for (int day : arr) {
            if (day != 0) {
                counter++;
            }
        }

        if (counter == 0 || counter == 1) {
            seperator = "";
        }
        else if (counter == 2) {
            seperator = " and ";
        } else {
            seperator = ", ";
        }

        if (realDaysBetween != 0) {
            sb.append(realDaysBetween).append(" day");
            if (realDaysBetween > 1) {
                sb.append("s");
            }
            if (realMinutesBetween != 0 || realHoursBetween != 0) {
                sb.append(seperator);
            }

        }
        if (realHoursBetween != 0) {
        sb.append(realHoursBetween).append(" hour");
        if (realHoursBetween > 1) {
            sb.append("s");
        }
        if (realMinutesBetween != 0) {
            sb.append(seperator);
        }

        }
        if (realMinutesBetween != 0) {
            sb.append(realMinutesBetween).append(" minute");
            if (realMinutesBetween > 1) {
                sb.append("s");
            }
        }
        System.out.println(sb.toString());
        sc.close();


    }

public static int daysBetween(int a, int b) {

    return b - a;
}

public static int hoursBetween(int a, int b) {

    return b - a;
}

public static int minutesBetween(int a, int b) {
    return b - a;
    }
}

import java.util.PriorityQueue;
import java.util.Scanner;

public class ACapellaRecording {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // number of notes
        int d = sc.nextInt();  // largest difference between two notes
        int amountOfRecordings = 1;

        PriorityQueue<Integer> pq = new PriorityQueue<>(n);

        while (sc.hasNextInt()) {
            pq.add(sc.nextInt());
        }

        int startOfInterval = pq.remove();

        while(pq.peek() != null) {
            int currNote = pq.poll();
            if (currNote - startOfInterval > d) {
                startOfInterval = currNote;  // start new interval at the next note
                amountOfRecordings += 1;
            }
        }
        amountOfRecordings = (amountOfRecordings == 0) ? 1 : amountOfRecordings;
        System.out.println(amountOfRecordings);

        sc.close();

    }
}

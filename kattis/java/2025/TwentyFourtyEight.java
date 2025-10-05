import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TwentyFourtyEight {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

       ArrayList<ArrayList<Integer>> board = new ArrayList<>(4);

       for (int i = 0; i < 4; i++) {
           ArrayList<Integer> row = new ArrayList<>(4);
           row.add(sc.nextInt());
           row.add(sc.nextInt());
           row.add(sc.nextInt());
           row.add(sc.nextInt());
           board.add(row);
       }

       int motion = sc.nextInt();
       sc.close();
       // end input
       switch (motion) {
        case Motions.LEFT:
            moveLeft(board);
            break;
        case Motions.UP:
            rotateMatrixClockWise(board);
            rotateMatrixClockWise(board);
            rotateMatrixClockWise(board);
            moveLeft(board);
            rotateMatrixClockWise(board);
            break;
        case Motions.RIGHT:
            rotateMatrixClockWise(board);
            rotateMatrixClockWise(board);
            moveLeft(board);
            rotateMatrixClockWise(board);
            rotateMatrixClockWise(board);

            break;
        case Motions.DOWN:
            rotateMatrixClockWise(board);
            moveLeft(board);
            rotateMatrixClockWise(board);
            rotateMatrixClockWise(board);
            rotateMatrixClockWise(board);
            break;

        default:
            break;
       }

       for (ArrayList<Integer> row : board) {
           for (int i : row) {
               System.out.print(i + " ");
           }
           System.out.println("");
       }

    }
    // matrix has to be n x n
    public static void rotateMatrixClockWise(ArrayList<ArrayList<Integer>> matrix) {
        // transpose
        for (int i = 0; i < matrix.size(); i++) {
            // iterate over upper triangle only
            for (int j = i+1; j < matrix.size(); j++) {
                var temp = matrix.get(i).get(j);
                matrix.get(i).set(j, matrix.get(j).get(i));
                matrix.get(j).set(i, temp);

            }
        }
        // reverse rows
        for (int i = 0; i < matrix.size(); i++) {
            Collections.reverse(matrix.get(i));
        }
    }

  public static void moveLeftt(ArrayList<ArrayList<Integer>> board) {
    for (ArrayList<Integer> row : board) {
        ArrayList<Integer> newRow = new ArrayList<>();
        // 1. Slide non-zero tiles

        for (int x : row) if (x != 0) newRow.add(x);

        // 2. Merge
        for (int i = 0; i < newRow.size() - 1; i++) {
            if (newRow.get(i).equals(newRow.get(i+1))) {
                newRow.set(i, newRow.get(i) * 2);
                newRow.set(i+1, 0);
                i++; // skip next tile
            }
        }

        // 3. Slide again
        ArrayList<Integer> finalRow = new ArrayList<>();
        for (int x : newRow) if (x != 0) finalRow.add(x);
        while (finalRow.size() < 4) finalRow.add(0);

        // 4. Copy back
        for (int i = 0; i < 4; i++) row.set(i, finalRow.get(i));
    }
}   public static void moveLeft(ArrayList<ArrayList<Integer>> board) {
    for (ArrayList<Integer> row : board) {
        ArrayList<Integer> newRow = new ArrayList<>();
        // 1. Slide non-zero tiles
        for (int x : row) if (x != 0) newRow.add(x);

        // 2. Merge
        for (int i = 0; i < newRow.size() - 1; i++) {
            if (newRow.get(i).equals(newRow.get(i+1))) {
                newRow.set(i, newRow.get(i) * 2);
                newRow.set(i+1, 0);
                i++; // skip next tile
            }
        }

        // 3. Slide again
        ArrayList<Integer> finalRow = new ArrayList<>();
        for (int x : newRow) if (x != 0) finalRow.add(x);
        while (finalRow.size() < 4) finalRow.add(0);

        // 4. Copy back
        for (int i = 0; i < 4; i++) row.set(i, finalRow.get(i));
    }
}


    static class Motions {
        final static int LEFT = 0;
        final static int UP = 1;
        final static int RIGHT = 2;
        final static int DOWN = 3;
    }
}

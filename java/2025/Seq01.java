import java.util.Scanner;

public class Seq01 {
    static final long MOD = 1000000007;

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        char[] input = sc.nextLine().toCharArray();
        sc.close();

        System.out.println(countAllInversions(input) % MOD);
    }

    private static long countAllInversions(char[] s) {
        long result = 0;
        long zeros = 0;   // number of definite zeros seen

        long pow2 = 1; // 2^questions modulo MOD

        for (int i = s.length - 1; i >= 0; i--) {
            char c = s[i];
            if (c == '0') {
                zeros++;
            } else if (c == '1') {
                // every zero to the right is an inversion
                result += zeros * pow2;
                result %= MOD;
            } else { // '?'
                // if this '?' is '0': contributes inversions with all ones to the left
                // if this '?' is '1': contributes inversions with all zeros to the right
                result = (2 * result) % MOD; // doubling branches

                // plus new inversions where this '?' is '1'
                result = (result + zeros * pow2) % MOD;

                pow2 = (pow2 * 2) % MOD;
            }
        }

        return result;
    }
}
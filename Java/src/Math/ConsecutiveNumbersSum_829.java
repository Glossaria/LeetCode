package Math;

/**
 * Created on 1/14/21.
 */
public class ConsecutiveNumbersSum_829 {

    public static int consecutiveNumbersSum1(int N) {
        int res = 0;
        for (int i = 1; i < Math.sqrt(2 * N); i++) {
            if ((N - i * (i + 1) / 2) % i == 0) {
                res++;
            }
        }
        return res;
    }

    public static int consecutiveNumbersSum2(int n) {
        int res = 0;

        while (n % 2 == 0) {
            n /= 2;
        }

        for (int i = 1; i < Math.sqrt(2 * n); i++) {
            if ((n - i * (i + 1) / 2) % i == 0) {
                res++;
            }
        }

        return res;
    }
}

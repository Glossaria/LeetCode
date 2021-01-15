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
}

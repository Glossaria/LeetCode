package Math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created on 1/16/21.
 */
public class HappyNumber_202 {

    public static boolean isHappy(int n) {
        if (n == 1) return true;
        Set<Integer> set = new HashSet<>();

        while (n >= 1) {
            int temp = 0;

            while (n >= 1) {
                temp += (int) Math.pow(n % 10, 2);
                n /= 10;
            }

            if (n == 0) {
                if (temp == 1) return true;
                if (set.contains(temp)) return false;

                set.add(temp);
                n = temp;
            }
        }

        return false;
    }


    public static boolean isHappy2(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        while (n >= 1) {
            int temp = 0;
            while (n >= 1) {
                temp += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (temp == 1) return true;
            if (map.containsKey(temp)) {
                return false;
            } else {
                map.put(temp, 1);
            }
            n = temp;
        }


        return false;
    }


}

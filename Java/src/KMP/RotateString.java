package KMP;

public class RotateString {
    public static Boolean rotateString(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        String target = str1 + str1;
        for(int i = 0; i < str1.length(); i++){
            if(match(target, str2, i)){
                return true;
            }
        }
        return false;
    }

    private static Boolean match(String target, String str2, int start) {
        return target.substring(start, start + str2.length()).equals(str2);
    }
}

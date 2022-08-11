import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit," +
            " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur." +
            " Excepteur sint occaecat cupidatat non proident, " +
            "sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        text = text.toLowerCase();
        int length = text.length();
        for (int i = 0; i < length; i++) {
            if (!map.containsKey(text.charAt(i))) {
                map.put(text.charAt(i), 1);
            } else {
                int value = map.get(text.charAt(i));
                value++;
                map.put(text.charAt(i), value);
            }
        }
        map.remove(' ');
        map.remove(',');
        map.remove('.');
        System.out.println(map.entrySet());
        int maxValue = -1;
        char maxKey = 0;
        int minValue = Integer.MAX_VALUE;
        char minKey = 0;
        for (char i : map.keySet()) {
            int value = map.get(i);
            if (value > maxValue) {
                maxValue = value;
                maxKey = i;
            }
        }
        for (char i : map.keySet()) {
            int value = map.get(i);
            if (value < minValue) {
                minValue = value;
                minKey = i;
            }
        }
        System.out.println("Максимальное количество символов " + maxKey + ": " + maxValue + "\n" +
                "Минимальное количество символов " + minKey + ": " + minValue);
    }
}
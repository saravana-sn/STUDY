import java.util.*;

public class FixedMemoryExample {

    private static List<String> memoryHog = new ArrayList<>();

    public static void main(String[] args) {
        int ctr = 0;
        while (true) {
            if (memoryHog.size() > 100) { // Only keep 1000 objects max
                memoryHog.clear(); // Free up memory
            }
            memoryHog.add(new String("saravana"+ ctr++)); // 1MB arrays
            System.out.println(memoryHog.get(memoryHog.size()-1));
        }
    }
}

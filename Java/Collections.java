import java.util.ArrayList;

public class Collections {
    public static void main(String[] args) {
        // Normal array
        String [] stringArray = {"abc", "xyz"};
        for (int i = 0; i < stringArray.length; i++) {
            System.out.println(stringArray[i]);
        }
        //System.out.println(stringArray); ->doesn't work

        // ArrayList
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(90);
        arr.add(00);
        arr.add(80);
        arr.add(10);
        System.out.println(arr);

        arr.add(1,69);
        System.out.println(arr);
    }
}
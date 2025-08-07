import java.util.*;

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

        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("orange");
        fruits.add("banana");
        fruits.add("grapes");
        fruits.add("pineapple");
        System.out.println(fruits);
        System.out.println(fruits.get(3));
        System.out.println(fruits.remove("grapes"));
        System.out.println(fruits);

        LinkedList<String> animals = new LinkedList<>();
        animals.add("cat");
        animals.add("dog");
        animals.add("horse");
        System.out.println(animals);
        System.out.println(animals.get(1));
        System.out.println(animals.remove("horse"));
        animals.remove("horse");
        animals.remove("dog");
        System.out.println(animals);

        //SET - HashSet, TreeSet
        HashSet<String> colors = new HashSet<>();
        colors.add("red");
        colors.add("green");
        colors.add("blue");
        colors.add("yellow");
        System.out.println(colors);
        colors.add("red");
        System.out.println(colors);

        TreeSet<String> colorsT = new TreeSet<>();
        colorsT.add("red");
        colorsT.add("green");
        colorsT.add("blue");
        System.out.println(colorsT);

        HashMap<String, Integer> ageMap = new HashMap<>();
        ageMap.put("red", 20);
        ageMap.put("green", 20);
        ageMap.put("blue", 20);
        ageMap.put("yellow", 20);
        System.out.println(ageMap);
    }
}
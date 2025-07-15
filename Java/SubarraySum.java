import java.util.*;
class SubarraySum{
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=1;i<=arr.length;i++){
            int sum =0;
            for (int j=1;j<=arr.length-i;j++){
                sum +=  arr[j];
                if (sum == target){
                    list.add(i+1);
                    list.add(j+1);
                    return list;
                }
            }
        }
        list.add(-1);
        return list;
    }
    public static void main(String[] args) {
        int [] arr ={19, 23, 15, 6, 6, 2, 28, 2};
        System.out.println(subarraySum(arr, 12));
    }
}

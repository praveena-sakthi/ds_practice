import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberPossible {
    public static void main(String args[]){
        int []nums={3,30,34,5,9};
        StringBuilder result = new StringBuilder();
        Arrays.stream(nums).boxed().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1.compareTo(o2)==-1)
                    return -1;
                return 1;
            }
        }).forEach(result::append);
        System.out.println(result.toString());
    }
}

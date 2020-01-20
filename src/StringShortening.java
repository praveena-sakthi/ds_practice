import java.util.*;
import java.util.stream.Collectors;

public class StringShortening {

    public static void main(String args[]){
        String s="aaaaaaaaaaaaaas";
        int n=s.length();
        String result="";
        Stack<CharCount> st= new Stack<>();
        for(int i=0;i<n;i++){
            if(st.isEmpty()){
                st.push(new CharCount(s.charAt(i)));
            }else if(st.peek().c==s.charAt(i)){
                st.peek().incrementCount();
            }else{
                CharCount top=st.pop();
//                System.out.println("appending "+top.c+" -> "+top.count);
                result+=String.valueOf(top.c)+top.count;
                st.push(new CharCount(s.charAt(i)));
            }
        }
        if(!st.isEmpty()){
            CharCount top=st.pop();
            result+=String.valueOf(top.c)+top.count;
        }
        int nums[]={1,2,3,4,1,1,1,2,2};
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int count = 1;
            if(map.containsKey(nums[i])){
                count += map.get(nums[i]);
            }
            map.put(nums[i],count);
        }
        System.out.println("Result "+result);
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            list.add(integerIntegerEntry);
        }
        list.sort(new Comparator<>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o2.getValue() < o1.getValue())
                    return 1;
                return -1;
            }
        });
        for(Map.Entry<Integer,Integer> ent : list){
            System.out.println(ent.getKey()+" : "+ent.getValue());
        }




    }
}

class CharCount{
    char c;
    int count=0;

    public CharCount(char c){
        this.c=c;
        this.count=1;
    }

    public void incrementCount() {
        this.count++;
    }
}
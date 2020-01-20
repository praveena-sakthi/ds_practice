import java.util.Arrays;

public class MinimumFlips {
    public static void main(String args[]){
        int a=2;
        int b=6;
        int c=5;
        System.out.println(minFlips(a,b,c));
//        System.out.println(count);
    }

    public static int[] getBits(int n){
        int ba[]=new int[32];
        int i=31;
        while(n>0){
            ba[i--]=n%2;
            n=n/2;
        }
        return ba;
    }
    public static int minFlips(int a, int b, int c) {
        int ba[]=getBits(a);
        int bb[]=getBits(b);
        int bc[]=getBits(c);
        int count=0;
        for(int i=0;i<32;i++){
            if((ba[i]|bb[i]) != bc[i]){
                if(bc[i]==0 && ba[i]==1 && bb[i]==0){
                    count=count+2;
                }else{
                    count++;
                }
            }
        }
        System.out.println(Arrays.toString(ba));
        System.out.println(Arrays.toString(bb));
        System.out.println(Arrays.toString(bc));
        return count;
    }
}

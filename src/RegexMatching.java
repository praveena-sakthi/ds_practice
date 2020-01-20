public class RegexMatching {

    public static void main(String args[]){
        String s="aa";
        String p="c*a*";
        System.out.println("Calling matchRegex "+matchRegex(s.toCharArray(),p.toCharArray()));
        System.out.println("s: aa , p: c*a* -> "+isMatch("aa","c*a*"));
    }

    /**
     * Dynamic programming technique for regex matching.
     */
    public static boolean matchRegex(char[] text, char[] pattern) {
        boolean T[][] = new boolean[text.length + 1][pattern.length + 1];

        T[0][0] = true;
        //Deals with patterns like a* or a*b* or a*b*c*
        for (int i = 1; i < T[0].length; i++) {
            if (pattern[i-1] == '*') {
                T[0][i] = T[0][i - 2];
            }
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
                    T[i][j] = T[i-1][j-1];
                } else if (pattern[j - 1] == '*')  {
                    T[i][j] = T[i][j - 2];
                    if (pattern[j-2] == '.' || pattern[j - 2] == text[i - 1]) {
                        T[i][j] = T[i][j] | T[i - 1][j];
                    }
                } else {
                    T[i][j] = false;
                }
            }
        }
        return T[text.length][pattern.length];
    }

    public static boolean isMatch(String s, String p) {
        int sn=s.length();
        int pn=p.length();
        boolean t[][]=new boolean[sn+1][pn+1];
//        printDPArray(sn,pn,t);
        t[0][0]=true;
        for(int i=1;i<=pn;i++){
            if(p.charAt(i-1)=='*')
                t[0][i]=t[0][i-2];
        }
        System.out.println("sn: "+sn+" , pn:"+pn);
        System.out.println("t.length: "+t.length+",t[0].length: "+t[0].length);
        for(int i=1;i<=sn;i++){
            for(int j=1;j<=pn;j++){
                System.out.println("checking "+s.charAt(i-1)+" with "+p.charAt(j-1)+" i: "+i+",j:"+j);
                if(p.charAt(j-1)=='.'||p.charAt(j-1)==s.charAt(i-1)){
                    t[i][j]=t[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    t[i][j]=t[i][j-2];
                    if(p.charAt(j-2)=='.' || p.charAt(j-2)==s.charAt(i-1))
                        t[i][j]=t[i][j]|t[i-1][j];
                }else{
                    t[i][j]=false;
                }
            }
        }

//        printDPArray(sn, pn, t);

        return t[sn][pn];

    }

    private static void printDPArray(int sn, int pn, boolean[][] t) {
        for(int i=0;i<=sn;i++){
            for(int j=0;j<=pn;j++){
                System.out.print(t[i][j]+" ");
            }
            System.out.println();
        }
    }
}

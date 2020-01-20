import java.util.*;
import java.lang.*;
import java.io.*;
class LRUPageFault
{




    public static  void printList(Node n){
        Node curr=n;
//        System.out.println("Print function called");
        while(curr!=null){
//            System.out.print(curr.val+" -> ");
            curr=curr.next;
        }
    }

    public static void main (String[] args)
    {
        int t;
        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        for(int k=0;k<t;k++){
            int size = in.nextInt();
            int a[] = new int[size];
            for(int i=0;i<size;i++){
                a[i]=in.nextInt();
            }
            int cs = in.nextInt();
            List<Integer> ca = new ArrayList<>();
            Node n=null;
            //System.out.println("Input : "+Arrays.toString(a));
            int pageFault = 0;
            for(int i=0;i<size;i++){
                printList(n);
                if(i<cs){
                    pageFault++;
//                    System.out.println("Inserting simply");
                    n=insert(n,a[i],false);
                }else{
                    if(isPresent(n,a[i])){
//                        System.out.println("Swapping node");
                        n=swapNode(n,a[i]);
                    }else{
//                        System.out.println("deleting and inserting node");
                        pageFault++;
                        n=insert(n,a[i],true);
                    }
                }
            }
            System.out.println(pageFault);
        }
    }
    public static Node insert(Node n, int val, boolean isUpdate){
        Node newNode = new Node(val);
        if(isUpdate){
            deleteLastNode(n);
            newNode.next=n;
            n=newNode;
        }else{
            if(n==null){
                n=newNode;
            }else{
                newNode.next=n;
                n=newNode;
            }
        }
//        printList(n);
        return n;
    }

    public static boolean isPresent(Node n, int val){
        Node curr=n;
        while(curr!=null){
            if(curr.val==val)
                return true;
            curr=curr.next;
        }
        return false;
    }

    public static Node deleteLastNode(Node n){
        Node curr=n;
        Node prev=null;
        while(curr.next != null){
            prev=curr;
            curr=curr.next;
        }
        prev.next=null;
        return n;
    }

    public static Node swapNode(Node n,int val){
        if(n.val==val){
            return n;
        }
        Node  prev=null;
        Node curr= n;
        while(curr.val!=val){
            prev=curr;
            curr=curr.next;
        }
        prev.next=curr.next;
        curr.next = n;
        n=curr;
        return n;
    }
}
class Node{
    int val;
    Node next;

    public Node(int val){
        this.val =val;
        this.next=null;
    }
}


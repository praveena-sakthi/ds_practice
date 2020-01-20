public class ThreadOddEven {
    public static void main(String args[]){
        ThreadOddEven obj = new ThreadOddEven();
        MyRunableClass r1= new MyRunableClass(obj,1);
        MyRunableClass r2= new MyRunableClass(obj,2);
        MyRunableClass r3= new MyRunableClass(obj,3);
        Thread t1=new Thread(r1,"Thread 1");
        Thread t2=new Thread(r2,"Thread 3");
        Thread t3=new Thread(r3,"Thread 3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class MyRunableClass implements Runnable{
    ThreadOddEven classObj;
    int threadNumber;
    static int number = 0;

    public MyRunableClass(ThreadOddEven obj, int threadNo){
        this.classObj=obj;
        this.threadNumber=threadNo;
    }

    @Override
    public void run(){
        synchronized (classObj){
            while(number< 10){
                try{
                 //   classObj.wait();
                    Thread.currentThread().wait();
                }catch(InterruptedException exception){
                    System.out.println("Exception caught: "+exception);
                }
                System.out.println("Thread "+Thread.currentThread().getName()+" \"printing "+number++ );
                //classObj.notifyAll();
                Thread.currentThread().notify();

            }
        }
    }
}

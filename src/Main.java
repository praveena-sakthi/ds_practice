public class Main{

    public static void main(String[] args) {
        System.out.println("Hello World!");
        ImplementationClass ic=new ImplementationClass();
        ic.printFromInterface();
        A a = new A();
        a.display();
        A ab = new B();
        ab.display();
        B b= new B();
        b.display();
        B bbb = new B(1,2,3,"Pravee");
        System.out.println(bbb.toString());
        //B ba=new A();

    }
}

class A{
    String name;
    int id;
    int age;
    A(){
        System.out.println("Default constructor");
    }
    A(String name, int id, int age){
        this.name =name;
        this.id=id;
        this.age=age;
    }
    protected int v=10;
    public  static void display(){
        System.out.println("display from A : ");
    }
}

class B extends A{
    int dept;
    B(){
        System.out.println("B Def cons");
    }
    B(int id, int age, int dept, String name){
        super(name,id,age);
        this.dept=dept;
    }

    @Override
    public String toString() {
        return "B{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", v=" + v +
                "} " + super.toString();
    }

    static int v=30;
//    @Override
    public static void display(){
//        super.v
        v=89;
        System.out.println("Display from B");
//        System.out.println("display from B : "+v+" A's v : "+super.v);
//        super.v=29;
//        System.out.println("display from B : "+v+" A's v : "+super.v);
    }
}

class C extends A{
    int v=30;
//    @Override
//    public void display(){
////        super.v
//        v=90;
//        System.out.println("display from B : "+v+" A's v : "+super.v);
//        super.v=29;
//        System.out.println("display from B : "+v+" A's v : "+super.v);
//    }
}

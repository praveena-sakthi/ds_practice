import java.util.ArrayList;
import java.util.List;

public class ImplementationClass implements MainInterface,SubInterface{

    @Override
    public void printFromInterface(){
        System.out.println("Implemented method");
        List<Integer> ref=new ArrayList<>();
        ref.remove(0);
    }
}

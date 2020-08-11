package arrayvisitors.adt;

import java.util.ArrayList;
import  arrayvisitors.visitors.Element;

public interface MyArrayListI extends Element,Cloneable{
    public void setMyArrayList(MyArray array);
    public ArrayList<MyArray> getMyArrayList();
    public void finalize();
    public String toString();
}
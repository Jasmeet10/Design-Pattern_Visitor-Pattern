package arrayvisitors.adt;

import  arrayvisitors.visitors.Element;

public interface MyArrayI extends Element,Cloneable {
    
    public String toString();
    public void setMyArray(int inputIn);
    public int[] getMyArray();
    public void finalize();
    
    
}
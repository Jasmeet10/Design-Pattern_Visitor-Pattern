package arrayvisitors.adt;

import java.util.ArrayList;

import arrayvisitors.driver.Driver;
import arrayvisitors.visitors.Visitor;


public class MyArrayList implements MyArrayListI{
    ArrayList<MyArray> arlist = new ArrayList<MyArray>( );
    MyArray array1;
    public MyArrayList(){
        Driver.logger.logMessage("In the MyArrayList constructor");
    }

    public MyArrayList(MyArray arrayIn){
        this.array1 = arrayIn;
    }

    @Override
    public void accept(Visitor visitor) {
        Driver.logger.logMessage("In the MyArrayList class using accept method");
        visitor.visitMyArrayList(this);
    }


    @Override
    public ArrayList<MyArray> getMyArrayList() {
        Driver.logger.logMessage("In the MyArrayList class using getMyArrayList method");
        return arlist;
    }

    @Override
    public void setMyArrayList(MyArray array) {
        Driver.logger.logMessage("In the MyArrayList class using setMyArrayList method");
        arlist.add(array);
        
    }
    @Override
    public String toString(){
        Driver.logger.logMessage("In the MyArrayList class using toString method");
        return null;
    }
    public void finalize(){
        Driver.logger.logMessage("In the MyArrayList class using finalize method");
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        Driver.logger.logMessage("In the MyArrayList class using clone method");
        return super.clone();
    }
}
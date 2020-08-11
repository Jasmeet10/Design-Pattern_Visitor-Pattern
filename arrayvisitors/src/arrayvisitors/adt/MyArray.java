package arrayvisitors.adt;

import java.util.Arrays;
import arrayvisitors.driver.Driver;
import arrayvisitors.visitors.Visitor;



public class MyArray implements MyArrayI{
     int count,input = 0;
     int arraySize = 10;
     int arrayGrowth;
    
    public int[] numbers = new int[arraySize];
    
    public MyArray(){
        Driver.logger.logMessage("In the MyArray constructor");
    }
    public MyArray(int inputIn){
        this.input=inputIn;
    }

    @Override
    public void accept(Visitor visitor) {
        Driver.logger.logMessage("In the MyArray class using accept method");
        visitor.visitMyArray(this);
    }

    public void setMyArray(int inputIn){
        Driver.logger.logMessage("In the MyArray class using setMyArray method");
        if(numbers.length == count) {
            arrayGrowth = (arraySize/2);
            numbers = Arrays.copyOf(numbers, numbers.length + arrayGrowth);
            arraySize = numbers.length;
        }
        numbers[count] = inputIn; 
        count++;
        
    }

    public int[] getMyArray() {
        Driver.logger.logMessage("In the MyArray class using getMyArray method");
        return this.numbers;
    }

    @Override
    public String toString(){
        Driver.logger.logMessage("In the MyArray class using toString method");
        return 
         " Value: " + Arrays.toString(getMyArray());
    }
    public void finalize(){
        Driver.logger.logMessage("In the MyArray class using finalize method");
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        Driver.logger.logMessage("In the MyArray class using clone method");
        return super.clone();
    }
}
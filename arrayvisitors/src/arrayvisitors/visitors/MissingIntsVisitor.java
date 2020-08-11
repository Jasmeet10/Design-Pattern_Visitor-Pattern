package arrayvisitors.visitors;

import java.util.TreeSet;
import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.driver.Driver;



public class MissingIntsVisitor implements Visitor {
    
    TreeSet<Integer> CompareHash = new TreeSet<>();
    TreeSet <String> missingNumber = new TreeSet<>();
    int low = 00;
    int high = 99;
     public MissingIntsVisitor(TreeSet<String> missingNumberIn){
        Driver.logger.logMessage("In the MissingIntsVisitor constructor");
        this.missingNumber =missingNumberIn;
     }

    /***
     * This method checks all the array from MyArray and checks all the missing elements between 00 to 99.
     * @param array
     */
    @Override
    public void visitMyArray(MyArray a) {
        Driver.logger.logMessage("In the MissingIntsVisitor class using visitMyArray method");
        for(int i =0; i<a.numbers.length;i++){
            CompareHash.add(a.numbers[i]);
        }
        
        for(int i=low;i<=high;i++){
            if(!CompareHash.contains(i)){
                if(i<10)
                    missingNumber.add("0"+Integer.toString(i));
                else
                missingNumber.add(Integer.toString(i));
            }
        }
            
    }

    @Override
    public void visitMyArrayList(MyArrayList al) {}
    
}
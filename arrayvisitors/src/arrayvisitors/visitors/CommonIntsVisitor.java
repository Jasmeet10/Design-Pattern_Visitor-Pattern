package arrayvisitors.visitors;

import java.util.TreeSet;
import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.driver.Driver;

public class CommonIntsVisitor implements Visitor {

    MyArray array1, array2;
    public static TreeSet<String> commonIntSet
            = new TreeSet<String>();


    @Override
    public void visitMyArray(MyArray a) {
    }

    /***
     * This method checks all the common elements from the objects present in the arraylist.
     * @param al
     */
    @Override
    public void visitMyArrayList(MyArrayList al) {

        Driver.logger.logMessage("In the CommonIntsVisitor class using visitMyArrayList method");
         
        if(al.getMyArrayList().get(0).numbers.length >= al.getMyArrayList().get(1).numbers.length) {
            for (int i = 0; i < al.getMyArrayList().get(0).numbers.length; i++) {
                for (int j = 0; j < al.getMyArrayList().get(1).numbers.length; j++) {
                    if (al.getMyArrayList().get(1).numbers[j] == al.getMyArrayList().get(0).numbers[i]) {
                        if(al.getMyArrayList().get(1).numbers[j]<10){
                            commonIntSet.add("0"+Integer.toString(al.getMyArrayList().get(1).numbers[j]));
                        }
                        else
                        commonIntSet.add(Integer.toString(al.getMyArrayList().get(1).numbers[j]));
                    }
                }
            }
        }
        if(al.getMyArrayList().get(0).numbers.length < al.getMyArrayList().get(1).numbers.length) {
            for (int i = 0; i < al.getMyArrayList().get(1).numbers.length; i++) {
                for (int j = 0; j < al.getMyArrayList().get(0).numbers.length; j++) {
                    if (al.getMyArrayList().get(1).numbers[i] == al.getMyArrayList().get(0).numbers[j]) {
                        if(al.getMyArrayList().get(0).numbers[j]<10){
                            commonIntSet.add("0"+Integer.toString(al.getMyArrayList().get(0).numbers[j]));
                        }
                        else
                        commonIntSet.add(Integer.toString(al.getMyArrayList().get(0).numbers[j]));
                    }
                }
            }
        }  
        
        if((PopulateMyArrayVisitor.flag != 0) && (PopulateMyArrayVisitor.flag1 != 0)){
            commonIntSet.add("00");
            
        }else{
            commonIntSet.remove("00");
            Driver.missingNumbers1.add("00");
            Driver.missingNumbers2.add("00");
        }

        

    }
    
}
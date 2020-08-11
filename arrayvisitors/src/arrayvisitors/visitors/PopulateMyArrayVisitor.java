package arrayvisitors.visitors;

import java.io.File;
import java.io.IOException;
import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.driver.Driver;
import arrayvisitors.util.FileProcessor;


public class PopulateMyArrayVisitor implements Visitor {

    public static int flag=0, flag1 = 0;
    String inpuString, Returnline;
    FileProcessor fileProcessor;
    int number;
    
    public PopulateMyArrayVisitor(String inpuStringIn, FileProcessor fileProcessorIn, int numberIn) {
        this.inpuString = inpuStringIn;
        this.fileProcessor = fileProcessorIn;
        this.number = numberIn;

        Driver.logger.logMessage("In the PopulateMyArrayVisitor constructor");
    }

    /***
     *  helps to populate the array while reading the input from the input file
     * @param array object
     */
    @Override
    public void visitMyArray(MyArray a) {
        try{
            File file1 = new File(inpuString);
            
            if(file1.length()==0){
                System.out.println(inpuString+" file is empty.");
                System.exit(0);
            }
            while ((Returnline = fileProcessor.poll()) != null) {
                try{  
                    if(number == 0)
                    if(Integer.parseInt(Returnline) == 00){
                        flag = 1;
                    }
                    if(number == 1)
                    if(Integer.parseInt(Returnline) == 00){
                        flag1 = 1;
                    }
                    if(Returnline.length()>2){
                        System.out.println(inpuString+" contains a value greater than 99, " + Returnline + " is ignored while processing.");
                    }else
                        a.setMyArray(Integer.parseInt(Returnline));
                }
                catch(Exception e){
                    System.out.println(inpuString+" file contains the non integer value "+ Returnline);
                } 
            }
        } catch (IOException e) {
            System.out.println("IO Exception");
            System.exit(0);
        } 
            
    }

    @Override
    public void visitMyArrayList(MyArrayList al) {}
}

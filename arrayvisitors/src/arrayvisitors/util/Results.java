package arrayvisitors.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import arrayvisitors.driver.Driver;
import arrayvisitors.visitors.CommonIntsVisitor;


public class Results implements FileDisplayInterface, StdoutDisplayInterface {
    private String output1 = "";
    private String output2 = "";

    public Results(String output1In,String output2In){

       this.output1 = output1In;
       this.output2 = output2In;
       
       Driver.logger.logMessage("In the result constructor");
    }

    /***
     * This method is the implementation of the interface of StdoutDisplayInterface.
     */
    @Override
    public void writeToStdout() {

        Driver.logger.logMessage("In the result writeToStdout method");

        System.out.println("\n Common Elements in both the arrays: \n");
        System.out.println(CommonIntsVisitor.commonIntSet);
        System.out.println("\n Missing Elements of Array 1: \n");
        System.out.println(Driver.missingNumbers1);
        System.out.println("\n Missing Elements of Array 2: \n");
        System.out.println(Driver.missingNumbers2);
    }

    /***
     * This method is the implementation of the interface of FileDisplayInterface.
     */
    @Override
    public void writeToFile() {

        Driver.logger.logMessage("In the result writeToFile method");

        try {
            File file = new File(output1);
            if (file.createNewFile()) ;
            FileWriter fileWriter = new FileWriter(file);
                fileWriter.write("Array 1: \n");
             for(String result:Driver.missingNumbers1){
                fileWriter.write(result+"\n");
            }  
            fileWriter.flush();
            fileWriter.close();
            FileWriter fileWriter1 = new FileWriter(file,true);
            fileWriter1.write("\n");
            fileWriter1.write("Array 2: \n");
            for(String result:Driver.missingNumbers2){
                fileWriter1.write(result+"\n");
            }  
            fileWriter1.flush();
            fileWriter1.close();

            File file2 = new File(output2);
            if (file.createNewFile()) ;
            FileWriter fileWriter2 = new FileWriter(file2);
                fileWriter2.write("Common Array Values: \n");
             for(String result:CommonIntsVisitor.commonIntSet){
                fileWriter2.write(result+"\n");
            }  
            fileWriter2.flush();
            fileWriter2.close();
            
        } catch (IOException e) {
            System.out.println("File cannot be created");
            System.exit(0);
        } 

    }
}
    

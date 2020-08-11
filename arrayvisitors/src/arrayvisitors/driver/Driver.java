package arrayvisitors.driver;

import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.util.FileDisplayInterface;
import arrayvisitors.util.FileProcessor;
import arrayvisitors.util.Results;
import arrayvisitors.util.StdoutDisplayInterface;
import java.nio.file.InvalidPathException;
import java.util.TreeSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import arrayvisitors.visitors.CommonIntsVisitor;
import arrayvisitors.visitors.MissingIntsVisitor;
import arrayvisitors.visitors.PopulateMyArrayVisitor;

/**
 * @author Jasmeet Kaur Dua
 *
 */

public class Driver {

    private static final int REQUIRED_NUMBER_OF_CMDLINE_ARGS = 5;
    
    public static TreeSet<String> missingNumbers1 = new TreeSet<>();
    public static TreeSet<String> missingNumbers2 = new TreeSet<>();
    public static Logger logger = Logger.getInstance();

    public static void main(String[] args){

    
            if (args[0].isEmpty()) {
                System.out.println("input file name is empty, Check README for the usage!");
                System.exit(0);
            }
            if (args[1].isEmpty()) {
                System.out.println("input file name is empty, Check README for the usage!");
                System.exit(0);
            }
            if (args[2].isEmpty()) {
                System.out.println("missingintoutput file name is empty, Check README for the usage!");
                System.exit(0);
            }
            if (args[3].isEmpty()) {
                System.out.println("commonintoutput file name is empty, Check README for the value usage!");
                System.exit(0);
            }
            if (args[4].isEmpty()) {
                System.out.println("Logger file name is empty, Check README for the usage!");
                System.exit(0);
            }
            if(args[0].equals(args[1])){
                System.out.println("Input file 1 and 2 cannot have the same name. ");
                System.exit(0); 
            }
            if(args[2].equals(args[3])){
                System.out.println("output file 1 and 2 cannot have the same name. ");
                System.exit(0); 
            }

            if ((args.length != 5) || (args[0].equals("${input1}")) || (args[1].equals("${input2}")) || (args[2].equals("${out1}")) || (args[3].equals("${out2}")) || (args[4].equals("${debug}")) ) {
               System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.", REQUIRED_NUMBER_OF_CMDLINE_ARGS);
                System.exit(0);
            }
        /***
         * creating objexts of MyArray
         */


             MyArray array1 = new MyArray();
             MyArray array2 = new MyArray();
             MyArrayList myArrayList = new MyArrayList();
             File file = new File(args[4]);
             file.delete();
             

        try {
            
            for(int i =0;i<2;i++){
                FileProcessor fileprocessor = new FileProcessor(args[i]);
                switch(i){
                    case 0:
                    array1.accept(new PopulateMyArrayVisitor(args[i] ,fileprocessor, i));
                    break;
                    case 1:
                    array2.accept(new PopulateMyArrayVisitor(args[i] ,fileprocessor, i)); 
                    break;
                }
            }

            /***
             * creating objexts of MyArrayList
             */


            myArrayList.setMyArrayList(array1);
            myArrayList.setMyArrayList(array2);
            
            myArrayList.accept(new CommonIntsVisitor());
            array1.accept(new MissingIntsVisitor(missingNumbers1));
            array2.accept(new MissingIntsVisitor(missingNumbers2));

        } 
        
         catch (FileNotFoundException e) {
            System.out.println("Missing Input File");
            System.exit(0);
        }
        catch (IOException e) {
            System.out.println("IO Exception");
            System.exit(0);
        } 
        catch (SecurityException e){
            System.out.println("You do not have the read permissions to the input file");
            System.exit(0);
        }
        catch (InvalidPathException e){
            System.out.println("Invalid path");
            System.exit(0);
        }

        /***
         * writing the results and displaying it.
         */
        FileDisplayInterface resultsFileWrite = new Results(args[2],args[3]);
            resultsFileWrite.writeToFile();
        StdoutDisplayInterface resultsDisplay = new Results(args[2],args[3]);
            resultsDisplay.writeToStdout();
    }
}


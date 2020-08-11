package arrayvisitors.driver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/***
 * creating Logger
 */

public class Logger {

   private static Logger logger = new Logger();
   private static File logFile;

    /***
     * constructor of logger
     */
    private Logger( ) {
        if(logger != null)
        throw new IllegalStateException("Cannot create the instance of Singleton logger class");
        }

    /***
     * To print all the log messages.
     * @param message
     */
    public void logMessage(String message){

		try{
            if(logFile == null){
            logFile = new File("Logger");
            if (logFile.createNewFile()) ;
            }
            FileWriter filewriter = new FileWriter(logFile, true);
            filewriter.write(message+ "\n");
            filewriter.flush();
			filewriter.close();
		}catch(IOException e){
            System.out.println("Unable to write the log file");
            System.exit(0);
		}
	}

    /***
     * to get the current instance of the logger.
     * @return logger
     */
    public static Logger getInstance(){
        return logger;
    } 
    
}
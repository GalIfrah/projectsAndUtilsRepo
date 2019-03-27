package ProjectUtils;

import java.io.IOException;

public class ProcessUtils {


	public static Process process;
	
	public static Runtime runtime = Runtime.getRuntime();

	
	public static void startBatchFromCmd(String batchFilePath) {
		
		try{    

				process = runtime.exec("cmd /c start " + batchFilePath);
	 
	 
				process.waitFor();
	 
	 
				Thread.sleep(3000);
		    
		
		}catch( IOException ex ){
		
			
			System.out.println(ex.getMessage());

		
		}catch( InterruptedException ex ){
		
			
			System.out.println(ex.getMessage());

		}
		 
 }
	
	public static void killProcess() {
		
		process.destroy();
		
	}
	
	
	public static void closeCmd() {
		
		try {
		
			
			runtime.exec("taskkill /im cmd.exe /t /f");
		
		
		} catch (IOException e) {
		
			
			System.out.println("io exception");
				
		}
		
			
	}
		
		
	

}


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.*;

import com.mashape.unirest.http.exceptions.UnirestException;

import Infrastructure.WebDriverWrapper;
import Infrastructure.GenericPageObject;
import ProjectUtils.SlackService;
import ProjectUtils.ProcessUtils;
import ProjectUtils.ReadPropertyFile;

public class Basic {
	
	
	public WebDriverWrapper driverWrapper;
	
//	static final String HUB_BATCH_PATH = "C:\\Users\\galif\\OneDrive\\Desktop\\Selenium\\startgrid.bat";
//
//	static final String NODE_BATCH_PATH = "C:\\Users\\galif\\OneDrive\\Desktop\\Selenium\\startNode.bat";
//
	public static ReadPropertyFile readProperties = new ReadPropertyFile();
	
	public static Properties prop;
	
	public static String time_stamp = null;
	
	
	
	@Rule
	public TestName testName = new TestName();
	
	
	@BeforeClass
	public static void setupClass() {
		
//		ProcessUtils.startBatchFromCmd(HUB_BATCH_PATH);
//
//
//		ProcessUtils.startBatchFromCmd(NODE_BATCH_PATH);
	
		System.out.println("statr Grid");
		
//		prop = new Properties();
//
//
//		prop = readProperties.readPropFile(prop, "C:\\Users\\galif\\eclipse-workspace\\RedLionAutomation\\src\\test\\java\\SutProperties\\config.properties");
	
	}
	
	@Before
	public void setup() throws IOException {
		
		driverWrapper = new WebDriverWrapper();

		driverWrapper.init("http://localhost:4444/wd/hub");
		
		driverWrapper.MaximizeWIndow();
		driverWrapper.takeScreenShot("sdasda");
		GenericPageObject.setDriver(driverWrapper);
		
		System.out.println(prop.getProperty("TOKEN"));
		
		
	}
	
	@After
	public void tearDown() {
		
		System.out.println("end of: " + testName.getMethodName() + " end");
		
		
		driverWrapper.close();
	}
	
	@AfterClass
	public static void tearDownClass() throws IOException, UnirestException {
		
		SlackService slack = new SlackService();
		
		
		slack.uploadImage("C:\\Users\\galif\\eclipse-workspace\\RedLionAutomation\\ScreenShots\\" + time_stamp + ".png");
		
		System.out.println("C:\\Users\\galif\\eclipse-workspace\\RedLionAutomation\\ScreenShots\\" + time_stamp + ".png");
		
		ProcessUtils.killProcess();
		
		
		ProcessUtils.closeCmd();
		
		
		readProperties.killInput();

		
		System.out.println("killed all running processes!");
	
	}
	
	
	
	public void setTimeStemp(String taken_time_stamp) {
		
		time_stamp = taken_time_stamp;
	
	}
	
}

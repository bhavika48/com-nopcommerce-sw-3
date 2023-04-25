package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class BaseTest {
  public static WebDriver driver;

  public void openBrowser(String baseUrl){

      driver= new ChromeDriver();
      // Launch the browser
      driver.get(baseUrl);
      // maximize window
      driver.manage().window().maximize();
      // implicit wait
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

  }

  public void  closeBrowser(){
      driver.quit();
  }
}

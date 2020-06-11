import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TesteGoogle {
	
	@Test
	public void testeFireFox() {
		
		System.setProperty("webdriver.gecko.driver", "D:/Automacao/Drivers/GeckoDriver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();
	}
	
	@Test
	public void testeChrome() {
		
		System.setProperty("webdriver.chrome.driver", "D:/Automacao/Drivers/Chrome Drive/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();
	}
	
	@Test
	public void testeInternetExplorer() {
		
		System.setProperty("webdriver.ie.driver", "D:/Automacao/Drivers/IEDriver/IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();
	}

}

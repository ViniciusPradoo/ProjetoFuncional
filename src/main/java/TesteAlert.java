import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAlert {

	@Test
	public void deveInteragirComAlertSimples() {
		System.setProperty("webdriver.chrome.driver", "D:/Automacao/Drivers/Chrome Drive/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples", texto);
		alert.accept();

		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
	}

	@Test
	public void deveInteragirComAlertConfirm() {
		System.setProperty("webdriver.chrome.driver", "D:/Automacao/Drivers/Chrome Drive/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.accept();
		String textoOK = alert.getText();
		Assert.assertEquals("Confirmado", textoOK);
		alert.accept();

		driver.findElement(By.id("confirm")).click();
		Assert.assertEquals("Confirm Simples", alert.getText());
		alert.dismiss();
		String textoCancelar = alert.getText();
		Assert.assertEquals("Negado", textoCancelar);
		alert.accept();
		

	}
	
	@Test
	public void deveInteragirComAlertPrompt() {
		System.setProperty("webdriver.chrome.driver", "D:/Automacao/Drivers/Chrome Drive/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("prompt")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alert.getText());
		alert.sendKeys("12");
		alert.accept();
		Assert.assertEquals("Era 12?", alert.getText());
		alert.accept();
		Assert.assertEquals(":D", alert.getText());
		alert.accept();
		
		driver.quit();
		

	}
}

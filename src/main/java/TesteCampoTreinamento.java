
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

	@Test
	public void testeTextField() {
		System.setProperty("webdriver.chrome.driver", "D:/Automacao/Drivers/Chrome Drive/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de Escrita");
		Assert.assertEquals("Teste de Escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		driver.quit();
	}

	@Test
	public void deveInteragirComTextArea() {
		System.setProperty("webdriver.chrome.driver", "D:/Automacao/Drivers/Chrome Drive/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		// Teste Para escrever em linhas diferentes cada \n � um Enter que o selenium da
		//driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste\n\nteste2\n\nteste ultima linha");
		
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste");
		Assert.assertEquals("teste", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		driver.quit();

	}
	
	@Test
	public void deveInteragirComRadioButton() {
		System.setProperty("webdriver.chrome.driver", "D:/Automacao/Drivers/Chrome Drive/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		
		driver.quit();
		

	}
	
	@Test
	public void deveInteragirComCheckBox() {
		System.setProperty("webdriver.chrome.driver", "D:/Automacao/Drivers/Chrome Drive/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		
		driver.quit();
		

	}
	
	
	
	@Test
	public void deveInteragirComCombo() {
		System.setProperty("webdriver.chrome.driver", "D:/Automacao/Drivers/Chrome Drive/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		//combo.selectByIndex(2);
		//combo.selectByValue("superior");
		combo.selectByVisibleText("2o grau completo");
		
		Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
		
		driver.quit();
		

	}
	
	@Test
	public void deveVerificarValoresCombo() {
		System.setProperty("webdriver.chrome.driver", "D:/Automacao/Drivers/Chrome Drive/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement>options = combo.getOptions();
		Assert.assertEquals(8, options.size());
		
		boolean encontrou = false;
		for(WebElement option: options) {
			if(option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
				
			}
		}
		
		Assert.assertTrue(encontrou);

	}
	
	@Test
	public void deveVerificarValoresComboMultiplo() {
		System.setProperty("webdriver.chrome.driver", "D:/Automacao/Drivers/Chrome Drive/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
		
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());
		
		combo.deselectByVisibleText("Corrida");
		
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
		
		driver.quit();
	}
	
	@Test
	public void deveInteragirComBotoes() {
		System.setProperty("webdriver.chrome.driver", "D:/Automacao/Drivers/Chrome Drive/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		driver.quit();
		
	}
	
	@Test
	public void deveInteragirComLinks() {
		System.setProperty("webdriver.chrome.driver", "D:/Automacao/Drivers/Chrome Drive/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.linkText("Voltar")).click();
		
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
		
	}
	
	@Test
	public void deveInteragirCom() {
		System.setProperty("webdriver.chrome.driver", "D:/Automacao/Drivers/Chrome Drive/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		
		//Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
		
		Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
		
		
		driver.quit();
	}


}

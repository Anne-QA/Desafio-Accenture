package steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;


public class TesteSteps {
	
	WebDriver driver;
	
	@Before
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@Dado("que estou no site da Accenture")
	public void que_estou_no_site() {
		
	    driver.get("https://www.accenture.com/br-pt");
	}

	@E("quando clico no menu serviços")
	public void clicar_menu() {
		driver.findElement(By.cssSelector("#navigation-menu > div.nav-submenu.panel.layout-column.short > div.gh-item.nav-submenu-label > span")).click();
		
	}

	@E("clico na opção cloud")
	public void clico_opção_cloud() {
		driver.findElement(By.linkText("Cloud")).click();
	}

			
	@Então("devo encontrar o título serviços de cloud")
	public void devo_encontrar_o_título_serviços_de_cloud() {
	
	WebElement text = driver.findElement(By.linkText("Serviços de Cloud"));
	Assert.assertEquals("Serviços de Cloud",  text.getText());
	
	}
	
	@After
	public void fecha() {
		driver.quit();
	}

}


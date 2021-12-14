package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class EnlacesPrincipales {
	
	WebDriver driver = null;
	
	@Given("abrir navegador enlaces")
	public void abrir_navegador_enlaces() {
		System.out.println("Inside Step - abrir navegador");
	    
	    String projectPath = System.getProperty("user.dir");
	    System.out.println("Project path is: "+ projectPath);
	    
	    System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
	    
	    driver = new ChromeDriver();
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@And("entrar en la pagina web enlaces")
	public void entrar_en_la_pagina_web_enlaces() throws InterruptedException {
		driver.manage().window().maximize();
		driver.navigate().to("https://latiendadevalentina.com/");
		Thread.sleep(2000);
	}

	@And("clicar Valentina")
	public void clicar_Valentina() throws InterruptedException {
		//driver.findElement(By.xpath("//div[@id='cookies-submit']")).click();
		driver.findElement(By.xpath("//li[@class='footer-list-element']/a[@href='/pages/quienes-somos']")).click();
		Thread.sleep(2000);
		
	}

	@And("clicar ValentinaTV")
	public void clicar_ValentinaTV(){
		driver.findElement(By.xpath("//div[@class='footer-group']//a[@href='/collections/valentina-tv']")).click();
	}

	@And("clicar primervideo")
	public void clicar_primervideo() {
		driver.findElement(By.xpath("//div[@class='collection-cards']/div[1]")).click();	
	}


	@And("clicar newsletter")
	public void clicar_newsletter() {
		driver.findElement(By.xpath("//div[@class='footer-group']/a[@href='/pages/registro-newsletter']")).click();
	}

	@And("introducir email")
	public void introducir_email() {
		driver.findElement(By.xpath("//input[@name='contact[email]']")).sendKeys("4334343TQS@hotmail.com");
		driver.findElement(By.xpath("//form[@method='post']//button[@type='submit']")).click();
		
	}

	@And("clicar tiendaFisica")
	public void clicar_tiendaFisica() {
		driver.findElement(By.xpath("//a[@href='https://latiendadevalentina.com/pages/localizador-de-tiendas']")).click();
	}

	@And("clicar primera tienda")
	public void clicar_primera_tienda() {
		driver.findElement(By.xpath("//ul[@class='list']//li[1]//div[@class='list-content']/div[3]")).click();
		
	}

	@Then("Comprobar que estamos pagina de videos tv")
	public void comprobar_que_estamos_pagina_de_videos_tv() throws InterruptedException  {
		Thread.sleep(2000);
		
		String tv = driver.findElement(By.xpath("//h1[@class='collection-title-2']")).getText(); 
		System.out.println(tv);
		Assert.assertEquals(tv, "VALENTINA TV");
		

	    driver.close();
	    driver.quit();
	}
	
	@Then("Comprobar que se ha validado correctamente")
	public void comprobar_que_se_ha_validado_correctamente() throws InterruptedException  {
		Thread.sleep(2000);
		
		String News = driver.getCurrentUrl(); 
		System.out.println(News);
		Assert.assertNotEquals(News, "https://latiendadevalentina.com/pages/registro-newsletter");	
		
	    driver.close();
	    driver.quit();
	}
	
	@Then("Comprobar que la primera tienda esta en Madrid")
	public void comprobar_que_la_primera_tienda_esta_en_Madrid() throws InterruptedException  {
		Thread.sleep(2000);
		
		String Tienda = driver.findElement(By.xpath("//ul[@class='list']//li[1]//div[@class='list-content']/div[3]")).getText();
		System.out.println(Tienda);
		Assert.assertEquals(Tienda, "Madrid, Spain");	
		
	    driver.close();
	    driver.quit();
	}
}

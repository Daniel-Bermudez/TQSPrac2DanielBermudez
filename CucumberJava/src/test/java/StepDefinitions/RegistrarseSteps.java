package StepDefinitions;

import java.util.concurrent.TimeUnit;
//import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class RegistrarseSteps {
	
	WebDriver driver = null;
	
	@Given("abrir navegador")
	public void abrir_navegador() {
		System.out.println("Inside Step - abrir navegador");
	    
	    String projectPath = System.getProperty("user.dir");
	    System.out.println("Project path is: "+ projectPath);
	    
	    System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
	    
	    driver = new ChromeDriver();
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	}

	@And("entrar en la pagina web")
	public void entrar_en_la_pagina_web() throws InterruptedException {
		driver.manage().window().maximize();
		driver.navigate().to("https://latiendadevalentina.com/");
		Thread.sleep(2000);
	}

	@And("Opciones")
	public void Opciones() throws InterruptedException {
		 driver.findElement(By.xpath("//a[@id=\"acco\"]")).click();
	}
	
	@And("Registrarse")
	public void registrarse() throws InterruptedException {
		 driver.findElement(By.xpath("//p[@class= 'acc-text']/a")).click();
		 
	}
	
	@And("Registrarse IniciarSesion")
	public void registrarse_iniciarsesion() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class= 'toggle-menu']/button[@data-action='toggle-recover-form']")).click();
		
		 
	}
	@When("introducir nombre y password existentes")
	public void introducir_nombre_y_password_existentes() throws InterruptedException {
	    driver.findElement(By.xpath(" //form[@id=\"create-customer\"]//input[@name=\"customer[email]\"]")).sendKeys("danieltqs1234@hotmail.com");
	    driver.findElement(By.xpath(" //form[@id=\"create-customer\"]//input[@name=\"customer[first_name]\"]")).sendKeys("Daniel");
	    driver.findElement(By.xpath(" //form[@id=\"create-customer\"]//input[@name=\"customer[last_name]\"]")).sendKeys("TQS");
	    driver.findElement(By.xpath(" //form[@id=\"create-customer\"]//input[@name=\"customer[password]\"]")).sendKeys("DanielTQS1234");
	    
	    Thread.sleep(2000);
	}
	
	@When("introducir nombre y password")
	public void introducir_nombre_y_password() throws InterruptedException {
	    driver.findElement(By.xpath(" //form[@id=\"create-customer\"]//input[@name=\"customer[email]\"]")).sendKeys("PruebaTQS353566TQS@hotmail.com");
	    driver.findElement(By.xpath(" //form[@id=\"create-customer\"]//input[@name=\"customer[first_name]\"]")).sendKeys("Daniel");
	    driver.findElement(By.xpath(" //form[@id=\"create-customer\"]//input[@name=\"customer[last_name]\"]")).sendKeys("Bermudez");
	    driver.findElement(By.xpath(" //form[@id=\"create-customer\"]//input[@name=\"customer[password]\"]")).sendKeys("123456789A");
	    
	    Thread.sleep(2000);
	}
	
	@When("introducir Correo y password")
	public void introducir_Correo_y_password() throws InterruptedException {
	    driver.findElement(By.xpath(" //form[@id=\"create-customer\"]//input[@name=\"customer[email]\"]")).sendKeys("PruebaTQS765858@hotmail.com");
	    driver.findElement(By.xpath(" //form[@id=\"create-customer\"]//input[@name=\"customer[password]\"]")).sendKeys("123456789A");
	    Thread.sleep(2000);
	}

	@And("clicar a aceptar")
	public void clicar_a_aceptar() {
		driver.findElement(By.xpath("//div[@class='register-info']/button")).click();
		
	}

	@Then("usuario puede navegar por la pagina de inicio cuenta existente")
	public void usuario_puede_navegar_por_la_pagina_de_inicio_cuenta_existente() throws InterruptedException {
		Thread.sleep(2000);
	
		String a = driver.getCurrentUrl();
		System.out.println(a);
		Assert.assertEquals(a, "https://latiendadevalentina.com/account/register");
	
	    driver.close();
	    driver.quit();
	}
	@Then("usuario puede navegar por la pagina de inicio cuenta nueva")
	public void usuario_puede_navegar_por_la_pagina_de_inicio_cuenta_nueva() throws InterruptedException {
		Thread.sleep(2000);
	
		String a = driver.getCurrentUrl();
		System.out.println(a);
		Assert.assertEquals(a, "https://latiendadevalentina.com/");
	
	    driver.close();
	    driver.quit();
	}
	
	@Then("Comprobar si deja registrarse sin nombre")
	public void comprobar_si_deja_registrarse_sin_nombre() throws InterruptedException {
		Thread.sleep(2000);
	
		String a = driver.getCurrentUrl();
		System.out.println(a);
		Assert.assertEquals(a, "https://latiendadevalentina.com/");
	
	    driver.close();
	    driver.quit();
	}
	/*
	@Test //Test Probar registrarse cuando hay una cuenta ya creada
	public void test_Registrarse_Cuenta_ya_creada() throws InterruptedException {
		abrir_navegador();
		entrar_en_la_pagina_web();
		Opciones();
		registrarse();
		registrarse_iniciarsesion();
		introducir_nombre_y_password_existentes();
		clicar_a_aceptar();
		
		String a = driver.getCurrentUrl();
		//System.out.println(a);
		Assert.assertEquals(a, "https://latiendadevalentina.com/account/register");
		
		usuario_puede_navegar_por_la_pagina_de_inicio();
	}
	
	@Test//Test Probar registrarse cuando hay una cuenta ya creada
	public void test_Registrarse_Cuenta_no_creada() throws InterruptedException {
		abrir_navegador();
		entrar_en_la_pagina_web();
		Opciones();
		registrarse();
		registrarse_iniciarsesion();
		introducir_nombre_y_password();
		clicar_a_aceptar();
		
		String a = driver.getCurrentUrl();
		//System.out.println(a);
		Assert.assertEquals(a, "https://latiendadevalentina.com/");
		
		usuario_puede_navegar_por_la_pagina_de_inicio();
	}*/
}



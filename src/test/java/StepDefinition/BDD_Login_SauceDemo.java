package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.*;

public class BDD_Login_SauceDemo {

	WebDriver driver=null;

	@Given("User open the browser")
	public void user_open_the_browser() {
		System.out.println("Steps - User open the browser");
		
		//disable notif browser
		ChromeOptions opt = new ChromeOptions(); 
		opt.addArguments("--disable-notifications");
		
		//chromedriver setup
		System.setProperty("webdriver.chrome.driver", "C:/Users/riony/eclipse-workspace/Tugas_06_Syafrizal_Riony/src/test/resources/drivers/chromedriver.exe");

		//open Chrome browser
		driver = new ChromeDriver();

		//Maximize browser
		driver.manage().window().maximize();

	}

	@And("User on saucedemo login page")
	public void user_on_saucedemo_login_page() {
		System.out.println("Steps - User on sourcedemo login page");

		//open sourcedemo login page
		driver.get("https://www.saucedemo.com");
	}

	@When("User enter valid username")
	public void user_enter_valid_username() {
		System.out.println("Steps - User enter valid username");

		//input username
		driver.findElement(By.id("username")).sendKeys("username");
	}

	@And("User enter valid password")
	public void user_enter_valid_password() {
		System.out.println("Steps - User enter valid password");

		//input password
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("YourPasswordHere");
	}

	@And("Click Login button")
	public void click_login_button() {
		System.out.println("Steps - Click Login button");

		//click "login"
		driver.findElement(By.id("login-submit")).click();
	}

	@Then("User navigated to homepage saucedemo")
	public void user_navigated_to_homepage() throws InterruptedException {
		System.out.println("Steps - User navigated to homepage");

		//close browser
		driver.close();
		driver.quit();
	}

}

package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.*;

public class BDD_Checkout_SauceDemo<WebElement> {

	WebDriver driver=null;
	
	@Given("User open browser")
	public void user_open_browser() {
	    
		System.out.println("Step - User open browser");
		
		//disable notif browser
		ChromeOptions opt = new ChromeOptions(); 
		opt.addArguments("--disable-notifications");

		//chromedriver setup
		System.setProperty("webdriver.chrome.driver", "C:/Users/riony/eclipse-workspace/Tugas_06_Syafrizal_Riony/src/test/resources/drivers/chromedriver.exe");

		//open Chrome browser
		driver = new ChromeDriver(opt);

		//Maximize browser
		driver.manage().window().maximize();
	}

	@And("User on saucedemo homepage")
	public void user_on_saucedemo_homepage() {
	    
		System.out.println("Step - User on saucedemo home");
		
		//saucedemo homepage
		driver.get("https://www.saucedemo.com/");
	}

    @When("The user successfully logs in using the correct username")
    public void the_user_successfully_logs_in_using_the_correct_username() {
        // Implement login steps here
        WebElement usernameInput = (WebElement) driver.findElement(By.id("user-name"));
        WebElement passwordInput = (WebElement) driver.findElement(By.id("password"));
        WebElement loginButton = (WebElement) driver.findElement(By.id("login-button"));
        
        ((org.openqa.selenium.WebElement) usernameInput).sendKeys("your_username");
        ((org.openqa.selenium.WebElement) passwordInput).sendKeys("your_password");
        ((org.openqa.selenium.WebElement) loginButton).click();
    }

    @And("The user selects the item {Fleece_Jacket}")
    public void the_user_selects_the_item(String itemName) {
        // Implement item selection steps here
        WebElement item = (WebElement) driver.findElement(By.xpath("//div[contains(text(), '" + itemName + "')]"));
        ((org.openqa.selenium.WebElement) item).click();
    }

    @And("The user clicks the {cart} button")
    public void the_user_clicks_the_button(String buttonName) {
        // Implement button click steps here
        WebElement button = (WebElement) driver.findElement(By.name(buttonName));
        ((org.openqa.selenium.WebElement) button).click();
    }

    @And("In the cart, The user adds a quantity to the product")
    public void in_the_cart_the_user_adds_a_quantity_to_the_product() {
        // Implement quantity addition steps here
        WebElement quantityInput = (WebElement) driver.findElement(By.name("quantity"));
        ((org.openqa.selenium.WebElement) quantityInput).clear();
        ((org.openqa.selenium.WebElement) quantityInput).sendKeys("2"); // Set the desired quantity
    }

    @And("The user provides their first name, last name, and ZIP/postal code")
    public void the_user_provides_their_first_name_last_name_and_ZIP_postal_code() {
        // Implement user information input steps here
        WebElement firstNameInput = (WebElement) driver.findElement(By.name("first-name"));
        WebElement lastNameInput = (WebElement) driver.findElement(By.name("last-name"));
        WebElement postalCodeInput = (WebElement) driver.findElement(By.name("postal-code"));

        ((org.openqa.selenium.WebElement) firstNameInput).sendKeys("Syafrizal");
        ((org.openqa.selenium.WebElement) lastNameInput).sendKeys("Riony");
        ((org.openqa.selenium.WebElement) postalCodeInput).sendKeys("12345");
    }

    @Then("The transaction should be completed successfully")
    public void the_transaction_should_be_completed_successfully() {
        // Implement assertion for successful transaction here
        WebElement finishButton = (WebElement) driver.findElement(By.name("finish"));
        ((org.openqa.selenium.WebElement) finishButton).click();
        driver.quit();
    }	
}

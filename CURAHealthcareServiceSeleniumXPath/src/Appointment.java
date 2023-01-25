import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class Appointment {

	@org.junit.jupiter.api.Test
	void test() throws InterruptedException {
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://katalon-demo-cura.herokuapp.com/");
		
		//Page1
		driver.findElement(By.xpath("//*[@id=\"btn-make-appointment\"]")).click();
		
		//Page2 login
		driver.findElement(By.xpath("//*[@id=\"txt-username\"]")).sendKeys("John Doe");
		driver.findElement(By.xpath("//*[@id=\"txt-password\"]")).sendKeys("ThisIsNotAPassword");
		driver.findElement(By.xpath("//*[@id=\"btn-login\"]")).click();
		
		//Page3 Make Appointment Detail
		Select option1 = new Select(driver.findElement(By.xpath("//*[@id=\"combo_facility\"]")));
		option1.selectByVisibleText("Hongkong CURA Healthcare Center");
		driver.findElement(By.xpath("//*[@id=\"appointment\"]/div/div/form/div[2]/div/label")).click();
		WebElement radio2 = driver.findElement(By.xpath("//*[@id=\"appointment\"]/div/div/form/div[3]/div"));
		radio2.click();
		driver.findElement(By.xpath("//*[@id=\"txt_visit_date\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"txt_visit_date\"]")).sendKeys("18/01/2023");
		driver.findElement(By.xpath("//*[@id=\"txt_comment\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"txt_comment\"]")).sendKeys("Heart");
		driver.findElement(By.xpath("//*[@id=\"btn-book-appointment\"]")).click();
		
		Thread.sleep(5000);
		String result = driver.findElement(By.id("comment")).getText();
        if(result.equalsIgnoreCase("Heart"))
            System.out.println("Pass");
        else
            System.out.println("Fail");
		driver.quit();

	}

}

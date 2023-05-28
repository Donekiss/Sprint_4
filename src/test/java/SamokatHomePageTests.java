import java.time.Duration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SamokatHomePageTests {
    private WebDriver driver;

    public SamokatHomePageTests() {
    }

    @Test
    public void checkOrderButton2() throws InterruptedException {
        this.driver = new ChromeDriver();
        this.driver.get("https://qa-scooter.praktikum-services.ru/");
        SamokatHomePage objHomePage = new SamokatHomePage(this.driver);
        objHomePage.orderButtonFloorHomePageClick();
        objHomePage.checkWeGetAnOrderForm2();
    }

    @Test
    public void importantQuestion_1() {
        this.driver = new ChromeDriver();
        this.driver.get("https://qa-scooter.praktikum-services.ru/");
        SamokatHomePage objHomePage = new SamokatHomePage(this.driver);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        WebElement element = this.driver.findElement(By.xpath("/html/body/div/div/div/div[5]/div[1]"));
        ((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView();", new Object[]{element});
        objHomePage.howMuchIsSamokatClick();
        String actual = this.driver.findElement(objHomePage.getRespond1()).getText();
        String expected = objHomePage.textRespond1;
        Assert.assertEquals("\nТекст образца и текст на сайте не совпадают ", expected, actual);
        System.out.println("\nТекст образца и текст на сайте - идентичны!");
    }

    @After
    public void teardown() {
        this.driver.quit();
    }
}

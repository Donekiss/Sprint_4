import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HeaderTests {
    private WebDriver driver;

    public HeaderTests() {
    }

    @Test
    public void checkLogoYandex()  {
        this.driver = new ChromeDriver();
        this.driver.get("https://qa-scooter.praktikum-services.ru/");
        SamokatHomePage objHomePage = new SamokatHomePage(this.driver);
        objHomePage.logoYandexHomePageClick();
        objHomePage.checkYandexMainPage();
    }

    @Test
    public void checkSamokatLogo() throws InterruptedException {
        this.driver = new ChromeDriver();
        this.driver.get("https://qa-scooter.praktikum-services.ru/");
        SamokatHomePage objHomePage = new SamokatHomePage(this.driver);
        objHomePage.logoSamokatHomePageClick();
        objHomePage.checkSamokatMainPage();
    }

    @Test
    public void checkOrderButton() throws InterruptedException {
        this.driver = new ChromeDriver();
        this.driver.get("https://qa-scooter.praktikum-services.ru/");
        SamokatHomePage objHomePage = new SamokatHomePage(this.driver);
        objHomePage.orderButtonTopHomePageClick();
        objHomePage.checkWeGetAnOrderForm();
    }

    @Test
    public void checkStatusOrderButtonFirstVar() {
        this.driver = new ChromeDriver();
        this.driver.get("https://qa-scooter.praktikum-services.ru/");
        SamokatHomePage objHomePage = new SamokatHomePage(this.driver);
        objHomePage.statusButtonHomePageClick();
        objHomePage.setInputFieldHomePage();
        objHomePage.goButtonHomePageClick();
        objHomePage.checkStatusOrder();
    }

    @Test
    public void checkStatusOrderButtonSecondVar() {
        this.driver = new ChromeDriver();
        this.driver.get("https://qa-scooter.praktikum-services.ru/");
        SamokatHomePage objHomePage = new SamokatHomePage(this.driver);
        objHomePage.setOrderNumberAndClick();
        objHomePage.checkStatusOrder();
    }

    @After
    public void teardown() {
        this.driver.quit();
    }
}
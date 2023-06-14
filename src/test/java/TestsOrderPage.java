import java.time.Duration;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
public class TestsOrderPage {
    private static WebDriver driver;
    OrderPage orderPage;
    AboutRent aboutRent;

    public TestsOrderPage(String name, String surname, String address, String metroStation, String phoneNumber) {
    }

    @Before
    public void pageOpen() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        (new WebDriverWait(driver, Duration.ofSeconds(6L))).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div[1]")));
    }

    @Parameters
    public static Object[][] getTestData() {
        return new Object[][]{{"Иван", "Трикота", "Москва, 13-я Парковая, 27, к. 4, кв. 38", "Щёлковская", "+79991634436"},
                              };
    }
    @Test
    public void fillingTheOrderForm() throws InterruptedException {
        this.orderPage = new OrderPage(driver);
        this.orderPage.setNameFieldOrderPage();
        this.orderPage.setSurnameFieldOrderButton();
        this.orderPage.setAddressFieldOrderButton();
        this.orderPage.setMetroStationOrderButton();
        this.orderPage.setPhoneNumberOrderButton();
        this.orderPage.proceedButtonOrderButtonClick();
        this.aboutRent = new AboutRent(driver);
        this.aboutRent.setNameFieldAboutRent();
        this.aboutRent.setRentTime();
        this.aboutRent.setSamokatColour();
        this.aboutRent.setComment();
        this.aboutRent.pressOrderButton();
        this.aboutRent.confirmMyOrder();
        String actualPage = driver.getCurrentUrl();
        String expectedPage = this.aboutRent.getExpectedPageBug();
        Assert.assertEquals("\n\nОБНАРУЖЕН БАГ!\n\nURL страниц разные, значит, после нажатия на кнопку подтвержения заказа, \nитоговая страница заказа не открылась.", expectedPage, actualPage);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
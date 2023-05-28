import java.time.Duration;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
public class TestsOrderPage {
    private static WebDriver driver;
    OrderPage orderPage;
    AboutRent aboutRent;
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;

    public TestsOrderPage(String name, String surname, String address, String metroStation, String phoneNumber) {
        this.orderPage = new OrderPage(driver);
        this.aboutRent = new AboutRent(driver);
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
    }

    @BeforeClass
    public static void pageOpen() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        (new WebDriverWait(driver, Duration.ofSeconds(3L))).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div[1]")));
    }

    @Parameters
    public static Object[][] getTestData() {
        return new Object[][]{{"Иван", "Тюлькин", "Москва, 13-я Парковая, 27, к. 4, кв. 38", "Щёлковская", "+79991634436"}, {"Маша", "Тюлькин", "Москва, 13-я Парковая, 27, к. 4, кв. 38", "Щёлковская", "+79991634436"}};
    }

    @Test
    public void fillingTheOrderForm() {
        this.orderPage.setNameFieldOrderPage(this.name);
        this.orderPage.setSurnameFieldOrderButton(this.surname);
        this.orderPage.setAddressFieldOrderButton(this.address);
        this.orderPage.setMetroStationOrderButton(this.metroStation);
        this.orderPage.setPhoneNumberOrderButton(this.phoneNumber);
        this.orderPage.proceedButtonOrderButtonClick();
        WebElement expected = driver.findElement(this.orderPage.getFormName());
        WebElement actual = driver.findElement(this.aboutRent.getFormName());
        Assert.assertEquals(expected, actual);
        System.out.println("\nУспешно открылось продолжение заполнения формы " + driver.getCurrentUrl().toString() + "\nПродолжаем заполнять поля для последующего оформления заказа.");
        this.aboutRent.setNameFieldAboutRent();
        this.aboutRent.setRentTime();
        this.aboutRent.setSamokatColour();
        this.aboutRent.setComment();
        this.aboutRent.pressOrderButton();
        this.aboutRent.confirmMyOrder();
        String actualPage = driver.getCurrentUrl().toString();
        String expectedPage = this.aboutRent.getExpectedPageBug();
        Assert.assertEquals("\n\nОБНАРУЖЕН БАГ!\n\nURL страниц разные, значит, после нажатия на кнопку подтвержения заказа, \nитоговая страница заказа не открылась.", expectedPage, actualPage);
        System.out.println("\nУспешно открылась итоговая страница заказа по адресу: " + driver.getCurrentUrl().toString());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
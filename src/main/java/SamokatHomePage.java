import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SamokatHomePage {
    private WebDriver driver;
    private By logoYandexHomePage = By.xpath("/html/body/div/div/div/div[1]/div[1]/a[1]/img");
    private By logoSamokatHomePage = By.xpath("/html/body/div/div/div/div[1]/div[1]/a[2]/img");
    private By orderButtonTopHomePage = By.xpath("/html/body/div/div/div/div[1]/div[2]/button[1]");
    private By statusButtonHomePage = By.xpath("/html/body/div/div/div/div[1]/div[2]/button[2]");
    private By inputFieldHomePage = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/input[1]");
    private final String inputFieldNumberHomePage = "666";
    private By goButtonHomePage = By.xpath("/html/body/div/div/div/div[1]/div[3]/button");
    private By orderButtonFloorHomePage = By.xpath("/html/body/div/div/div/div[4]/div[2]/div[5]/button");
    private By howMuchIsSamokat = By.id("accordion__heading-0");
    private By respond1 = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[1]/div[2]/p");
    String textRespond1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private By severalSamokats = By.id("accordion__heading-1");
    private By rentTime = By.id("accordion__heading-2");
    private By samokat4Today = By.id("accordion__heading-3");
    private By stopRent = By.id("accordion__heading-4");
    private By charging = By.id("accordion__heading-5");
    private By cancelOrder = By.id("accordion__heading-6");
    private By outsideMoscow = By.id("accordion__heading-7");

    public SamokatHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void logoYandexHomePageClick() {
        this.driver.findElement(this.logoYandexHomePage).click();
        this.driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
    }

    public void checkYandexMainPage() {
        String handle = this.driver.getWindowHandles().toArray()[1].toString();
        this.driver.switchTo().window(handle);
        String expected = this.driver.getCurrentUrl().toString();
        String actual = "https://dzen.ru/?yredirect=true";
        Assert.assertEquals("В новом окне не открывается главная страница \"Яндекса\"", expected, actual);
        System.out.println("\nВ новом окне открылась главная страница \"Яндекса\" " + this.driver.getCurrentUrl().toString());
    }

    public void logoSamokatHomePageClick() {
        this.driver.findElement(this.logoSamokatHomePage).click();
        this.driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
    }

    public void checkSamokatMainPage() {
        String handle = this.driver.getWindowHandles().toArray()[0].toString();
        this.driver.switchTo().window(handle);
        String expected = this.driver.getCurrentUrl().toString();
        String actual = "https://qa-scooter.praktikum-services.ru/";
        Assert.assertEquals("В новом окне открывается главная страница \"Яндекса\"", expected, actual);
        System.out.println("\nГлавная страница \"Самоката\" при нажатии на лого не открывается.\nМы продолжаем оставаться на той же страничке по следующему адресу: \n" + this.driver.getCurrentUrl().toString());
    }

    public void orderButtonTopHomePageClick() {
        this.driver.findElement(this.orderButtonTopHomePage).click();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
    }

    public void checkWeGetAnOrderForm() {
        String expected = "https://qa-scooter.praktikum-services.ru/order";
        String actual = this.driver.getCurrentUrl().toString();
        Assert.assertEquals("\nФорма заказа не открылась... ", expected, actual);
        System.out.println("\nМы перешли на форму заказа самоката по следующему адресу: " + expected);
    }

    public void statusButtonHomePageClick() {
        this.driver.findElement(this.statusButtonHomePage).click();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
    }

    public void setInputFieldHomePage() {
        this.driver.findElement(this.inputFieldHomePage).isEnabled();
        this.driver.findElement(this.inputFieldHomePage).clear();
        this.driver.findElement(this.inputFieldHomePage).sendKeys(new CharSequence[]{"666"});
    }

    public void goButtonHomePageClick() {
        this.driver.findElement(this.goButtonHomePage).click();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
    }

    public void checkStatusOrder() {
        String expected = "https://qa-scooter.praktikum-services.ru/track?t=666";
        String actual = this.driver.getCurrentUrl().toString();
        Assert.assertEquals("\nФорма заказа не открылась... ", expected, actual);
        System.out.println("\nМы перешли на форму заказа самоката по следующему адресу: " + expected + "\nтакого заказа не существует, так как номер заказа пробный, в целях проверки перехода на страницу статуса заказа по номеру.");
    }

    public void orderButtonFloorHomePageClick() {
        WebElement element = this.driver.findElement(orderButtonFloorHomePage);
        ((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView();", new Object[]{element});
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3L));
        this.driver.findElement(this.orderButtonFloorHomePage).click();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
    }

    public void checkWeGetAnOrderForm2() {
        String expected = "https://qa-scooter.praktikum-services.ru/order";
        String actual = this.driver.getCurrentUrl().toString();
        Assert.assertEquals("\nФорма заказа не открылась... ", expected, actual);
        System.out.println("\nМы перешли на форму заказа самоката по следующему адресу: " + expected);
    }

    public void howMuchIsSamokatClick() {
        this.driver.findElement(this.howMuchIsSamokat).click();
    }

    public void severalSamokatsClick() {
        this.driver.findElement(this.severalSamokats).click();
    }

    public void rentTimeClick() {
        this.driver.findElement(this.rentTime).click();
    }

    public void samokat4TodayClick() {
        this.driver.findElement(this.samokat4Today).click();
    }

    public void stopRentClick() {
        this.driver.findElement(this.stopRent).click();
    }

    public void chargingClick() {
        this.driver.findElement(this.charging).click();
    }

    public void cancelOrderClick() {
        this.driver.findElement(this.cancelOrder).click();
    }

    public void outsideMoscowClick() {
        this.driver.findElement(this.outsideMoscow).click();
    }

    public void setOrderNumberAndClick() {
        this.statusButtonHomePageClick();
        this.setInputFieldHomePage();
        this.goButtonHomePageClick();
    }

    public By getRespond1() {
        return this.respond1;
    }
}
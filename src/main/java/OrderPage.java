import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver driver;
    private By formName = By.xpath("/html/body/div/div/div[2]/div[1]");
    private By nameFieldOrderButton = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/input");
    private By surnameFieldOrderButton = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/input");
    private By addressFieldOrderButton = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/input");
    private By metroStationOrderButton = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div/input");
    private By shel40k = By.className("Order_Text__2broi");
    private By phoneNumberOrderButton = By.xpath("/html/body/div/div/div[2]/div[2]/div[5]/input");
    private By proceedButtonOrderButton = By.xpath("/html/body/div/div/div[2]/div[3]/button");
    final String name = "Иван";
    final String surname = "Тюлькин";
    final String address = "Москва, 13-я Парковая, 27, к. 4, кв. 38";
    final String metroStation = "Щёлковская";
    final String phoneNumber = "+79991634436";

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setNameFieldOrderPage(String string) {
        this.driver.findElement(this.nameFieldOrderButton).isEnabled();
        this.driver.findElement(this.nameFieldOrderButton).clear();
        this.driver.findElement(this.nameFieldOrderButton).sendKeys(new CharSequence[]{name});
    }

    public void setSurnameFieldOrderButton(String string) {
        this.driver.findElement(this.surnameFieldOrderButton).isEnabled();
        this.driver.findElement(this.surnameFieldOrderButton).clear();
        this.driver.findElement(this.surnameFieldOrderButton).sendKeys(new CharSequence[]{surname});
    }

    public void setAddressFieldOrderButton(String string) {
        this.driver.findElement(this.addressFieldOrderButton).isEnabled();
        this.driver.findElement(this.addressFieldOrderButton).clear();
        this.driver.findElement(this.addressFieldOrderButton).sendKeys(new CharSequence[]{address});
    }

    public void setMetroStationOrderButton(String string) {
        this.driver.findElement(this.metroStationOrderButton).click();
        this.driver.findElement(this.metroStationOrderButton).sendKeys(new CharSequence[]{metroStation});
        this.driver.findElement(this.shel40k).click();
    }

    public void setPhoneNumberOrderButton(String string) {
        this.driver.findElement(this.phoneNumberOrderButton).isEnabled();
        this.driver.findElement(this.phoneNumberOrderButton).clear();
        this.driver.findElement(this.phoneNumberOrderButton).sendKeys(new CharSequence[]{phoneNumber});
    }

    public void proceedButtonOrderButtonClick() {
        this.driver.findElement(this.proceedButtonOrderButton).click();
    }

    public void fillingTheOrderForm() {
        this.setNameFieldOrderPage(name);
        this.setSurnameFieldOrderButton(surname);
        this.setAddressFieldOrderButton(address);
        this.setMetroStationOrderButton(metroStation);
        this.setPhoneNumberOrderButton(phoneNumber);
        this.proceedButtonOrderButtonClick();
    }

    public By getFormName() {
        return this.formName;
    }
}

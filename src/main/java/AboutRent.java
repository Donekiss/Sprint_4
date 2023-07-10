import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AboutRent {
    private WebDriver driver;
    private By nameOfThePage = By.className("Order_Header__BZXOb");
    //private By formName = By.xpath("/html/body/div/div/div[2]/div[1]");
    private By whenBringSamokat = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div/div/input");
    private By rentTime = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/div[1]");
    private By rentFor2Days = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[2]");
    private By samokatColourBlackPerl = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/label[1]");
    private By samokatColourGreyHopelessness = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/label[2]");
    private By comment = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/input");
    private String commentCourier = "Могу ли я забрать самокат прямо возле метро \"Щёлковская\" на 4-м выходе?";
    private By backButton = By.xpath("/html/body/div/div/div[2]/div[3]/button[1]");
    private By makeOrder = By.xpath("/html/body/div/div/div[2]/div[3]/button[2]");
    private By confirmButton = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]"); //
    private String expectedPageBug = "https://qa-scooter.praktikum-services.ru/track?t=723106";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    String date;

    public AboutRent(WebDriver driver) {
        this.date = LocalDate.now().plusDays((long)this.getRandomDiceNumber()).format(this.formatter);
        this.driver = driver;
    }

    //public By getFormName() {
    //    return this.formName;
    //}

    public String getExpectedPageBug() {
        return this.expectedPageBug;
    }

    public void setNameFieldAboutRent() {
        this.driver.findElement(this.whenBringSamokat).click();
        this.driver.findElement(this.whenBringSamokat).sendKeys(new CharSequence[]{this.date});
        this.driver.findElement(this.whenBringSamokat).sendKeys(new CharSequence[]{Keys.ENTER});
    }

    public int getRandomDiceNumber() {
        return (int)(Math.random() * 4.0) + 1;
    }

    public void setRentTime() {
        this.driver.findElement(this.rentTime).click();
        this.driver.findElement(this.rentFor2Days).click();
    }

    public void setSamokatColour() {
        this.driver.findElement(this.samokatColourBlackPerl).click();
    }

    public void setComment() {
        this.driver.findElement(this.comment).click();
        this.driver.findElement(this.comment).sendKeys(new CharSequence[]{this.commentCourier});
    }

    public void pressOrderButton() {
        this.driver.findElement(this.makeOrder).click();
    }

    public void confirmMyOrder() {
        (new WebDriverWait(this.driver, Duration.ofSeconds(6L))).until(ExpectedConditions.visibilityOfElementLocated(this.confirmButton));
        this.driver.findElement(this.confirmButton).click();
    }
}
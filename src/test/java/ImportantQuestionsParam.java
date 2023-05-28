import java.time.Duration;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
public class ImportantQuestionsParam {
    private static WebDriver driver;
    private String answer;
    private int numberAnswer;

    public ImportantQuestionsParam(String answer, int numberAnswer) {
        this.answer = answer;
        this.numberAnswer = numberAnswer;
    }

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        (new WebDriverWait(driver, Duration.ofSeconds(3L))).until(ExpectedConditions.visibilityOfElementLocated(By.className("Home_Header__iJKdX")));
    }

    @Parameters
    public static Object[][] getTestData() {
        return new Object[][]{{"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0}, {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1}, {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2}, {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3}, {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4}, {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", 5}, {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6}, {"Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7}};
    }

    @Test
    public void checkQuestions() {
        String xpathExpression = ".//div[@id='accordion__heading-" + this.numberAnswer + "']";
        WebElement element = driver.findElement(By.xpath(xpathExpression));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", new Object[]{element});
        driver.findElement(By.xpath(xpathExpression)).click();
        String actual = driver.findElement(By.xpath(".//div[@aria-labelledby='accordion__heading-" + this.numberAnswer + "']//p")).getAttribute("textContent");
        Assert.assertEquals(this.answer, actual);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}

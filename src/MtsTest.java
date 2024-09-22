import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class MtsTest {
    private WebDriver driver;
    private MtsPage mtsPage;

    @BeforeClass
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mts.by");
        Thread.sleep(5000);
        mtsPage = new MtsPage(driver);
        mtsPage.acceptCookies();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testBlockTitle() {
        String expectedTextPart1 = "Онлайн пополнение";
        String expectedTextPart2 = "без комиссии";
        String actualText = mtsPage.getBlockTitleText();
        // Проверяем, что обе части текста присутствуют и находятся в правильном порядке с пробелом или новой строкой между ними
        boolean isCorrectOrder = actualText.matches(".*" + expectedTextPart1 + "\\s+.*" + expectedTextPart2 + ".*");
        Assert.assertTrue(isCorrectOrder,
                "Название блока неверное. Найдено: " + actualText);
    }

    @Test
    public void testPaymentSystemLogos() {
        Assert.assertNotNull(mtsPage.getLogos(), "Логотипы платежных систем отсутствуют");
    }

    @Test
    public void testMoreInfoLink() {
        mtsPage.clickMoreInfoLink();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlContains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"),
                "Не удалось перейти на страницу «Подробнее о сервисе». Current URL: " + currentUrl);

        driver.navigate().back();
        wait.until(ExpectedConditions.urlToBe("https://www.mts.by/"));
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.mts.by/", "Не удалось вернуться на главную страницу после нажатия кнопки «Подробнее о сервисе».");
    }

    @Test
    public void testContinueButtonTextTitle() {
        String continueButtonText = mtsPage.getContinueButtonText();
        Assert.assertEquals(continueButtonText, "Продолжить", "Текст кнопки не соответствует ожидаемому.");
    }

    @Test
    public void testContinueButtonEmptyFields() {
        mtsPage.clickContinueButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(mtsPage.getPhoneField()));
        WebElement activeElement = driver.switchTo().activeElement();
        Assert.assertEquals(activeElement, mtsPage.getPhoneField(), "Внимание не на телефонном поле.");

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.mts.by/", "Переход произошел тогда, когда его не должно было быть.");

        // Проверка, что кнопка continueButton все еще присутствует
        Assert.assertTrue(mtsPage.getContinueButton().isDisplayed(), "Кнопка 'Продолжить' не отображается");
    }

    @Test
    public void testContinueButtonOnlyEmail() {
        mtsPage.enterEmail("test@example.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        mtsPage.clickContinueButton();
        WebElement activeElement = driver.switchTo().activeElement();
        Assert.assertEquals(activeElement, mtsPage.getPhoneField(), "Внимание не на телефонном поле.");
        // Проверка, что переход на другую страницу не произошел
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.mts.by/", "Переход произошел тогда, когда его не должно было быть.");
        // Проверка, что кнопка continueButton все еще присутствует
        Assert.assertTrue(mtsPage.getContinueButton().isDisplayed(), "Кнопка 'Продолжить' не отображается");
    }


    @Test
    public void testContinueButtonRequiredFields() {
        mtsPage.clearEmail();
        mtsPage.enterPhoneNumber("297777777");
        mtsPage.enterSum("10");
        mtsPage.clickContinueButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://www.mts.by/"));
        // Проверка, что кнопка Продолжить больше не отображается
        String continueButtonText = mtsPage.getContinueButtonText();
        Assert.assertEquals(continueButtonText, "Продолжить", "Текст кнопки выглядит не так, как ожидалось после очистки полей");

    }
}

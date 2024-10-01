import org.openqa.selenium.By;
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

public class MtsHomeTest {
    private WebDriver driver;
    private MtsPage mtsPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://mts.by");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        mtsPage = new MtsPage(driver);
        mtsPage.acceptCookies();
    }



    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 1)
    public void getPaymentFrame() throws InterruptedException {
        mtsPage.enterPhoneNumber("297777777");
        mtsPage.enterSum("10");
        mtsPage.enterEmail("test@example.com.com");
        mtsPage.clickContinueButton();

        // Ожидание загрузки фрейма
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@style='visibility: visible;'][1]")));
        //  System.out.println("Перешли на фрейм оплаты");
    }

    @Test(priority = 2)
    public void checkSumma() {
        // 1. Проверка, что сумма на форме оплаты равна сумме введенной на предыдущей форме)
        WebElement summa = driver.findElement(By.xpath("//div[@class='pay-description__cost']/span[text()='10.00 BYN']"));
        Assert.assertEquals("10.00 BYN", summa.getAttribute("innerHTML"), "Сумма оплаты не соответствует введенной");
    }

    @Test(priority = 3)
    public void checkSummaButton() {
        // 2. Проверка, что сумма на кнопке присутсвует и что сумма равна сумме введенной на предыдущей форме)
        WebElement summaButton = driver.findElement(By.xpath("//button[@class='colored disabled'][contains(text(), 'Оплатить  10.00 BYN')]"));
        Assert.assertEquals(" Оплатить  10.00 BYN <!---->", summaButton.getAttribute("innerHTML"), "Сумма на кнопке не соответствует введенной");
    }

    @Test(priority = 4)
    public void checkPhoneNumber() {
        // 3. Проверка, что номер телефона на форме оплаты присутсвует и он равен ("297777777")
        WebElement phoneNumber = driver.findElement(By.xpath("//div[@class='pay-description__text']/span[contains(text(), 'Номер:375297777777')]"));
        Assert.assertEquals("Оплата: Услуги связи\nНомер:375297777777", phoneNumber.getAttribute("innerHTML"), "Номер телефона не соответствует");
    }

    @Test(priority = 5)
    public void checkCardNumberPlaceholder() {
        // 4. Проверка, что плейсхолдер "Номер Карточки" присутствует в поле для ввода кредитной карты
        WebElement cardNumberPlaceholder = driver.findElement(By.xpath("//label[@class='ng-tns-c46-1 ng-star-inserted'][text()='Номер карты']"));
        Assert.assertEquals("Номер карты", cardNumberPlaceholder.getAttribute("innerHTML"), "Плейсхолдер 'Номер Карты' не отображается");
    }

    @Test(priority = 6)
    public void checkCardExpirationPlaceholder() {
        // 5. Проверка, что плейсхолдер "Срок Действия" присутствует в поле для ввода срока кредитной карты
        WebElement cardExpirationPlaceholder = driver.findElement(By.xpath("//label[@class='ng-tns-c46-4 ng-star-inserted'][text()='Срок действия']"));
        Assert.assertEquals("Срок действия", cardExpirationPlaceholder.getAttribute("innerHTML"), "Плейсхолдер 'Срок Действия' не отображается");
    }

    @Test(priority = 7)
    public void checkCVCPlaceholder() {
        // 6. Проверка, что плейсхолдер "CVC" присутствует в поле для ввода
        WebElement cvcPlaceholder = driver.findElement(By.xpath("//label[@class='ng-tns-c46-5 ng-star-inserted'][text()='CVC']"));
        Assert.assertEquals("CVC", cvcPlaceholder.getAttribute("innerHTML"), "Плейсхолдер 'CVC' не отображается");
    }

    @Test(priority = 8)
    public void checkCardholderNamePlaceholder() {
        // 7. Проверка, что плейсхолдер "Имя как на карте" присутствует в поле для ввода имени держателя карты
        WebElement cardholderNamePlaceholder = driver.findElement(By.xpath("//label[@class='ng-tns-c46-3 ng-star-inserted'][text()='Имя держателя (как на карте)']"));
        Assert.assertEquals("Имя держателя (как на карте)", cardholderNamePlaceholder.getAttribute("innerHTML"), "Плейсхолдер 'Имя держателя (как на карте)' не отображается");
    }

    @Test(priority = 9)
    public void checkMastercardIcon() {
        // 8. Проверка, что иконка "МастрКард" присутствует на форме оплаты
        WebElement mastercardIcon = driver.findElement(By.xpath("//img[@class='ng-tns-c61-0 ng-star-inserted'][@src='assets/images/payment-icons/card-types/mastercard-system.svg']"));
        Assert.assertTrue(mastercardIcon.isDisplayed(), "Иконка 'Mastercard' не отображается");
    }

    @Test(priority = 10)
    public void checkVisaIcon() {
        // 9. Проверка, что иконка "Visa" присутствует на форме оплаты
        WebElement visaIcon = driver.findElement(By.xpath("//img[@class='ng-tns-c61-0 ng-star-inserted'][@src='assets/images/payment-icons/card-types/visa-system.svg']"));
        Assert.assertTrue(visaIcon.isDisplayed(), "Иконка 'Visa' не отображается");
    }

    @Test(priority = 11)
    public void checkBelCardIcon(){
        // 10. Проверка, что иконка "BelCard" присутствует на форме оплаты
        WebElement belCardIcon = driver.findElement(By.xpath("//img[@class='ng-tns-c61-0 ng-star-inserted'][@src='assets/images/payment-icons/card-types/belkart-system.svg']"));
        Assert.assertTrue(belCardIcon.isDisplayed(), "Иконка 'BelCard' не отображается");
    }

    @Test(priority = 12)
    public void checkMirOrMaestroIcon() {
        // 11. Проверка, что иконка "MIR" или "Маестро" присутствует на форме оплаты
        WebElement mirIcon = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/div/img[2]"));
        WebElement maestroIcon = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/div/img[1]"));
        boolean isMirOrMaestroDisplayed = mirIcon.isDisplayed() || maestroIcon.isDisplayed();
        Assert.assertTrue(isMirOrMaestroDisplayed, "Иконка 'MIR' или 'Маестро' не отображается");

        driver.switchTo().defaultContent();

    }
}

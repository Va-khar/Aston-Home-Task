import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MtsTest1 {
    private WebDriver driver;
    private MtsPage mtsPage;
    private Actions action;

    @BeforeClass
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://mts.by");
        Thread.sleep(5000);
        mtsPage = new MtsPage(driver);
        mtsPage.acceptCookies();
        action = new Actions(driver);
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 1)
    public void checkServicesPlanPlaceholders() throws InterruptedException {
        action.scrollToElement(driver.findElement(By.className("pay__partners")));
        action.moveToElement(driver.findElement(By.className("select__now"))).build().perform();
        // Проверить, что План Услуги Связи выбран по умолчанию
        Assert.assertTrue(mtsPage.isServicesPlanSelectedDisplayed(), "По умолчанию выбран план 'Услуги связи'");
        // Проверка правильности значения placeholder 'Номер телефона'
        Assert.assertTrue(mtsPage.isNumberPhonePlaceholderServicesDisplayed(), "Плейсхолдер «Номер телефона» присутствует");
        // Проверка правильности значения placeholder "Сумма"
        WebElement inputSummaServices = driver.findElement(By.id("connection-sum"));
        String placeholderServicesValue = inputSummaServices.getAttribute("placeholder");
        String expectedPlaceholderServicesValue = "Сумма";
        Assert.assertEquals(placeholderServicesValue, expectedPlaceholderServicesValue, "Значение плейсхолдер 'Сумма' не соответствует ожидаемому.");
        // Проверка правильности значения placeholder 'E-mail для отправки чека'
        WebElement inputEmail = driver.findElement(By.id("connection-email"));
        String emailPlaceholderValue = inputEmail.getAttribute("placeholder");
        String expectedEmailPlaceholderValue = "E-mail для отправки чека";
        Assert.assertEquals(emailPlaceholderValue, expectedEmailPlaceholderValue, "Значение плейсхолдер 'E-mail' не соответствует ожидаемому.");
    }

    @Test(priority = 2)
    public void checkHomeInternetPlanPlaceholders() throws InterruptedException {
        // Выбор "Домашний интернет" из списка
        action.moveToElement(driver.findElement(By.className("select__now"))).build().perform();
        driver.findElement(By.xpath("//span[@class='select__now']")).click();
        Thread.sleep(2000);
        //Нажимаем на кнопку услуги Домашний интернет
        driver.findElement(By.xpath("//li[@class='select__item']/p[text()='Домашний интернет']")).click();
        Thread.sleep(2000);
        // Проверка правильности значения placeholder 'Номер абонента'
        Assert.assertTrue(mtsPage.isNumberInternetHomePlaceholderDisplayed(), "Плейсхолдер 'Номер абонента' присутствует.");
        // Проверка правильности значения placeholder 'Сумма'
        Assert.assertTrue(mtsPage.isSummaInternetHomePlaceholderDisplayed(), "Плейсхолдер 'Сумма' присутствует");
        // Проверка правильности значения placeholder 'E-mail для отправки чека'
        Assert.assertTrue(mtsPage.isEmailInternetHomePlaceholderDisplayed(), "Плейсхолдер 'E-mail для отправки чека' присутствует");
    }

    @Test(priority = 3)
    public void checkInstalmentPlanPlaceholders() throws InterruptedException {
        // Выбор "Рассрочка" из списка
        action.moveToElement(driver.findElement(By.className("select__now"))).build().perform();
        driver.findElement(By.xpath("//span[@class='select__now']")).click();
        Thread.sleep(2000);
        //Нажимаем на кнопку услуги Рассрочка
        driver.findElement(By.xpath("//li[@class='select__item']/p[text()='Рассрочка']")).click();
        Thread.sleep(2000);
        // Проверка правильности значения placeholder 'Номер счета на 44'
        Assert.assertTrue(mtsPage.isNumberAccountPlaceholderDisplayed(), "Плейсхолдер 'Номер счета на 44' присутствует");
        // Проверка правильности значения placeholder 'Сумма'
        Assert.assertTrue(mtsPage.isSummaPlaceholderDisplayed(), "Плейсхолдер 'Сумма' присутствует");
        // Проверка правильности значения placeholder 'E-mail для отправки чека'
        Assert.assertTrue(mtsPage.isEmailPlaceholderDisplayed(), "Плейсхолдер 'E-mail для отправки чека' присутствует");
    }

    @Test(priority = 4)
    public void checkArrearsPlanPlaceholders() throws InterruptedException {
        // Выбор "Задолженность" из списка
        action.moveToElement(driver.findElement(By.className("select__now"))).build().perform();
        driver.findElement(By.xpath("//span[@class='select__now']")).click();
        Thread.sleep(2000);
        //Нажимаем на кнопку услуги Задолженность
        driver.findElement(By.xpath("//li[@class='select__item']/p[text()='Задолженность']")).click();
        Thread.sleep(2000);
        // Проверка правильности значения placeholder 'Номер счета на 2073'
        Assert.assertTrue(mtsPage.isNumberAccountArrearsPlaceholderDisplayed(), "Плейсхолдер 'Номер счета на 2073' присутствует");
        // Проверка правильности значения placeholder 'Сумма'
        Assert.assertTrue(mtsPage.isSummaArrearsPlaceholderDisplayed(), "Плейсхолдер 'Сумма' присутствует");
        // Проверка правильности значения placeholder 'E-mail для отправки чека'
        Assert.assertTrue(mtsPage.isEmailArrearsPlaceholderDisplayed(), "Плейсхолдер 'E-mail для отправки чека' присутствует");
    }
}

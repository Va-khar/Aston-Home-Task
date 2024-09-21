import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class MtsBase {
    @Test
    public void Test() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        Thread.sleep(5000);
        acceptCookies(driver);
        checkBlockTitle(driver);
        checkLogos(driver);
        checkMoreInfoLink(driver);
        checkContinueButtonAllFields(driver);
        driver.quit();
    }

    private static void acceptCookies(WebDriver driver) {
        try {
            WebElement acceptCookiesButton = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[2]/div/div[2]/button[3]"));
            acceptCookiesButton.click();
            System.out.println("Cookies приняты");
        } catch (Exception e) {
            System.err.println("Кнопка принятия cookie не найдена или не может быть нажата");
        }
    }

    private static void checkBlockTitle(WebDriver driver) {
        WebElement blockTitle = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/h2"));
        if (blockTitle != null) {
            Actions actions = new Actions(driver);
            actions.moveToElement(blockTitle).perform();
            String expectedTextPart1 = "Онлайн пополнение";
            String expectedTextPart2 = "без комиссии";
            String actualText = blockTitle.getText().replace("\n", " ");

            if (actualText.contains(expectedTextPart1) && actualText.contains(expectedTextPart2)) {
                System.out.println("Название блока верное: " + actualText);
            } else {
                System.err.println("Название блока неверное. Найдено: " + actualText);
            }
        } else {
            System.err.println("Название блока не найдено");
        }
    }

    private static void checkLogos(WebDriver driver) {
        List<String> expectedLogos = Arrays.asList(
                "Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт"
        );
        List<WebElement> logos = driver.findElements(By.xpath("//div[contains(@class, 'pay__partners')]//img"));

        if (logos != null && logos.size() == expectedLogos.size()) {
            System.out.println("Присутствуют логотипы платежных систем");
            boolean allLogosCorrect = true;
            for (int i = 0; i < expectedLogos.size(); i++) {
                String expectedLogo = expectedLogos.get(i);
                WebElement logo = logos.get(i);
                String actualLogoAlt = logo.getAttribute("alt");
                if (!expectedLogo.equals(actualLogoAlt)) {
                    allLogosCorrect = false;
                    System.err.println("Логотип на месте " + (i + 1) + " неверно. Ожидается: " + expectedLogo + ", Found: " + actualLogoAlt);
                } else {
                    System.out.println("Логотип на месте " + (i + 1) + " верно: " + actualLogoAlt);
                }
            }
            if (allLogosCorrect) {
                System.out.println("Все логотипы платежных систем расположены в правильном порядке");
            } else {
                System.err.println("Логотипы некоторых платежных систем расположены в неправильном порядке");
            }
        } else {
            System.err.println("Логотипы платежных систем отсутствуют или подсчет ведется неверно");
        }
    }

    public static void checkMoreInfoLink(WebDriver driver) {
        WebElement moreInfoLink = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/a"));

        if (moreInfoLink != null && moreInfoLink.isDisplayed()) {
            System.out.println("Ссылка 'Подробнее о сервисе' присутствует");
            Actions actions = new Actions(driver);
            actions.moveToElement(moreInfoLink).perform();
            moreInfoLink.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));

            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/")) {
                System.out.println("Успешно перешел на страницу 'Подробнее о сервисе'");
            } else {
                System.err.println("Не удалось перейти на страницу 'Подробнее о сервисе'. Current URL: " + currentUrl);
            }
        } else {
            System.err.println("Ссылка 'Подробнее о сервисе' отсутствует или не отображается");
        }
    }

    public static void checkContinueButtonAllFields(WebDriver driver) {
        driver.get("https://mts.by");

        WebElement service = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button/span[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(service).perform();

        WebElement phoneField = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[1]/div[2]/form[1]/div[1]/input"));
        WebElement sumField = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[1]/div[2]/form[1]/div[2]/input"));
        WebElement emailField = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[1]/div[2]/form[1]/div[3]/input"));

        phoneField.sendKeys("297777777");
        sumField.sendKeys("10");
        emailField.sendKeys("testarkhip@yandex.ru");

        WebElement continueButton = driver.findElement(By.xpath("/html/body/div[6]/main/div/div[4]/div[1]/div/div/div[2]/section/div/div[1]/div[2]/form[1]/button"));
        continueButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        String currentUrl = driver.getCurrentUrl();
        if (!currentUrl.equals("https://mts.by")) {
            System.out.println("Тест пройден");
        } else {
            System.err.println("Тест не пройден");
        }
    }
}

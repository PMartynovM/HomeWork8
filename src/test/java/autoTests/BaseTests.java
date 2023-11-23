package autoTests;

import Work8.MainPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class BaseTests {
    WebDriver webDriver;
    MainPage mainPage;

    @Test
    public void checkBoxTest() {
        webDriver = new ChromeDriver();
        mainPage = new MainPage(webDriver);

//        String userName = "tomsmith";
//        String userPassWord = "SuperSecretPassword!";

        String waitElement = "//*[@id=\"checkboxes\"]/input[1]";

        mainPage.goToCheckBoxClick();
        //        log.info("Открыли страницу с чекбоксами");
        mainPage.checkBoxClick();
        //        log.info("Кликнул чекбокс 1");
        mainPage.waitCheckBox(waitElement);
        //        log.info("Ждём, когда чекбокс отметится");
        String feedbackCheckBoxPass = String.valueOf(webDriver.findElement(By.xpath(waitElement)).isSelected());
        System.out.println("выбранный чекбокс кликнут? " + feedbackCheckBoxPass);

    }

    @Test
    public void hovers() {
        webDriver = new ChromeDriver();
        mainPage = new MainPage(webDriver);

        String avatar = "//*[@id=\"content\"]/div/div[2]/div";

        mainPage.goToTheHovers();
        mainPage.curseToAvatarTwo();
        mainPage.findInfo(avatar);
    }


    //  Далее идут "неправильные тесты" сделал для того что они в данном  случае быстрее в исполнении




    @Test
    public void checkBoxTests() throws InstantiationException {
        webDriver = new ChromeDriver();
        webDriver.get("https://the-internet.herokuapp.com/checkboxes");


        WebElement checkBoxOne = webDriver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        checkBoxOne.click();

        WebDriverWait driverWait = new WebDriverWait(webDriver,5,500);
        driverWait.until(ExpectedConditions.elementToBeSelected(By.xpath("//*[@id=\"checkboxes\"]/input[1]")));
        String feedbackCheckBoxPass = String.valueOf(webDriver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).isSelected());
        System.out.println(feedbackCheckBoxPass);

    }

    @Test
    public void formAuthenticationTestsPositive() throws InstantiationException {
        webDriver = new ChromeDriver();
        webDriver.get("https://the-internet.herokuapp.com/login");

        WebElement userName = webDriver.findElement(By.cssSelector("#username"));
        WebElement passWord = webDriver.findElement(By.cssSelector("#password"));
        WebElement loginButton = webDriver.findElement(By.cssSelector("#login > button > i"));

        userName.sendKeys("tomsmith");
        passWord.sendKeys("SuperSecretPassword!");
        loginButton.click();

        webDriver.get("https://the-internet.herokuapp.com/secure");

        WebDriverWait driverWait = new WebDriverWait(webDriver,30,500);
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div/a/i")));
        String feedbackPositivePass = webDriver.findElement(By.cssSelector("#content > div > a")).getText();
        System.out.println(feedbackPositivePass);

    }

    @Test
    public void formAuthenticationTestsNegative() throws InstantiationException {
        webDriver = new ChromeDriver();
        webDriver.get("https://the-internet.herokuapp.com/login");

        WebElement userName = webDriver.findElement(By.cssSelector("#username"));
        WebElement passWord = webDriver.findElement(By.cssSelector("#password"));
        WebElement loginButton = webDriver.findElement(By.cssSelector("#login > button > i"));

        userName.sendKeys("tomsmithNegative");
        passWord.sendKeys("SuperSecretPassword!Negative");
        loginButton.click();

        WebDriverWait driverWait = new WebDriverWait(webDriver, 30, 500);
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"flash\"]/a")));
        String feedbackNegativePass = webDriver.findElement(By.xpath("//*[@id=\"flash\"]")).getText();
        System.out.println(feedbackNegativePass);

    }

    @Test
    public void hoversTest() throws InstantiationException {
        webDriver = new ChromeDriver();
        webDriver.get("https://the-internet.herokuapp.com/hovers");

        WebElement personTwo = webDriver.findElement(By.cssSelector(""));
    }


    @After
    public void closePage() {
        if (webDriver != null) {
            webDriver.close();
        }
    }
}
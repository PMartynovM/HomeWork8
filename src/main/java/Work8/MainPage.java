package Work8;

import groovy.util.logging.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class MainPage {
    private final WebDriver webDriver;
    private final WebDriverWait driverWait;
    private final String URI = "https://the-internet.herokuapp.com/";
    private final int TIMEOUT = 30;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
//        webDriver.manage().window().fullscreen();
        webDriver.get(URI);
        driverWait = new WebDriverWait(webDriver, TIMEOUT, 500);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/ul/li[6]/a")
    public WebElement clickToCheckBoxesTest;

    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input[1]")
    public WebElement checkBoxOne;

    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input[1]")
    public WebElement elementWaitCheckBox;

    @FindBy(css = "#username")
    public WebElement userNameInput;

    @FindBy(css = "#password")
    public WebElement userPassWordInput;

    @FindBy(css = "#login > button > i")
    public WebElement loginButton;

    public void goToCheckBoxClick() {
        clickToCheckBoxesTest.click();
    }

    public void checkBoxClick() {
        checkBoxOne.click();
    }

    public void waitCheckBox(String element) {
        driverWait.until(ExpectedConditions.elementToBeSelected(By.xpath(element)));
    }

    public void fillNameAndPassWord(String name, String password) {
        userNameInput.sendKeys(name);
        userPassWordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    @FindBy(xpath = " //*[@id=\"content\"]/ul/li[25]/a")
    public WebElement goToHovers;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/img")
    public WebElement userAvatarTwo;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div")
    public WebElement avatarInfoTwo;

    public void curseToAvatarTwo() {
        userAvatarTwo.click();
    }

    public void goToTheHovers() {
        goToHovers.click();
    }

    public void findInfo(String avatar) {
        System.out.println(webDriver.findElement(By.xpath(avatar)).getText());
    }

}

package Group;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Utils extends BasePage{

    public static void toLaunchChromeBrowser(){
        System.setProperty("webdriver.chrome.driver","src\\main\\Resources\\BrowserDrivers\\chromedriver.exe");
        // To open the Chrome Browser
        driver = new ChromeDriver();
        //To maximise the browser screen
        driver.manage().window().fullscreen();
        //To set the implicity wait for the driver object
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
    }

    // 1 Method to quit the Browser
    public static void closebrowser() {

        driver.quit();
    }

    // 2 Method for instructing Browser to click a Element
    public void clickOnElement(By by){
    driver.findElement(by).click();
    }

    // 3 Method to instruct the driver to send keys
    public void EnterText(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }

    // 4 Method for instructing browser to get text
    public String extractText(By by){
        return driver.findElement(by).getText();
    }

    // 5 Method for instructing the browser for waiting to Click
    public static void waitForClickable(By by, long time){
    WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    // 6 Method for instructing the element to be visible
    public static void waitForElementVisible(By by, long time){
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    // 7 Method for instructing driver to wait for Alert
    public static void waitForAlertPresent(long time){
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    // 8 Method for Date Stamp Short
    public  String randomDateSort(){
        DateFormat format = new SimpleDateFormat("ddMMyy");
        return format.format(new Date());}


    // 9 Method to generate random date
    public static String randomDate(){
        DateFormat format = new SimpleDateFormat("ddMMyyHHmmss");
    return format.format(new Date());
    }

    // 10 Method to generate email
    public static String generateEmail(By email, String s){
        return "test" + randomDate() + "@bmail.com";
    }

    // 11 Method to clear locator
    public static void clearLocator(By by){
        driver.findElement(by).clear();
    }

    // 12 Method to clear locator and enter a element
    public void clearLocatorandEnter(By by, String text){
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    // 13 Method to select by Value from dropdown
    public void selectByValue(By by, String value){
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }

    // 14 Method to select by Visible text from dropdown
    public void selectByVisibletext(By by, String text){
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    // 15 Method to select by Index from dropdown
    public void selectByIndextext(By by, int n){
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(n);
      }

      // 16 Method to check dropdown present or not
    public void dropdownPresentorNot(By by){
        Select select = new Select(driver.findElement(by));
        select.getOptions();
    }

    // 17 Method to get Attributes
    public String getAttributes(By by, String text)
    {
        return driver.findElement(by).getAttribute(text);
    }

    // 18 Method to Navigate to Url
    public static void NavigatetoUrl(String text){
        driver.navigate().to(text);
    }

    // 19 Method for checking web element is present or not in DOM
    public void checkingIfWebElementifPresentinDOM(By by){
        if(driver.findElement(by)!=null){
            System.out.println("Element is Present");}
        else {System.out.println(("Element is Absent"));}
    }
    // 20 Method to Scroll to View Element
    public void ScrolltoviewElement(By by ){
        Actions actions = new Actions(driver);
        actions.moveToElement((WebElement) by);
    }
    // 21 Method to Scroll to view Element & Click
    public void ScrolltoviewElementAndClick(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement((WebElement) by).click();
    }
    // 22 Method for CSSValue
    public void getcssvalue(By by, String text){
        driver.findElement(by).getCssValue(text);
    }


}

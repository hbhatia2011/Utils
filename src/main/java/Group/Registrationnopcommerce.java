package Group;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Registrationnopcommerce extends Utils {
    Loadprop loadprop = new Loadprop();

    @BeforeMethod
    //Method to Launch browser
    public void setUp() {
        toLaunchChromeBrowser();
        driver.get(loadprop.getProperty("url"));
    }


   @AfterMethod
    //Method to Quit the browser
    public void quitbrowser(){
        closebrowser();
    }

    @Test (priority = 0)
    public void UsershouldbeabletoregisterSuccessfully() {
        //click on Register tab
        clickOnElement(By.className("ico-register"));
        //enter FirstName
        EnterText(By.id("FirstName"),loadprop.getProperty("FirstName"));
        //enter LastName
        EnterText(By.id("LastName"),loadprop.getProperty("LastName"));
        //enter Date of Birth
        selectByValue(By.xpath("//select[@name=\"DateOfBirthDay\"]"),loadprop.getProperty("DateOfBirthDay"));
        //enter Month of Birth
        selectByIndextext(By.xpath("//select[@name=\"DateOfBirthMonth\"]"),5);
        //enter Year of Birth
        selectByValue(By.xpath("//select[@name=\"DateOfBirthYear\"]"),"1981");
        //enter email address
        EnterText(By.name("Email"),("test"+randomDate()+"@test.com"));
        //enter password
        EnterText(By.xpath("//input[@id='Password']"),loadprop.getProperty("Password"));
        //enter confirm password
        EnterText(By.xpath("//input[@id='ConfirmPassword']"),loadprop.getProperty("ConfirmPassword"));
        //click on Register
        clickOnElement(By.id("register-button"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //to test the actual and expected results

        String Expectedresults="Your registration completed";
        String Actualresult=extractText(By.xpath("//div[@class='result']"));
         Assert.assertEquals(Actualresult,Expectedresults);
    }

    @Test (priority = 1)
    public void UsershouldbeabletoReferaProducttoFriend(){
        //click on Register tab
        clickOnElement(By.className("ico-register"));
        //enter FirstName
        EnterText(By.id("FirstName"),loadprop.getProperty("FirstName"));
        //enter LastName
        EnterText(By.id("LastName"),loadprop.getProperty("LastName"));
        //enter Date of Birth
        selectByValue(By.xpath("//select[@name=\"DateOfBirthDay\"]"),loadprop.getProperty("DateOfBirthDay"));
        //enter Month of Birth
        selectByIndextext(By.xpath("//select[@name=\"DateOfBirthMonth\"]"),5);
        //enter Year of Birth
        selectByValue(By.xpath("//select[@name=\"DateOfBirthYear\"]"),"1981");
        //enter email address
        EnterText(By.name("Email"),("test"+randomDate()+"@test.com"));
        //enter password
        EnterText(By.xpath("//input[@id='Password']"),loadprop.getProperty("Password"));
        //enter confirm password
        EnterText(By.xpath("//input[@id='ConfirmPassword']"),loadprop.getProperty("ConfirmPassword"));
        //click on Register
        clickOnElement(By.id("register-button"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Click on Continue
        clickOnElement(By.name("register-continue"));

        //Select Apple MacBook Pro
        clickOnElement(By.xpath("//h2/a[@href=\"/apple-macbook-pro-13-inch\"]"));

        //Click on Email a Friend tab
        clickOnElement(By.xpath("//input[@value='Email a friend']"));

        //Enter Friend Email address
        EnterText(By.xpath("//input[@id='FriendEmail']"),loadprop.getProperty("FriendEmail"));

        //Enter personal message
        EnterText(By.xpath("//textarea[@id='PersonalMessage']"),loadprop.getProperty("PersonalMessage"));

        //Click on Send mail
        clickOnElement(By.name("send-email"));

        //to test the actual and expected results Email the product successfully
        String Expectedresults="Your message has been sent.";
        String Actualresult=extractText(By.xpath("//div[@class='result']"));
        Assert.assertEquals(Actualresult,Expectedresults);
    }

    @Test (priority = 2)
    public void UsershouldbeabletoNavigateCameraandPhotopage(){

        //Select Electronics Tab
        clickOnElement(By.linkText("Electronics"));

        //Select Camera & photo tab
        clickOnElement(By.linkText("Camera & photo"));

        //to test the actual and expected results
        String Expectedresults="Camera & photo";
        String Actualresult= extractText(By.linkText("Camera & photo"));
        Assert.assertEquals(Actualresult,Expectedresults);

    }

    @Test (priority = 3)
    public void UsershouldbeabletoselectJwellerybypricefilter(){

        //Select Jewelry Tab
        clickOnElement(By.linkText("Jewelry"));
        //Select price range $700-$3000
        clickOnElement(By.xpath("//a[contains(@href,\"700-3000\")]"));
        //to test the Actual and Expected results
        //save expectedtitle by locators
        String expectedtitle = "$700.00 - $3,000.00";
        //save actualtitle by locators
        String actualtitle = extractText(By.xpath("//span[@class= 'item']"));
        Assert.assertEquals(actualtitle,expectedtitle);
        //find minimum price
        String minimumrange = extractText(By.xpath("//span[@class=\"PriceRange\"and text()= '$700.00']"));
        System.out.println(minimumrange);
        // find Actual price
        String actualrange = extractText(By.xpath("//span[@class=\"price actual-price\" and text() ='$2,100.00']"));
        System.out.println(actualrange);
        //find maximum price
        String maximumrange = extractText(By.xpath("//span[@class=\"PriceRange\"and text()= '$3,000.00']"));
        System.out.println(maximumrange);
        // convert string minrange to float
        float minrange = Float.parseFloat(minimumrange.substring(1));
        System.out.println(minrange);
        //convert String actualrange
        float arange = Float.parseFloat(actualrange.replace(",","").substring(1));
        System.out.println(arange);
        //Convert String maxminrange
        float maxrange = Float.parseFloat(maximumrange.replace(",","").substring(1));
        System.out.println(maxrange );
        //checking actual price between minimum and maximum range
        Assert.assertTrue(arange>=minrange && arange<=maxrange);

    }

    @Test (priority = 4)
    public void UsershouldbeabletoaddBookstoCart(){

        //Select Books Tab - using LinkText Locator
        clickOnElement(By.linkText("Books"));
         //Add to Cart - 'Fahrenheit 451 by Ray Bradbury' book
        clickOnElement(By.xpath("//input[contains(@onclick,'/37/1/1')]"));
         //Check the Cart to confirm the book is added
        clickOnElement(By.linkText("Shopping cart"));
         //Click on Continue Shopping to add another book
        clickOnElement(By.name("continueshopping"));
        //Add to Cart - 'First Prize Pies' book
        clickOnElement(By.xpath("//input[contains(@onclick,'/38/1/1')]"));
        //to confirm whether the book has been added
        clickOnElement(By.linkText("Shopping cart"));

        //to test the actual and expected results
        String Expectedresults="Shopping cart";
        String Actualresult= extractText(By.linkText("Shopping cart"));
        Assert.assertEquals(Actualresult,Expectedresults);
    }

}






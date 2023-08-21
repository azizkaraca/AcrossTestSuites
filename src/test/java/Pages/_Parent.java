package Pages;

import Utilities.GWD;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class _Parent {

    WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));
    public void sendKeysFunction(WebElement element, String value)
    {
        waitUntilVisible(element);
        waitUntilClickable(element);
        scrollToElement(element);
        clearTextArea(element);
//        element.clear(); -> it did not work for across app. check it later!
        element.sendKeys(value);
    }

    public void clearTextArea(WebElement element)
    {
        element.sendKeys((Keys.chord(Keys.CONTROL,"a",Keys.DELETE)));
    }

    public void clickFunction(WebElement element)
    {
        waitUntilClickable(element);
        waitUntilVisible(element);
        scrollToElement(element);
        element.click();
    }

      public void verifyContainsText(WebElement element, String text)
    {
        waitUntilVisible(element);
        waitUntilClickable(element);
        Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()));
    }

    public void verifyElementDisplayed(WebElement element)
    {
        waitUntilVisible(element);
        Assert.assertTrue(element.isDisplayed());
    }

    public void verifyElementNotDisplayed(WebElement element,String text)
    {
        waitUntilVisible(element);
        Assert.assertFalse(element.getText().toLowerCase().contains(text.toLowerCase()));
        //Assert.assertFalse(false);
    }

    public void verifyCurrentUrl(String Text)
    {

        wait.until(ExpectedConditions.urlContains(Text)); // if url contains Cap.Letters it fails.
        //wait.until(ExpectedConditions.urlContains("http")); // for url contains Cap.Letters, use this.
        String str = GWD.getDriver().getCurrentUrl().toLowerCase();
        System.out.println(str);
        Assert.assertTrue(str.contains(Text.toLowerCase()));

    }

    //methods
    public void waitUntilVisible(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable(WebElement element)
    {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public List<WebElement> waitVisibleListAllElement(List<WebElement> elementList) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
        return elementList;
    }

    public void scrollToElement(WebElement element)
    {
        JavascriptExecutor js=(JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();",element);
    }

    public void switchToEditMode()
    {
        String editUrl = GWD.getDriver().getCurrentUrl().replaceAll("view","edit");
        GWD.getDriver().get(editUrl);
    }

    public void ctrlMM()  // instead of this, switchToEditMode() can be used as well!
    {
        Actions actions = new Actions(GWD.getDriver());
        actions.keyDown(Keys.CONTROL).sendKeys("m").sendKeys("m").keyUp(Keys.CONTROL).perform();

    }

    public void TAB()
    {
        Actions actions = new Actions(GWD.getDriver());
        actions.sendKeys(Keys.TAB).perform();

    }

    public void ENTER()
    {
        Actions actions = new Actions(GWD.getDriver());
        actions.sendKeys(Keys.ENTER).perform();

    }

    public void mouseActions (WebElement element)
    {
        Actions actions = new Actions(GWD.getDriver());
        scrollToElement(element);
        waitUntilVisible(element);
        waitUntilClickable(element);
        actions.contextClick(element).perform();
    }
    public void refresh(){
        GWD.getDriver().navigate().refresh();
    }

    public void chooseFolder(String text) throws AWTException{
        Robot rbt = new Robot();

        StringSelection stringSelection = new StringSelection("C:\\Users\\AzizKaraca\\Pictures\\"+text+".png");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection , null);

        try {   // check available wait method here!
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        rbt.keyPress(KeyEvent.VK_CONTROL);
        rbt.keyPress(KeyEvent.VK_V);
        rbt.keyRelease(KeyEvent.VK_CONTROL);
        rbt.keyRelease(KeyEvent.VK_V);

//        for(int i=0;i<2;i++) { //
//            rbt.keyPress(KeyEvent.VK_TAB); // press the button - down.
//            rbt.keyRelease(KeyEvent.VK_TAB); // release the button - up.
//        }
        rbt.keyPress(KeyEvent.VK_ENTER); // press the button - down.
        rbt.keyRelease(KeyEvent.VK_ENTER); // release the button - up.
    }


}

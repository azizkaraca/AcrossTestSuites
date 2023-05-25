package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BreadCrumbs extends _Parent {

    public BreadCrumbs() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "(//p[text()='Dashboard'])[2]")
    private WebElement dashboard;
    @FindBy(xpath = "//p[text()='Alarms']")
    private WebElement alarms;
    @FindBy(xpath = "//p[text()='Events']")
    private WebElement events;
    @FindBy(xpath = "//p[text()='Data']")
    private WebElement data;
    @FindBy(xpath = "//p[text()='Graphs']")
    private WebElement graphs;
    @FindBy(xpath = "//p[text()='Info']")
    private WebElement info;
    @FindBy(xpath = "//p[text()='Availability']")
    private WebElement availability;
    @FindBy(xpath = "//p[text()='Devices']")
    private WebElement devices;
    @FindBy(xpath = "//p[text()='Units']")
    private WebElement units;
    @FindBy(xpath = "//p[text()='Registers']")
    private WebElement registers;
    @FindBy(xpath = "//p[text()='System Registers']")
    private WebElement systemRegisters;
    @FindBy(xpath = "//p[text()='Process']")
    private WebElement process;
    @FindBy(xpath = "//p[text()='Images']")
    private WebElement images;
    @FindBy(xpath = "//p[text()='Specifications']")
    private WebElement specifications;
    @FindBy(xpath = "//p[text()='Aggregations']")
    private WebElement aggregations;
    @FindBy(xpath = "//p[text()='Remote Control']")
    private WebElement remoteControl;
    @FindBy(xpath = "//p[text()='Reports']")
    private WebElement reports;
    @FindBy(xpath = "//p[text()='Calculated Registers']")
    private WebElement calculated;

    WebElement myElement;

    public void findAndClick(String strElement) {
        switch (strElement) {
            case "dashboard": myElement = dashboard;break;
            case "alarms": myElement = alarms;break;
            case "events": myElement = events;break;
            case "data": myElement = data;break;
            case "graphs": myElement = graphs;break;
            case "info": myElement = info;break;
            case "availability": myElement = availability;break;
            case "devices": myElement = devices;break;
            case "units": myElement = units;break;
            case "registers": myElement = registers;break;
            case "systemRegisters": myElement = systemRegisters;break;
            case "process": myElement = process;break;
            case "images": myElement = images;break;
            case "specifications": myElement = specifications;break;
            case "aggregations": myElement = aggregations;break;
            case "remoteControl": myElement = remoteControl;break;
            case "reports": myElement = reports;break;
            case "calculated": myElement = calculated;break;

        }
        clickFunction(myElement);
    }

}

package App.Pages;

import App.AppBasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.HashMap;
import java.util.Map;

public class LogPartPage extends AppBasePage {

    public LogPartPage(AndroidDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.widget.Spinner[@resource-id='android_picker'][1]")
    private WebElement listMachineName;

    @FindBy(xpath = "//android.widget.Spinner[@resource-id='android_picker'][2]")
    private WebElement listPartName;

    @FindBy(xpath = "//android.widget.EditText[1]")
    private WebElement inputPartValue;

    @FindBy(xpath = "//android.widget.Button[@content-desc='SAVE']")
    private WebElement btnSave;

    @FindBy(xpath = "//android.widget.TextView[@text='Machine State']")
    private WebElement btnMachineState;

    public void logPart(String machineName, HashMap<String, String> partsValue) {
        selectMachineName(machineName);

        for (Map.Entry<String, String> part : partsValue.entrySet()) {
            String partName = part.getKey();
            String partValue = part.getValue();
            System.out.println("Part: " + partName + ", Part Value: " + partValue);
            selectPartName(partName);
            insertPartValue(partValue);
            btnSave.click();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        btnMachineState.click();
    }

    public void selectMachineName(String machineName) {
        listMachineName.click();
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='" + machineName + "']")).click();
    }

    public void selectPartName(String partName) {
        listPartName.click();
        scrollToAnElementByText(driver, partName).click();
    }

    public void insertPartValue(String partValue) {
        inputPartValue.clear();
        inputPartValue.sendKeys(partValue);
    }

    public WebElement scrollToAnElementByText(AppiumDriver driver, String text) {
        return driver.findElement(new AppiumBy.ByAndroidUIAutomator(("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(new UiSelector().text(\"" + text + "\"));")));
    }

}

package App.Pages;

import App.AppBasePage;
import App.Enuns.WeldingRobot;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.SQLOutput;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HomePage extends AppBasePage {
    public HomePage(AndroidDriver driver) {
        super(driver);
    }
    AppBasePage appBasePage = new AppBasePage(driver);

    @FindBy(xpath = "//android.widget.Button[@content-desc='CALCULATE HEALTH']")
    private WebElement btnCalculateHealth;

    @FindBy(xpath = "//android.widget.TextView[@text='Log Part']")
    private WebElement btnLogPart;

    @FindBy(xpath = "//android.widget.TextView[@text='RESET MACHINE DATA']")
    private WebElement btnResetMachineData;

    @FindBy(xpath = "//android.view.View[@text='Machine State']")
    private WebElement titleHomePage;

    @FindBy(xpath = "//android.widget.TextView[@text='Factory Health Score']//following-sibling::android.widget.TextView[1]")
    private WebElement txtFactoryScore;

    @FindBy(xpath = "//android.widget.TextView[@text='Machine Health Scores']")
    private WebElement txtTitleMachineHealthScore;

    @FindBy(xpath = "//android.widget.TextView[@text='Machine Health Scores']//following-sibling::android.widget.TextView[1]")
    private WebElement txtMachineHealthScore;

    

    public void openLogPartScreen() {
        Assert.assertTrue(titleHomePage.isDisplayed());
        btnLogPart.click();
    }

    public void calculateHealth() {
        Assert.assertTrue(titleHomePage.isDisplayed());
        btnCalculateHealth.click();
        Assert.assertTrue(txtTitleMachineHealthScore.isDisplayed());
    }

    public void resetData() {
        Assert.assertTrue(titleHomePage.isDisplayed());
        btnResetMachineData.click();
    }

    public void validateScore(String score) {
        Assert.assertTrue(txtFactoryScore.isDisplayed());
        String factoryScore = txtFactoryScore.getText();
        String machineScore = txtMachineHealthScore.getText();

        Pattern p = Pattern.compile("[\\d.]");
        Matcher m = p.matcher(machineScore);
        String match = "";
        while(m.find()) {
            match = match + m.group();

        }
        machineScore = match;

        System.out.println("Factory Health Score: " + factoryScore);
        System.out.println("Machine Health Score: " + machineScore);
        Assert.assertEquals(score, machineScore);
        Assert.assertEquals(score, factoryScore);

        appBasePage.takeScreenshot();

        System.out.println("*** TEST PASSED ***");




    }

}

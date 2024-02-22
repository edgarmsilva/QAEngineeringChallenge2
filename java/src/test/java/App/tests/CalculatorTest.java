package App.tests;

import App.Enuns.AssemblyLine;
import App.Enuns.PaintingStation;
import App.Enuns.QualityControlStation;
import App.Enuns.WeldingRobot;
import App.Pages.HomePage;
import App.Pages.LogPartPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.junit.jupiter.api.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorTest {

    private UiAutomator2Options options;
    private AndroidDriver driver;
    private HomePage homePage;
    private LogPartPage logPartPage;
    public HashMap<String, String> parts = new HashMap<>();

    @BeforeEach
    public void setup() {
        System.out.println("--------------------------------------------");
        options = new UiAutomator2Options()
                .setUdid("emulator-5554")
                .setAppPackage("com.machinehealth.app")
                .setAppActivity("com.machinehealth.app.MainActivity");

        {
            try {
                driver = new AndroidDriver(
                        // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
                        new URL("http://127.0.0.1:4723"), options
                );
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }

        homePage = new HomePage(driver);
        logPartPage = new LogPartPage(driver);

    }

    @Test
    public void ValidateWeldingMachineScore() {
        System.out.println("*** Machine: " + WeldingRobot.NAME.get());
        parts.put(WeldingRobot.VIBRATIONLEVEL.get(), "5.0");
        parts.put(WeldingRobot.ERRORRATE.get(), "1.0");
        parts.put(WeldingRobot.ELECTRODEWEAR.get(), "1.0");
        parts.put(WeldingRobot.SHIELDINGPRESSURE.get(), "15.0");
        parts.put(WeldingRobot.WIREFEEDRATE.get(), "10.0");
        parts.put(WeldingRobot.ARCSTABILITY.get(), "95.0");
        parts.put(WeldingRobot.SEAMWIDTH.get(), "2.0");
        parts.put(WeldingRobot.COOLINGEFFICIENCY.get(), "90.00");

        homePage.openLogPartScreen();
        logPartPage.logPart(WeldingRobot.NAME.get(), parts);
        homePage.calculateHealth();
        homePage.validateScore("100.00");
    }

    @Test
    public void ValidatePaintingStationScore() {
        System.out.println("*** Machine: " + PaintingStation.NAME.get());
        parts.put(PaintingStation.FLOWRATE.get(), "11.0");
        parts.put(PaintingStation.PRESSURE.get(), "60.0");
        parts.put(PaintingStation.COLORCONSISTENCY.get(), "92.0");
        parts.put(PaintingStation.NOZZLECONDITION.get(), "0.5");

        homePage.openLogPartScreen();
        logPartPage.logPart(PaintingStation.NAME.get(), parts);
        homePage.calculateHealth();
        homePage.validateScore("86.25");
    }

    @Test
    public void ValidateAssemblyLineScore() {
        System.out.println("*** Machine: " + AssemblyLine.NAME.get());
        parts.put(AssemblyLine.ALIGNMENTACCURACY.get(), "1.0");
        parts.put(AssemblyLine.SPEED.get(), "10.0");
        parts.put(AssemblyLine.FITTINGTOLERANCE.get(), "0.05");
        parts.put(AssemblyLine.BELTSPEED.get(), "1.5");

        homePage.openLogPartScreen();
        logPartPage.logPart(AssemblyLine.NAME.get(), parts);
        homePage.calculateHealth();
        homePage.validateScore("93.75");
    }

    @Test
    public void ValidateQualityControlStationScore() {
        System.out.println("*** Machine: " + QualityControlStation.NAME.get());
        parts.put(QualityControlStation.CAMERACALIBRATION.get(), "1");
        parts.put(QualityControlStation.LIGHTINTENSITY.get(), "95.0");
        parts.put(QualityControlStation.SOFTWAREVERSION.get(), "v2.0");
        parts.put(QualityControlStation.CRITERIASETTINGS.get(), "1");

        homePage.openLogPartScreen();
        logPartPage.logPart(QualityControlStation.NAME.get(), parts);
        homePage.calculateHealth();
        homePage.validateScore("75.00");
    }

    @AfterEach
    public void teardown(){
        parts.clear();
        driver.quit();
    }
}

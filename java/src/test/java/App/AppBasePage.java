package App;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.UUID;

public class AppBasePage {
    protected AndroidDriver driver;

    public AppBasePage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
//    public void takeScreenshot(){
//        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//
//    }

    public void takeScreenshot() {
        File srcFile=driver.getScreenshotAs(OutputType.FILE);
        String filename= UUID.randomUUID().toString();
        File targetFile=new File("target/screenshots/" + filename +".jpg");
        try {
            FileUtils.copyFile(srcFile,targetFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;

import java.util.List;

public class TestiFrame {
    private WebDriver d;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        d = new ChromeDriver();
    }

    @Test
    public void testiFrame() {  // by using String name
        d.get("https://demoqa.com/frames");
        System.out.println(d.findElements(By.tagName("iframe")).size());
        d.switchTo().frame("frame1");
        String sampleHeading = d.findElement(By.id("sampleHeading")).getText();
        System.out.println(sampleHeading);
    }

    @Test
    public void testiFrame2() {   // by using int index
        d.get("https://demoqa.com/frames");
        int countIframe = d.findElements(By.tagName("iframe")).size();
        WebElement iframeId = d.findElement(By.id("frame1"));
        d.switchTo().frame(0);
        WebElement sampleHeading = d.findElement(By.tagName("body"));
        String heading1 = sampleHeading.getText();
        System.out.println(heading1);

    }

    @Test
    public void testFrame3() {    //by using WebElement Object
        d.get("https://demoqa.com/frames");
        int countIframe = d.findElements(By.tagName("iframe")).size();
        WebElement iframeId = d.findElement(By.id("frame1"));
        d.switchTo().frame(iframeId);
        WebElement frameElement = d.findElement(By.tagName("body"));
        String frame1Text = frameElement.getText();
        System.out.println(frame1Text);
    }

    @Test
    public void testNestedFrame() {    //it  will print the iframe present in webpage and parent frame
        d.get("https://demoqa.com/nestedframes");

        int countIframesInPage = d.findElements(By.tagName("iframe")).size();
        System.out.println("Number of Frames on a Page:" + countIframesInPage);

        WebElement frame1 = d.findElement(By.id("frame1"));
        d.switchTo().frame(frame1);

        WebElement frame1Element = d.findElement(By.tagName("body"));

        String frame1Text = frame1Element.getText();
        System.out.println("Frame1 is " + frame1Text);

        int countIframesInFrame1 = d.findElements(By.tagName("iframe")).size();   //parent frame
        System.out.println("Number of Frames inside the Frame1:" + countIframesInFrame1);

        d.switchTo().frame(0);
        int countIframesInFrame2 = d.findElements(By.tagName("iframe")).size();  //child frame
        System.out.println("Number of Frames inside the Frame2:" + countIframesInFrame2);

    }

    @Test
    public void childToparentFrame() {    //it will go back to the parent frame
        d.get("https://demoqa.com/nestedframes");

        int countIframesInPage = d.findElements(By.tagName("iframe")).size();
        System.out.println("Number of Frames on a Page:" + countIframesInPage);

        WebElement frame1 = d.findElement(By.id("frame1"));
        d.switchTo().frame(frame1);

        WebElement frame1Element = d.findElement(By.tagName("body"));

        String frame1Text = frame1Element.getText();
        System.out.println("Frame1 is " + frame1Text);

        int countIframesInFrame1 = d.findElements(By.tagName("iframe")).size();   //parent frame
        System.out.println("Number of Frames inside the Frame1:" + countIframesInFrame1);

        d.switchTo().frame(0);
        int countIframesInFrame2 = d.findElements(By.tagName("iframe")).size();  //child frame
        System.out.println("Number of Frames inside the Frame2:" + countIframesInFrame2);

        d.switchTo().parentFrame();

        WebElement frameElement = d.findElement(By.tagName("body"));
        String frame1Textt = frameElement.getText();
        System.out.println("Frame1 " + frame1Textt);

    }

    @Test
    public void nestedFrametoDefaultContent() {  // it will locate the defaultcontent(base frame)

        d.get("https://demoqa.com/nestedframes");

        int countIframesInPage = d.findElements(By.tagName("iframe")).size();
        System.out.println("Number of Frames on a Page:" + countIframesInPage);

        WebElement frame1 = d.findElement(By.id("frame1"));
        d.switchTo().frame(frame1);

        WebElement frame1Element = d.findElement(By.tagName("body"));

        String frame1Text = frame1Element.getText();
        System.out.println("Frame1 is " + frame1Text);

        int countIframesInFrame1 = d.findElements(By.tagName("iframe")).size();   //parent frame
        System.out.println("Number of Frames inside the Frame1:" + countIframesInFrame1);

        d.switchTo().frame(0);
        int countIframesInFrame2 = d.findElements(By.tagName("iframe")).size();  //child frame
        System.out.println("Number of Frames inside the Frame2:" + countIframesInFrame2);

        d.switchTo().defaultContent();
        WebElement mainpage = d.findElement(By.xpath("//*[@id='framesWrapper']/div[1]"));
        String mainpageText = mainpage.getText();
        System.out.println("mainpageText" + mainpageText);

    }


}

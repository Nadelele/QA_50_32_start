import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class SelectorsXpath {
    WebDriver driver = new ChromeDriver();

    @Test
    public void iLcarroXpathTest() {
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://ilcarro.web.app/search");

        WebElement btnLogin = driver.findElement(By.xpath("//a[text()=' Log in ']"));
        btnLogin.click();

        WebElement fieldEmail = driver.findElement(By.xpath("//input[@formcontrolname = 'email']"));
        fieldEmail.sendKeys("qa50nl@gmail.com");
        WebElement fieldPassword = driver.findElement(By.xpath("//input[@formcontrolname = 'password']"));
        fieldPassword.sendKeys("QWEasd123!");
        WebElement btnSubmit = driver.findElement(By.xpath("//button[@type = 'submit']"));
        btnSubmit.click();

        WebElement btnOkSuccessLogin = driver.findElement(By.xpath("//button[text() = 'Ok']"));
        btnOkSuccessLogin.click();
        WebElement btnLogout = driver.findElement(By.xpath("//*[contains(@href,'/logout')]"));
        btnLogout.click();

        driver.quit();

    }

    @Test
    public void phonebookTest() {
        setTestWindow();
        driver.get("https://telranedu.web.app/home");
//        WebElement btnAbout = driver.findElement(By.cssSelector("a[href='/about']"));

        //WebElement btnAbout = driver.findElement(By.xpath("//a[@href='/about']"));
        WebElement btnAbout = driver.findElement(By.xpath("//*[text()='ABOUT']"));
        btnAbout.click();
        driver.navigate().back();
        SelectorCSS.pause(3);
        WebElement btnLogin = driver.findElement(By.xpath("//*[text()='LOGIN']"));
        btnLogin.click();
        pause(5);
        WebElement fieldEmail = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        int i = new Random().nextInt(1000);
        fieldEmail.sendKeys("qa50" + i + "@gmail.com");
        WebElement fieldPassword = driver.findElement(By.xpath("//input[@name='password']"));
        fieldPassword.sendKeys("Password123!");
        WebElement btnRegister = driver.findElement(By.xpath("//button[@name='registration']"));
        btnRegister.click();
        pause(5);
        WebElement btnSignOut = driver.findElement(By.xpath("//button[text()='Sign Out']"));
        btnSignOut.click();
        pause(5);

        List<WebElement> buttons = driver.findElements(By.xpath("//button"));
        System.out.println(buttons.get(1).getText());
        ArrayList<String> buttonsText = new ArrayList<>();
        buttons.forEach(b -> buttonsText.add(b.getText()));
        System.out.println(buttonsText);
        //driver.quit();


    }

    private void setTestWindow() {
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    static void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
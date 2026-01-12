import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class SelectorCSS {
    WebDriver driver = new ChromeDriver();

    @Test
//    public void phoneBookTest() {
//        driver.manage().window().maximize();
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        //driver.get("https://telranedu.web.app/home");
//        driver.navigate().to("https://telranedu.web.app/home");
//        WebElement btnAbout = driver.findElement(By.cssSelector("a[href='/about']"));
//        btnAbout.click();
//       // WebElement divRoot = driver.findElement(By.cssSelector("#root"));
//        //WebElement divRoot = driver.findElement(By.id("root"));
//        //WebElement divRoot = driver.findElement(By.cssSelector("div[id='root]"));
//        //WebElement divRoot = driver.findElement(By.cssSelector("*[id='root]"));
//        WebElement divRootClass = driver.findElement(By.cssSelector("div[class='container']"));
//       // WebElement divRootClass = driver.findElement(By.cssSelector("*[class='container']"));
//        // WebElement divRootClass = driver.findElement(By.cssSelector(".container"));
//        System.out.println(divRootClass.getAttribute("id"));
//        //System.out.println(divRoot.getAttribute("class"));
//        pause(5);
//
//        //driver.navigate().refresh();
//        driver.navigate().to("https://telranedu.web.app/login");
//        pause(5);
//        driver.navigate().back();
//        //driver.close(); // closes one tab
//        driver.quit(); //closes all tabs and browser
//    }

    public void iLcarroTest() {
        setTestWindow();

        LocalDate today = LocalDate.now();
        LocalDate startDate = today.plusDays(1);
        LocalDate endDate = today.plusDays(3);

        String startLabel = formatter(startDate);
        String endLabel = formatter(endDate);
        System.out.println(startLabel);

        driver.get("https://ilcarro.web.app/search");

        driver.findElement(By.cssSelector("a[href='/terms-of-use']")).click();
        driver.navigate().back();
        driver.findElement(By.cssSelector("#\\30.navigation-link")).click(); //\30  - unicode for 0. Just to train combined selector
        driver.findElement(By.cssSelector("a[href='/terms-of-use']"));

        WebElement loginLink = driver.findElement(By.cssSelector("a[href *= 'login']"));
        System.out.println("link: " + loginLink.getAttribute("href"));

        driver.findElement(By.cssSelector("a[href='search/results?city=Tel%20Aviv']")).click();
        driver.findElement(By.cssSelector("input[formcontrolname='dates']")).click();
        driver.findElement(By.cssSelector("td[aria-label='" + startLabel + "']")).click();
        driver.findElement(By.cssSelector("td[aria-label='" + endLabel + "']")).click();
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        driver.quit();

    }

    private void setTestWindow() {
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    static String formatter(LocalDate date) {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        return date.format(formatter);
    }

    static void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

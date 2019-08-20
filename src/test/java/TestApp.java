import com.sun.org.apache.bcel.internal.generic.Select;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class TestApp {
    String mail;
    String password;
    WebDriver driver;
    @Test
    public void NewAffiliateTesting(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Анастасия\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://taqc-dp170.zzz.com.ua/index.php?route=affiliate/login");
        driver.findElement(By.linkText("Continue")).click();

        driver.findElement(By.name("firstname")).sendKeys("Vasia");
        driver.findElement(By.name("lastname")).sendKeys("Petrov");
        driver.findElement(By.name("email")).sendKeys("dpetrov@mail.ru");
        mail = driver.findElement(By.name("email")).getAttribute("value");
        driver.findElement(By.name("telephone")).sendKeys("0874523561");
        driver.findElement(By.name("address_1")).sendKeys("Petrovskogo street");
        driver.findElement(By.name("city")).sendKeys("Dnipro");
        driver.findElement(By.name("postcode")).sendKeys("35671");
        driver.findElement(By.id("input-country")).sendKeys("Ukraine");
        driver.findElement(By.id("input-zone")).sendKeys("Dnipropetrovs'ka Oblast'");
        driver.findElement(By.name("password")).sendKeys("qwerty");
        driver.findElement(By.name("confirm")).sendKeys("qwerty");
        password = driver.findElement(By.name("confirm")).getAttribute("value");
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        //Assert.assertEquals("Your Affiliate Account Has Been Created!", driver.findElement(By.tagName("h1")).getText());

        driver.get("http://taqc-dp170.zzz.com.ua/index.php?route=affiliate/logout");
        driver.get("http://taqc-dp170.zzz.com.ua/index.php?route=affiliate/account");
        driver.findElement(By.name("email")).sendKeys(mail);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Assert.assertEquals("My Affiliate Account",driver.findElement(By.tagName("h2")).getText());
    }

}

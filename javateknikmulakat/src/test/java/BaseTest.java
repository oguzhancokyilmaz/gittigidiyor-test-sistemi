import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class BaseTest {
    private static final Logger LOG = LogManager.getLogger(BaseTest.class);
    private static final By LOGIN = By.xpath("//div[@name='profile']");
    private static final By LOG_BUTTON=By.linkText("Giriş Yap");

    protected WebDriver driver;
    LoginAutomation loginAutomation;


    @BeforeTest
    public  void setUp() {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://www.gittigidiyor.com/");
        LOG.info("Anasayfa açıldı");
        loginAutomation = new LoginAutomation(driver);

    }

    @Test(priority = 1)
    public void loginPage() throws InterruptedException {

        driver.findElement(LOGIN).click();
        Thread.sleep(3000);
        driver.findElement(LOG_BUTTON).click();
        Thread.sleep(3000);
        LOG.info("Login kısmı açıldı");
        loginAutomation = new LoginAutomation(driver);

    }

    @AfterTest
    public  void termDown(){
        LOG.info("Test başarıyla bitti");
    }


}

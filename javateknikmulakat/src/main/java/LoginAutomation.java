import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class LoginAutomation {

    private static final Logger LOG = LogManager.getLogger(LoginAutomation.class);
    private WebDriver driver;
    private By email = By.id("L-UserNameField");
    private By password = By.id("L-PasswordField");
    private By login = By.id("gg-login-enter");
    private By search = By.name("k");
    private By secondPage = By.className("next-link");
    private By closeAlert = By.cssSelector("a[class='policy-alert-close btn-alert-close']");
    private By computer = By.id("product_id_576241025");
    private By shopCart = By.id("add-to-basket");
    private By pagePrice = By.id("sp-price-lowPrice");
    private By shopCartEnter = By.cssSelector("a[class='gg-ui-btn-default padding-none']");




    public LoginAutomation(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String emailText) {
        WebElement emailSpace = driver.findElement(email);
        emailSpace.click();
        emailSpace.sendKeys(emailText);
        LOG.info("Email başarı ile girildi.");

    }

    public void setPassword(String passwordText) {
        WebElement passwordSpace = driver.findElement(password);
        passwordSpace.click();
        passwordSpace.sendKeys(passwordText);
        LOG.info("Şifre başarı ile girildi.");

    }

    public void login() {

        WebElement loginSpace = driver.findElement(login);
        loginSpace.click();
        LOG.info("Giriş işlemi başarılı.");

    }

    public void setSearchKey(String searchText) {
        WebElement searchSpace = driver.findElement(search);
        searchSpace.click();
        searchSpace.sendKeys(searchText);
        LOG.info("Arama kısmına bilgisayar yazıldı.");

        WebElement searchBSpace = driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[2]/button"));
        searchBSpace.click();
        LOG.info("Bilgisayar araması yapıldı.");

        WebElement searchSecondSpace = driver.findElement(secondPage);
        WebElement alert = driver.findElement(closeAlert);
        alert.click();
        searchSecondSpace.click();
        LOG.info("2. arama sonuç sayfasına gidildi.");

    }



    public void setComputer() {
        WebElement takeComputer = driver.findElement(computer);
        takeComputer.click();
        LOG.info("Rasgele bir bilgisayar seçildi.");

        WebElement addShopCart = driver.findElement(shopCart);
        addShopCart.click();
        LOG.info("Seçilen ürün sepete eklendi.");
    }

    public void priceComparison() throws InterruptedException {

        String computerPrice = driver.findElement(pagePrice).getText();
        Thread.sleep(2500); // burada bekletme komutunu kullanmazsak sepete giremiyoruz.
        WebElement enterCart = driver.findElement(shopCartEnter);
        enterCart.click();
        Thread.sleep(2500);
        String inCartPrice = driver.findElement(By.cssSelector("div[class='total-price']")).getText();
        LOG.info("Sepete girildi. Bilgisayar Fiyatı : " + computerPrice + " Sepet Fiyatı : " + inCartPrice);


        if (inCartPrice.equals(inCartPrice)) {

            LOG.info("Ürünün liste fiyatı ile sepet fiyatı aynıdır.");

        }
    }

    public void plusQuantity() throws InterruptedException {

        Thread.sleep(2500);
        Select se = new Select(driver.findElement(By.cssSelector(".gg-form-item.number-selection .gg-input-select select")));
        se.selectByValue("2");
        Thread.sleep(2500);
        LOG.info("Ürün sayısı arttırıldı.");

    }


    public void deleteCart() throws InterruptedException {


        WebElement deleteCart = driver.findElement(By.cssSelector(".btn-update-item.btn-delete"));
        deleteCart.click();
        Thread.sleep(2500);
        LOG.info("Ürün sepetten silindi.");


    }




}

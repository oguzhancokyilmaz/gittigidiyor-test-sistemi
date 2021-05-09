import org.apache.log4j.Priority;
import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;

import org.testng.annotations.Test;



public class RunTestSystemHere extends BaseTest {

    // @Test(priority = 1)

    @Test(priority = 2)
    public void test_setEmail() {
        loginAutomation.setEmail("oguzalex@hotmail.com");

    }

    @Test(priority = 3)
    public void test_setPassword() {
        loginAutomation.setPassword("otomasyontest1");

        loginAutomation.login();


    }

    @Test(priority = 4)
    public void test_setSearchKey(){
        loginAutomation.setSearchKey("bilgisayar");

    }

    @Test(priority = 5)
    public void test_setComputer(){
        loginAutomation.setComputer();

    }

    @Test(priority = 6)
    public void test_priceComparison() throws InterruptedException {

        loginAutomation.priceComparison();

    }

    @Test(priority = 7)
    public void test_plusQuantity() throws InterruptedException {

        loginAutomation.plusQuantity();

    }

    @Test(priority = 8)
    public void test_deleteCart() throws InterruptedException {

        loginAutomation.deleteCart();

    }

}

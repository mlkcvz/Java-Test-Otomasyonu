package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

    public class GetirAutomation {
        public static void main(String[] args) {



            System.setProperty("webdriver.chrome.driver", "C:\\cucumber\\selenium-automation\\Drivers\\chromedriver.exe");
            //Chrome WebDriver'ı kullanarak bir tarayıcı açın
            WebDriver driver = new ChromeDriver();

            driver.get("https://getir.com/");

            //Arama kutusuna ürün adı girin ve arayın
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement search_box = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[class='sc-4995aq-0 sc-14oyvky-0 etpOrY']")));
            search_box.sendKeys("su");

            WebElement search_button = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='sc-1n784rm-0 sc-1f2ug0x-0 iHhTFi']")));
            search_button.click();

            //Ürünü sepete ekleyin
            WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='product-card product-card-list']")));
            product.click();

            WebElement add_button = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='gg-button gg-button--secondary sepete-ekle-button']")));
            add_button.click();

            //Sepeti kontrol edin
            WebElement cart_button = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='basket-icon-container']")));
            cart_button.click();

            WebElement product_in_cart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='product-name']")));
            String productName = product_in_cart.getText();
            if (productName.equals("Sırma Su 1,5 L")) {
                System.out.println("Ürün sepete başarıyla eklendi.");
            } else {
                System.out.println("Ürün sepete eklenirken bir hata oluştu.");
            }

            //Tarayıcıyı kapatın
            driver.quit();
        }
    }


package Test;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class test1 {

    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\cucumber\\selenium-automation\\Drivers\\chromedriver.exe"); //driver ın yolunu verdik
        WebDriver driver = new ChromeDriver(); //driver nesnesi
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.click();
        fullName.sendKeys("melek");
        WebElement email = driver.findElement(new By.ByCssSelector(".mr-sm-2[id='userEmail']"));
        email.click();
        email.sendKeys("mustafa123@gmail.com");
        WebElement currentAddress = driver.findElement(new By.ByCssSelector(".form-control[placeHolder='Current Address']"));
        currentAddress.click();
        currentAddress.sendKeys("Ankara,İstanbul,,");

        JavascriptExecutor jse = (JavascriptExecutor) driver; //sayfada aşağı kaydırma
        jse.executeScript("scroll(0, 250)");

        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        permanentAddress.click();
        permanentAddress.sendKeys("melek , otomasyon");
        WebElement button = driver.findElement(new By.ByCssSelector("button.btn"));
        button.click();

        WebElement nameText = driver.findElement(By.xpath("//*[@id=\'name\']"));
        String name = nameText.getText();
        System.out.println(name);


        driver.get("https://demoqa.com/checkbox");
        String homeCheckBoxCssValue = "label[for='tree-node-home'] span.rct-checkbox svg";

        WebElement homeCheckbox = driver.findElement(new By.ByCssSelector(homeCheckBoxCssValue));
        homeCheckbox.click();

        homeCheckbox = driver.findElement(new By.ByCssSelector(homeCheckBoxCssValue));
        String homeCheckboxClassName = homeCheckbox.getAttribute("class");

        if (homeCheckboxClassName.equals("rct-icon rct-icon-check")) {
            System.out.println("checbox is checkhed!");
        } else {
            System.out.println("Checkbox is unchecked!");
        }

        driver.get("https://demoqa.com/automation-practice-form");

        JavascriptExecutor jse_ = (JavascriptExecutor) driver; //sayfada aşağı kaydırma
        jse_.executeScript("scroll(0, 260)");

        WebElement sportCheckBox = driver.findElement(By.id("hobbies-checkbox-1"));

        Boolean isEnabled = sportCheckBox.isEnabled(); //tıklanabilir mi ,etkileşime girilebilir mi
        System.out.println(isEnabled);
        WebElement sportCheckboxLabel = driver.findElement(new By.ByCssSelector("label[for='hobbies-checkbox-1']"));

        if (isEnabled) { //eğer tıklanabiliyorsa
            try {
                System.out.println("entered try block.");
                sportCheckBox.click();
            } catch (ElementClickInterceptedException e) {
                sportCheckboxLabel.click();
                System.out.println("entered catch block.");
            }
        }
        boolean isSelected = sportCheckBox.isSelected();//seçili mi
        System.out.println(isSelected);

        driver.get("https://demoqa.com/radio-button");

        WebElement yesRadioButtonLabel = driver.findElement(new By.ByCssSelector("label[for='yesRadio']"));
        Boolean isEnabled_ = yesRadioButtonLabel.isEnabled();//tıklanabilir mi ?
        if (isEnabled_) { //aktif mi gibi
            yesRadioButtonLabel.click();
            System.out.println("clicked yesRadio Button");
        }

        WebElement yesRadioButton = driver.findElement(By.id("yesRadio"));
        boolean isSelected_ = yesRadioButton.isSelected();//tıklı mı?

        if (isSelected_) {
            System.out.println("yes radio button is selected");
        }
        WebElement output = driver.findElement(new By.ByCssSelector("p.mt-3"));
        System.out.println(output.getText());

        WebElement noRadioButton = driver.findElement(By.id("noRadio"));
        System.out.println(noRadioButton.isEnabled()); //tıklanabilir mi?

        Thread.sleep(3000);

       /* driver.get("https://demoqa.com/buttons");
        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
        Actions action = new Actions(driver);
        action.doubleClick(doubleClickButton).perform();
        WebElement message = driver.findElement(By.id("doubleClickMessage"));
        String messageText = message.getText();
        System.out.println(messageText);

        WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));
        action.contextClick(rightClickButton).perform(); //butona sağ tıkla!!

        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));
        String messageText__ = rightClickMessage.getText();
        System.out.println(messageText__);

        //Dynamic element : sayfa her yenilendiğinde id si değişir!!,xpath kullanılır
        // //div : bütün divleri bul

        WebElement dynamicClick = driver.findElement(By.xpath("//div/button[starts-with(text(),'Click Me')]"));//böyle başlayanı al
        //2. yol,sonuncuyu al demek----> //div[last()]/button
        dynamicClick.click();
*/
        driver.get("https://demoqa.com/dynamic-properties");
        WebElement textElement = driver.findElement(By.xpath("//div/p"));
        String text = textElement.getText();
        System.out.println(text);

        WebElement firstButton = driver.findElement(By.id("enableAfter"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));//5 saniye bekle
        wait.until(ExpectedConditions.elementToBeClickable(firstButton)); //tıklanabilir olana kadar bekle
        firstButton.click();

        WebElement colorChangeButton = driver.findElement(By.id("colorChange"));
        String className = colorChangeButton.getAttribute("class");
        System.out.println("Before change:" + className);

        WebDriverWait wait_ = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait_.until(ExpectedConditions.attributeToBe(colorChangeButton, "class", "mt-4 text-danger btn btn-primary"));//bu olana kadar bekle
        //class adı değişene kadar yani elemntin rengi değişene kadar bekle demekmiş
        String className__ = colorChangeButton.getAttribute("class");
        System.out.println("After change :" + className__);

       /* Thread.sleep(200);
        WebDriverWait wait__ = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait__.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibileAfter")));
        WebElement lastButton = driver.findElement(By.id("visibileAfter"));
        lastButton.click(); */

        //Bozuk görsel ,kırık link

        //kırık link : serverdan dönen koda göre
        //kırık link

   /*     driver.get("https://demoqa.com/broken");
        CloseableHttpClient client = HttpClientBuilder.create().build();
        //request : get,post,..
        HttpGet request = new HttpGet("http://the-internet.herokuapp.com/status_codes/500");//tıklayınca gidilen sayfa
        HttpResponse response = client.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);

        //broken image, mage in src atrribute unu bulmak lazım
        WebElement brokenImage = driver.findElement(By.xpath("//div/img[2]"));
        String brokenImageUrl = brokenImage.getAttribute("src");
        System.out.println(brokenImageUrl);
        HttpGet request_ = new HttpGet(brokenImageUrl);//tıklayınca gidilen sayfa
        HttpResponse response_ = client.execute(request_);
        int statusCode_ = response_.getStatusLine().getStatusCode();
        System.out.println(statusCode_);
        if (statusCode_ == 200) {
            System.out.println("valid image");
        } else if (statusCode_ == 500) {
            System.out.println("broken image");
        }

        //download
        driver.get("https://demoqa.com/upload-download");
        WebElement download = driver.findElement(By.id("downloadButton"));
        download.click();
        String path = "C:\\Users\\melek\\Downloads";
        String fileName = "sampleFile.jpeg";
        Thread.sleep(5000);
        boolean isDownloaded = isFileDownload(path, fileName);
        System.out.println(isDownloaded);

        //upload :websayfasına ekleme,sendKeys
        Thread.sleep(3000);
        WebElement uploadButton = driver.findElement(By.id("uploadFile"));
        uploadButton.sendKeys("C:\\Users\\melek\\OneDrive\\Masaüstü\\unnamed.webp");
        //yükleyeceğimiz dosyanın yolunu verdik

        //pencere açma
        driver.get("https://demoqa.com/browser-windows");
        WebElement tabButton = driver.findElement(By.id("tabButton"));
        tabButton.click();
        //2 tab var mı
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        System.out.println(tabs.size());
        driver.switchTo().window(tabs.get(1));//geçiş yap, 2. pencereye!!
        System.out.println(driver.getCurrentUrl());//bulunduğu pencerenin url sini al
        Thread.sleep(3000);
        //driver.close();//o pencereyi kapat , quit : driverı tamamen kapatır!!

        driver.get("https://demoqa.com/alerts");
        //alert handle etme
        driver.findElement(By.id("alertButton")).click();
       // WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(2));
        //wait1.until(ExpectedConditions.alertIsPresent()); //alert var mı onu bekle!!

        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();//alerte geç: accept() : kabul etmek
        //dismiss() : kabul etmeme, getText(): mesajı alır , sendKeys() : string ifade yollama

        //System.out.println(driver.switchTo().alert().getText()); alertteki yazıyı alma
        //driver.switchTo().alert().dismiss();

        driver.findElement(By.id("promtButton")).click();
        WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(4));
        wait2.until(ExpectedConditions.alertIsPresent());
        //objeye de atayabiliriz: Alert alert = driver.switchTo().alert();
        driver.switchTo().alert().sendKeys("melek");
        driver.switchTo().alert().accept(); */

        //Frame : sayfa içindeki sayfalar,ana sayfa altındaki html

        driver.get("https://demoqa.com/frames");
        //driver.switchTo().frame(0); //frame in indexi
        driver.switchTo().frame("frame1"); //id si
        Thread.sleep(6000);
        WebElement heading = driver.findElement(By.id("sampleHeading"));
        String text1 = heading.getText();
        System.out.println(text1);
        driver.switchTo().parentFrame();// ana sayafaya geri geçiş yaptım

        List<WebElement> elementList = driver.findElements(By.cssSelector("div[id='framesWrapper'] div"));
        String paragraph = elementList.get(0).getText();
        System.out.println(paragraph);

        /*
        driver.switchTo().frame(2);//bu frame e geçmek için önce ana sayfaya geçmen lazım
        WebElement heading2 = driver.findElement(By.id("sampleHeading"));
        String text1_ = heading2.getText();
        System.out.println(text1_); */


        //reklamlar iframe oluyor
        driver.get("https://demoqa.com/nestedframes");
       /* Thread.sleep(3000); //burada açılan sayfada reklam gelmedğii için sorun oldu
        WebElement adFrame =  driver.findElement(By.cssSelector("iframe[title='3rd party ad content']"));
        driver.switchTo().frame(adFrame); //artık reklam frameindeyiz,
        WebElement closeButton = driver.findElement(By.id("cbb")); //reklamın içindeki çarpı butonu
        closeButton.click();
*/
        //nested frame
        driver.switchTo().frame("frame1");//parent frame
        WebElement parentBody = driver.findElement(By.tagName("body"));
        System.out.println(parentBody.getText());
        driver.switchTo().frame(0); //şuan en küçük framedeyiz,parent frame in altındakini aldık
        WebElement p = driver.findElement(By.tagName("p"));
        System.out.println(p);

        //Modals : Arkadaki sayfayı pasife çeken pop-up !
        driver.get("https://demoqa.com/modal-dialogs");
        WebElement smallButton = driver.findElement(By.id("showSmallModal"));
        smallButton.click();
        WebElement modalText = driver.findElement(By.cssSelector("div.modal-body"));
        System.out.println(modalText.getText());
        WebElement smallCloseButton = driver.findElement(By.id("closeSmallModal"));
        smallCloseButton.click();

        //Accordians: tıklayınca açılıp,kapanan elementler,xpath kullanıcaz burda,xpath son tercih olmalı

        driver.get("https://demoqa.com/accordian");
        WebElement firstCard = driver.findElement(By.xpath("//div[@class='card'][1]/div[2]"));
        String className___ = firstCard.getAttribute("class");
        System.out.println(className___);
        driver.findElement(By.id("section1Heading")).click();
        className___ = firstCard.getAttribute("class");
        System.out.println(className___);

        //Auto complete : input alanına harf girince aşağıda öneriler çıkması
        driver.get("https://demoqa.com/auto-complete");
        WebElement input = driver.findElement(By.id("autoCompleteSingleInput"));
        input.sendKeys("R");
        List<WebElement> suggestions = driver.findElements(By.cssSelector("div.auto-complete__option"));

        for(WebElement suggestion : suggestions){
            String text__ = suggestion.getText();
            System.out.println(text__);
            if(text__.equalsIgnoreCase("red")){ //hepsine küçüğe çevir ,ara
                suggestion.click();
                break; //for loopda tekrar tekrar arama!
            }
        }

       // suggestions.get(0).click();

        //Date Picker : kullanıcıya tarih seçtirme,ay : dropdown (liste gibi)
        driver.get("https://demoqa.com/date-picker");

        selectDate("2023","January","13");

        //Slider
        driver.get("https://demoqa.com/slider");
        WebElement slider = driver.findElement(By.cssSelector("input[type='range']"));
        Actions action__ = new Actions(driver);
        //action__.dragAndDrop(slider,10).perform(); , bu metoda bak

        //Progress Bar
        driver.get("https://demoqa.com/progress-bar");
        WebElement startStopButton = driver.findElement(By.id("startStopButton"));
        startStopButton.click();
        WebElement progressbar = driver.findElement(By.cssSelector("div[rple='progressbar']"));
        //implicit: bütün projede etkili olucak bekleme koyulabilir
        //explicit: element bazında bekleme
        WebDriverWait wait__ = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait__.pollingEvery(Duration.ofMillis(100));
       // wait__.until(ExpectedConditions.attributeToBe(progressbar,"aria-valuenow","50"));
       // startStopButton.click();
        wait__.until(ExpectedConditions.attributeToBe(startStopButton,"10","resetButton"));

        //Tooltips:

        WebElement toolTipButton = driver.findElement(By.id("toolTipButton"));
        Actions action___ = new Actions(driver);
        action___.moveToElement(toolTipButton).perform();//üzerine gitme






    }
    private static void selectDate(String year , String month,String day)
    {
        //sadece bu classda kullanıcağımız için private static
        WebDriver driver_  = new ChromeDriver();
        WebElement dateSelection = driver_.findElement(By.id("datePickerMonthYearInput"));
        dateSelection.click();
        //select classı =dropdown
        WebElement monthElement = driver_.findElement(By.className("react-datepicker__month-select"));
        //select class dropdown menüsü var demektir
        Select select = new Select(monthElement);
        select.selectByVisibleText(month);
        WebElement yearElement = driver_.findElement(By.className("react-datepicker__year-select"));
        select = new Select(yearElement);
        select.selectByVisibleText(year);
        List<WebElement> daysElement_ = driver_.findElements(By.cssSelector("div.react-datepicker__day"));

        for(WebElement dayElement : daysElement_){
            //System.out.println(dayElement);
            String text_ = dayElement.getText();
            if(text_.equals(day)){
                dayElement.click();
                break;
            }

        }

    }

    public static boolean isFileDownload(String downloadPath, String fileName) {
        File file = new File(downloadPath);
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().equals(fileName)) {
                files[i].delete();
                return true;

            }

        }


        return false;
    }


}



package com.kblive.testCases;



import jdk.jfr.Category;
import org.assertj.core.util.Compatibility;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class tc1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\Driver\\dr\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        TakesScreenshot scrShot = ((TakesScreenshot)driver);
        // implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("https://www.kblive.com/login");

        WebElement username = driver.findElement(By.id("basic_username"));

        WebElement password = driver.findElement(By.id("basic_password"));

        WebElement login = driver.findElement(By.xpath("//span[contains(text(),'Login')]"));

        username.sendKeys("hello@dl1961.com");

        password.sendKeys("newyear100");

        login.click();

        Thread.sleep(2000);

        Boolean modalUserRole = driver.findElement(By.cssSelector(
                        "body.ant-scrolling-effect:nth-child(2) div.ant-modal-root div.ant-modal-wrap.ant-modal-centered div.ant-modal.modal-generic.modal-700 div.ant-modal-content:nth-child(2) div.ant-modal-body div.select-role-list div.ant-radio-group.ant-radio-group-outline.ant-radio-group-large > label.ant-radio-button-wrapper:nth-child(1)"))
                .isDisplayed();

        Thread.sleep(2000);

        if (modalUserRole == true) {
            WebElement ModalClick = driver.findElement(By.cssSelector(
                    "body.ant-scrolling-effect:nth-child(2) div.ant-modal-root div.ant-modal-wrap.ant-modal-centered div.ant-modal.modal-generic.modal-700 div.ant-modal-content:nth-child(2) div.ant-modal-body div.select-role-list div.ant-radio-group.ant-radio-group-outline.ant-radio-group-large > label.ant-radio-button-wrapper:nth-child(1)"));
            ModalClick.click();
            System.out.println("Admin option is selected from modal  >> Test Case Pass - 01");


            Boolean createEventBtn = driver.findElement(By.xpath("//span[contains(text(),'Create Event')]"))
                    .isDisplayed();

            if (createEventBtn == true) {
                System.out.println("Create Event Button is display  >> Test Case Pass -02");

                WebElement onClickEventBtn = driver.findElement(By.xpath("//span[contains(text(),'Create Event')]"));
                onClickEventBtn.click();

                String createEventActualUrl = driver.getCurrentUrl();
                String createEventExpectedUrl = "https://www.kblive.com/schedule-event";

                if (createEventActualUrl.equals(createEventExpectedUrl)) {
                    System.out
                            .println("Create Event Button is clicked >> Test Case Pass -03 >> << Expected Url Matched: " +
                                    createEventExpectedUrl);

                    WebElement enterTitle = driver.findElement(By.id("title"));
                    enterTitle.sendKeys("Testing QA");
                    Thread.sleep(2000);

                    WebElement category = driver.findElement(By.id("category_id"));
                    category.sendKeys("clothing");
                    category.sendKeys(Keys.DOWN);
                    category.sendKeys(Keys.ENTER);

                    WebElement enterDetails = driver.findElement(By.id("notes"));
                    enterDetails.sendKeys("notes");

                    WebElement enterDateTime = driver.findElement(By.id("datetime"));
                    enterDateTime.sendKeys("2023-01-19 12:18 PM");
                        WebElement Onclick_OkBtnDateTime = driver.findElement(By.xpath("//span[contains(text(),'OK')]"));
                    Onclick_OkBtnDateTime.click();
                    String DatePicker = enterDateTime.getAttribute("value");

                    if (DatePicker == null) {
                        System.out.println(" No Date Field is not filled Date: Null  :  >> Test Case Failed-04");
                    } else {
                        System.out.println(" Yes Date Field is filled Date:  >> " + DatePicker + " Test Case Pass -04");
                    }
                    WebElement enterPrimaryHost = driver.findElement(By.id("react-select-2-input"));
                    enterPrimaryHost.sendKeys("host1@gmail.com");
                    Thread.sleep(1000);
                    enterPrimaryHost.sendKeys(Keys.ENTER);

                    Thread.sleep(1000);

                    WebElement enterHost2 = driver.findElement(By.id("react-select-3-input"));
                    enterHost2.sendKeys("host2@gmail.com");
                    Thread.sleep(1000);
                    enterHost2.sendKeys(Keys.ENTER);

                    Thread.sleep(1000);

                    WebElement enterHost3 = driver.findElement(By.id("react-select-4-input"));
                    enterHost3.sendKeys("host3@gmail.com");
                    Thread.sleep(1000);
                    enterHost3.sendKeys(Keys.ENTER);

                    Thread.sleep(1000);

                    WebElement enterHost4 = driver.findElement(By.id("react-select-5-input"));
                    enterHost4.sendKeys("host4@gmail.com");
                    Thread.sleep(3000);
                    enterHost4.sendKeys(Keys.ENTER);

                    WebElement onClickNextBtn1 = driver.findElement(By.xpath(
                            "//body/div[@id='root']/section[1]/section[1]/main[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[2]"));
                    onClickNextBtn1.click();

                    Thread.sleep(5000);

                    WebElement onBannerClick = driver.findElement(By.xpath("//span[contains(text(),'Use a sample image')]"));

                    if (onBannerClick.isDisplayed() == true) {
                        System.out.println("CheckBox Displayed >> Test Case Pass -05");
                        onBannerClick.click();
                        Thread.sleep(2000);

                        if (onBannerClick.isEnabled()) {
                            System.out.println("CheckBox Is Checked >> Test Case Pass -06");
                            WebElement thankYouField = driver.findElement(By.id("thankyou_message"));
                            thankYouField.sendKeys("Testing Message : Thank everyone for attending the event");

//                            WebElement onCLickPreviousBtn = driver.findElement(By.xpath("//span[contains(text(),'Previous')]"));
//                            if (onCLickPreviousBtn.isDisplayed()) {
//                                onCLickPreviousBtn.click();
//                                System.out.println("Click On Previous Button");
//                            } else {
//                                System.out.println("Previous Button is not displayed");
//                            }
//                            if (onClickNextBtn1.isDisplayed()) {
//                                onClickNextBtn1.click();
//                            } else {
//                                System.out.println("Next Button 1 is not displayed");
//                            }
                            WebElement onClickNextBtn2 = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
                            if (onClickNextBtn2.isDisplayed()) {
                                onClickNextBtn2.click();
                            } else {
                                System.out.println("Next Button 2 is not displayed");
                            }
                        }
                        else {
                            System.out.println("CheckBox Is not Checked >> Test Case Fail -06");
                        }
                        WebElement productSKU = driver.findElement(By.id("react-select-6-input"));
                        if (productSKU.isDisplayed()) {
                            System.out.println("Product SKU is Displayed");
                                                              String sku[] ={"13168", "13177", "13108"};
                                                              for(int i=0; i<sku.length; i++)
                                                              {
                                                              productSKU.sendKeys(sku[i]);
                                                              Thread.sleep(2000);
                                                              productSKU.sendKeys(Keys.ENTER);
                                                              Thread.sleep(2000);
                                                              }
                                                              WebElement onClickCreateEventBtn = driver.findElement(By.xpath("//span[contains(text(),'Create Event')]"));

                            if (onClickCreateEventBtn.isDisplayed()) {
                                System.out.println("Created Event Button is Displayed >> Test Case Pass -07");
                                onClickCreateEventBtn.click();
                                Thread.sleep(3000);
                                WebElement CreateEventModalText = driver.findElement(By.xpath("//span[contains(text(),'Go to Event')]"));

                                String ActualText = CreateEventModalText.getText();
                                String ExpectedText = "Go to Event";



                                if (ActualText.equals(ExpectedText)) {
                                    Thread.sleep(3000);
                                    WebElement onCLickGoToEventBtn = driver.findElement(By.xpath("//body/div[5]/div[1]/div[2]/div[1]/div[2]/div[2]/button[1]"));
                                    if(onCLickGoToEventBtn.isDisplayed()){
                                        onCLickGoToEventBtn.click();
                                        System.out.println("Final Result: Create Event Test Passed using Sample Image >> Test Case Pass -08");

                                        driver.quit();
                                    }else{
                                        System.out.println("Go To Event Button Is Not Displayed using Sample Image >> Test Case Failed ");

                                    }

                                }else {
                                    System.out.println("Final Result: Create Event Test Failed >> Test Case Failed -08");
                                }
                            } else {
                                System.out.println("Created Event Button Is Not Displayed >> Test Case Failed -07 ");
                            }
                        } else {
                            System.out.println("Product SKU is not Displaced");
                        }
                    } else {
                        System.out.println("CheckBox Note Displayed >> Test Case Fail -05");
                    }

                } else {
                    System.out.println("Create Event Button is not clicked >> Test Case Failed - 03");
                }

            } else {
                System.out.println("Create Event Button is not display >> Test Case Failed -02 >> << Actual Url: ");
            }
        } else {
            System.out.println("Admin option is not selected from modal >> Test Case Failed - 01");
        }

    }

}
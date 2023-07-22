package org.example.User;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class annotation_create {
 WebDriver driver;
    @Given("I am on task creation page {string} and password {string}")
    public void i_am_on_task_creation_page_and_password(String string3, String string4) {

        // Set up the Chrome driver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://annotation.wakeb.tech/en/dashboard/projects/image/69");


        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys(string3);
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(string4);

        // Click login button
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[2]/div/form/div[3]/button"));
        loginButton.click();

    }
    @When("When click on open Task")
    public void when_click_on_open_task() throws InterruptedException {

        WebElement OpenTask = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]/span[1]/div[1]/div[4]/form[1]/button[1]/i[1]"));
        OpenTask.click();

        WebElement Adminannotation= driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[4]/a[1]/i[1]"));
        Adminannotation.click();
        Thread.sleep(5000);

    }

    @When("make a annotation to more than one image")
    public void make_a_annotation_to_more_than_one_image() throws IOException {

        WebElement image = driver.findElement(By.cssSelector("#imageAnnotation_1"));
        Actions actions = new Actions(driver);
        actions.moveToElement(image, 0, 0);
        actions.clickAndHold();
        actions.moveByOffset(100, 300);
        actions.release();
        actions.build().perform();

}

    @Then("make a annotation to the second image")
    public void make_a_annotation_to_the_second_image() throws InterruptedException {
        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/button[2]")).click();
        Thread.sleep(3000);
        WebElement image = driver.findElement(By.className("a9s-annotationlayer"));
        Actions actions = new Actions(driver);
        actions.moveToElement(image, 0, 0);
        actions.clickAndHold();
        actions.moveByOffset(200, 200);
        actions.release();
        actions.build().perform();
    }

}






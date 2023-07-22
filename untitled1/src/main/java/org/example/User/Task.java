package org.example.User;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Task {
    private WebDriver driver;
    WebDriverWait wait;

    @Given("I am on the task creation page {string} and password {string}")
    public void iAmOnTheTaskCreationPage(String emai, String passwor) throws InterruptedException {

        // Set up the Chrome driver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://annotation.wakeb.tech/en/dashboard/upload-files/image/49");


        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys(emai);
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(passwor);

        // Click login button
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[2]/div/form/div[3]/button"));
        loginButton.click();

        // Find the icon element
        WebElement icon = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/div[1]/a/i"));
        icon.click();

        // Find and click on the add task icon
        WebElement addTaskIcon = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/div[2]/div[3]/div"));
        addTaskIcon.click();

    }

    @When("I enter a random task name")
    public void iEnterARandomTaskName() throws InterruptedException {


        String taskName = generateRandomName();
        // Enter the task name
        WebElement taskNameInput = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
        taskNameInput.sendKeys(taskName);

        // Select random users
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Find the dropdown element
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div/div/div/div/div/div[1]/div[1]/div/div[2]/div/div[1]")).click();
        // Get all the options within the dropdown
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]")).click();
        Thread.sleep(5000);


        // Choose a zip file
        String filePath = "C:\\Users\\Acer\\OneDrive - Wakeb\\Desktop\\img2.zip";

        driver.findElement(By.id("inputFileUpload")).sendKeys(filePath);


       // Check if the file upload was successful
        if (driver.getPageSource().contains("File Uploaded!")) {
            System.out.println("File upload success");
        } else {
            System.out.println("File upload failed");
        }

        Thread.sleep(5000);

        // Publish the task
      WebElement publishButton = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/button[1]"));
      publishButton.click();



    }
    private static String generateRandomName() {
        Random rand = new Random();
        String[] words = {"Task", "Automation", "Random", "Name"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1; i++) {
            sb.append(words[rand.nextInt(words.length)]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }


}








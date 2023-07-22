package org.example.User;


import io.cucumber.java.Before;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Users {

    private WebDriver driver;
    WebDriverWait wait;
    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        // Open the website
        driver.get("https://annotation.wakeb.tech/login");

    }

    @When("I login with email {string} and password {string}")
    public void i_login_with_email_and_password(String email, String password) {
        // Enter email and password
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys(email);
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);

        // Click login button
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[2]/div/form/div[3]/button"));
        loginButton.click();

    }

    @When("I navigate to the users page")
    public void i_navigate_to_the_users_page() throws InterruptedException {
        // Click users link in the sidebar
        WebElement userIcon = driver.findElement(By.xpath("//*[@id=\"menu\"]/li[4]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(userIcon).perform();

        // Click on the "Users" option
        WebElement usersOption = driver.findElement(By.linkText("User"));
        usersOption.click();
        //wait.until(ExpectedConditions.urlContains("users"));
        driver.navigate().refresh();
//        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/a[2]/i[1]")).click();
//        System.out.println("hello");
//        Thread.sleep(5000);
//        //            // Fill in the user details and submit the form 10 times
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        // Loop to create 10 users
        for (int i = 0; i < 10; i++) {

            driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/a[2]/i[1]")).click();
            System.out.println("hello");
            Thread.sleep(5000);
            // Fill in the user details and submit the form 10 times

            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
            // Generate random first and last name
            String firstName = generateRandomString(5);
            String lastName = generateRandomString(5);

            // Generate random email
            String email = generateRandomString(8) + "@example.com";

            // Enter first name
            WebElement firstNameInput = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div/div[4]/div/div/div[2]/form/div[1]/div[2]/input"));
            firstNameInput.sendKeys(firstName);

            // Enter last name
            WebElement lastNameInput = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div/div[4]/div/div/div[2]/form/div[1]/div[3]/input"));
            lastNameInput.sendKeys(lastName);

            // Enter email
            WebElement emailInput = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div/div[4]/div/div/div[2]/form/div[1]/div[4]/input"));
            emailInput.sendKeys(email);
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div/div[4]/div/div/div[2]/form/div[1]/div[5]/div[3]/div/input")).click();

            // Select "user" role from the checklist
//                    WebElement roleSelect = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div/div[4]/div/div/div[2]/form/div[1]/div[5]/div[3]/div/input"));
//                    Select select = new Select(roleSelect);
//                    select.selectByValue("2");

            // Submit the form
            WebElement submitButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div/div[4]/div/div/div[2]/form/div[2]/button[1]/span[1]"));
            submitButton.click();

            Thread.sleep(10000);

            // Wait for the success message to appear
            WebElement successMessage2 = driver.findElement(By.xpath("/html/body/div[9]/div/div[6]/button[1]"));
            successMessage2.click();

        }

    }

    // Helper method to generate a random string of given length
    private static String generateRandomString(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }


    //driver.navigate().refresh();

    @And("I add users with role of user")
    public void i_add_users_with_role_of_user() throws InterruptedException {

        // Click users link in the sidebar
        WebElement annotationcon = driver.findElement(By.xpath("/html/body/div[2]/div/nav/ul/li[3]/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(annotationcon).perform();

        // Click on the "Users" option
        WebElement usersOption = driver.findElement(By.xpath("/html/body/div[2]/div/nav/ul/li[3]/a"));
        usersOption.click();

        // Repeat the cycle two times
        // Click on the add icon
        WebElement addIcon = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/div/a[2]/i"));
        addIcon.click();

//        // Fill the first name
//        WebElement firstNameInput = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[2]/div/div/div[2]/form/div[1]/div/div[1]/input"));
//        firstNameInput.sendKeys("ProjectC");

//                    // Select checkbox value 2
//                    WebElement dropdown = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[2]/div/div/div[2]/form/div[1]/div/div[2]/select"));
//                    Select select = new Select(dropdown);
//
//                    // Select "5 users" from the dropdown by value
//                    select.selectByVisibleText("bxeco gmyqw");
//                    select.selectByVisibleText("zbtkp ylkit");
//                    select.selectByVisibleText("xycvk xhaya");


        // Add project with random name and random select in dropdown***************************************************************************//


        // Generate a random name
        String name = generateRandomName();

        // Find the name input field and enter the random name
        WebElement nameInput = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[2]/div/div/div[2]/form/div[1]/div/div[1]/input"));
        nameInput.sendKeys(name);


        WebElement dropdown = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[2]/div/div/div[2]/form/div[1]/div/div[2]/select"));
        Select select = new Select(dropdown);
        List<WebElement> options = select.getOptions();

        // Select a random option from the dropdown list
        int randomIndex = getRandomIndex(options.size());
        select.selectByIndex(randomIndex);


        // Find the submit button and click on it
        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[2]/div/div/div[2]/form/div[2]/button[1]"));
        submitButton.click();

        // Close the browser
        //driver.quit();
    }

    private static int getRandomIndex(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }


    private static String generateRandomName() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        int length = rand.nextInt(10) + 5; // Random length between 5 and 14

        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }

        return sb.toString();
    }


    @And("add segmentation and label")
    public void add_segmentation_and_label() throws InterruptedException {

        // choose the record
        driver.navigate().refresh();

        // Click on the record in the first column
        WebElement firstColumnRecord = driver.findElement(By.partialLinkText("pbeVB"));
        firstColumnRecord.click();
        Thread.sleep(5000);


        ////////////////////////////// Click on the add icon segmentation
        WebElement addIconseg = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/div/a[2]/i"));
        addIconseg.click();

        // Fill the first name
        String nam = generateRandomNam();

        // Find the name input field and enter the random name
        WebElement firstName = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[2]/div/div/div[2]/form/div[1]/div/div[1]/input"));
        firstName.sendKeys(nam);

        // Select  from the dropdown
        WebElement dropdow = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[2]/div/div/div[2]/form/div[1]/div/div[3]/span"));
        dropdow.click();
        WebElement dropdowpp = driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[2]"));
        dropdowpp.click();


        // Add segemntation with random name and random select in dropdown***************************************************************************//


//        WebElement dropdow = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[2]/div/div/div[2]/form/div[1]/div/div[3]/span/span[1]/span"));
//        Select select1 = new Select(dropdow);
//        List<WebElement> options = select1.getOptions();
//
//        // Select a random option from the dropdown list
//        int randomInde = getRandomInde(options.size());
//        select1.selectByIndex(randomInde);


        // fill the cost
        WebElement cost = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[2]/div/div/div[2]/form/div[1]/div/div[7]/input"));
        cost.sendKeys("0.30");

        // Click on the submit button
        WebElement submitButton1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[2]/div/div/div[2]/form/div[2]/button[1]/span[1]"));
        submitButton1.click();

        Thread.sleep(6000);

        // Wait for the success message to appear
        WebElement successMessage3 = driver.findElement(By.xpath("/html/body/div[9]/div/div[6]/button[1]"));
        successMessage3.click();

        // choose the record
        driver.navigate().refresh();

        // Click on the record in the first column
        WebElement firstColumnRecordseg = driver.findElement(By.partialLinkText("HlrhufXzWu"));
        firstColumnRecordseg.click();
        Thread.sleep(5000);

    }

    private static int getRandomInde(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }


    private static String generateRandomNam() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        int length = rand.nextInt(10) + 5; // Random length between 5 and 14

        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }

        return sb.toString();
    }


    @Then("add label and task")
    public void add_label_and_task() throws InterruptedException {

        WebElement LabelIcon = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/div[1]/a/i"));
        LabelIcon.click();

        // Click on the "label icon" option
        WebElement LABELOption = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/a"));
        LABELOption.click();

        // Click on the "label Name " option
        WebElement LABELName = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div[2]/form/div/div[2]/div[1]/input"));
        LABELName.sendKeys("mode");

        // Click on the "label aria-haspopup " option

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div[2]/form/div/div[2]/div[2]/span/span[1]/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/span/span/span/ul/li[2]/span")).click();
        //Select LABELariahaspopup = new Select(driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div[2]/form/div/div[2]/div[2]/span/span[1]/span")));
        // LABELariahaspopup.selectByVisibleText("fa-adjust");


        // Click on the "label color " option
        WebElement LABELColor= driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div[2]/form/div/div[1]/span[3]"));
        LABELColor.click();

        // Click on the "save " option
        WebElement savebutton= driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div[2]/form/div/div[2]/div[3]/button"));
        savebutton.click();
        Thread.sleep(5000);

        // Click on the "close color" option
        WebElement closeicon1= driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div[1]/div[2]/span"));
        closeicon1.click();



    }
}



package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.naming.Name;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$")
    public void iAmOnAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }


    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
    }

    @And("^I should see menu$")
    public void iShouldSeeMenu() throws Throwable {
        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
    }

    @And("^I click the result checkbox button$")
    public void iClickTheResultCheckboxButton() throws Throwable {
        driver.findElement(By.id("result_button_checkbox")).click();
    }

    @When("^I clicked on checkboxes:$")
    public void iClickedOnCheckboxes(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.cssSelector("[value='" + value + "']")).click();
        }
    }

    @Then("^message for checkboxes \"([^\"]*)\" is seen$")
    public void messageForCheckboxesIsSeen(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("result_checkbox")).getText());
    }


    @Given("^I am on page$")
    public void iAmOnPage() {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");

    }

    @When("^I enter number: \"([^\"]*)\"$")
    public void iEnterNumber(String number) throws Throwable {
        driver.findElement(By.cssSelector("#numb")).clear();
        driver.findElement(By.xpath("//input[@id='numb']")).sendKeys(number);

    }

    @And("^I click: \"([^\"]*)\"$")
    public void iClick(String submit) throws Throwable {
        driver.findElement(By.xpath(" //button[contains(text(),'Submit')]")).click();


    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.xpath("//p[@id='ch1_error']")).getText());

    }


    @Then("^I should see: \"([^\"]*)\"$")
    public void iShouldSee(String message) throws Throwable {
        Alert alert1 = driver.switchTo().alert();
        //assertTrue(alert1.isDisplayed());
        assertEquals(message, alert1.getText());
        alert1.accept();
    }


    @Given("^I am on action page: \"([^\"]*)\"$")
    public void iAmOnActionPage(String arg0) throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html");

    }

    @When("^I clicked on button: \"([^\"]*)\"$")
    public void iClickedOnButton(String arg0) throws Throwable {
        driver.findElement(By.id("addPersonBtn")).click();
        // driver.findElement(By.id("Add person")).click();
    }

    @And("^I enter info: \"([^\"]*)\"$")
    public void iEnterInfo(String arg0) throws Throwable {
       driver.findElement(By.id("name")).sendKeys("Nat");
    }

    @And("^I enter job: \"([^\"]*)\"$")
    public void iEnterJob(String arg0) throws Throwable {
        driver.findElement(By.id("job")).sendKeys("Teacher");
    }

    @And("^I click submit: \"([^\"]*)\"$")
    public void iClickSubmit(String arg0) throws Throwable {
       driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
    }

    @Then("^I see added name and job$")
    public void iSeeAddedNameAndJob(String arg0, String arg1) {
    WebElement newPerson = driver.findElement(By.id("person3"));
    assertTrue(newPerson.isDisplayed());
        //driver.findElement(By.className("w3-xlarge name")).getAttribute("value");
        //driver.findElement(By.className("job")).getAttribute("value");
        //assertEquals("Nat", driver.findElement(By.className("w3-xlarge name")).getText());
        //assertEquals("Teacher", driver.findElement(By.className("job")).getText());
    }

    @Given("^I am on action page$")
    public void iAmOnActionPage() {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html");
    }

    @When("^I click editor on$")
    public void iClickEditorOn() {
        driver.findElement(By.xpath("//body/div[3]/div[1]/div[1]/ul[1]/div[4]/li[1]/span[2]/i[1]")).click();
    }

    @And("^I clicked on field Name$")
    public void iClickedOnFieldName() {
    driver.findElement(By.id("name")).click();
    }

    @And("^I enter value: \"([^\"]*)\"$")
    public void iEnterValue(String arg0) throws Throwable {
        driver.findElement(By.id("name")).sendKeys("Ann");
    }

    @And("^I click on button Edit$")
    public void iClickOnButtonEdit() {
    driver.findElement(By.xpath("//button[contains(text(),'Edit')]")).click();
    }

    @Then("^I see the name is changed: \"([^\"]*)\"$")
    public void iSeeTheNameIsChanged(String arg0) throws Throwable {
        driver.findElement(By.xpath("//span[contains(text(),'Ann')]")).getAttribute("value");
        assertEquals("Ann", driver.findElement(By.xpath("//span[contains(text(),'Ann')]")).getText());
    }


    @When("^I click on remover button on: \"([^\"]*)\"$")
    public void iClickOnRemoverButtonOn(String arg0) throws Throwable {
        driver.findElement(By.cssSelector("div.w3-row:nth-child(3) div.w3-half div.w3-container ul.w3-ul.w3-card-4 div.w3-padding-16:nth-child(2) li:nth-child(1) > span.w3-closebtn.closebtn.w3-padding.w3-margin-right.w3-medium:nth-child(1)")).click();
    }

    @Then("^I see name disapeared$")
    public void iSeeNameDisapeared(String arg0) {
        driver.findElement(By.xpath("//span[contains(text(),'Jill')]"));
    assertFalse(driver.findElement(By.xpath("//span[contains(text(),'Jill')]")).isDisplayed());

    }

    @When("^I click on button: \"([^\"]*)\"$")
    public void iClickOnButton(String arg0) throws Throwable {
    driver.findElement(By.xpath("//body/div[4]/button[2]")).click();
    }

    @Then("^I see the added names and jobs are not displayed$")
    public void iSeeTheAddedNamesAndJobsAreNotDisplayed() {
        driver.findElement(By.xpath("//li[@id='person0']"));
        driver.findElement(By.xpath("//li[@id='person1']"));
        driver.findElement(By.xpath("//li[@id='person2']"));

        assertTrue(driver.findElement(By.xpath("//li[@id='person0']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//li[@id='person1']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//li[@id='person2']")).isDisplayed());
    }

    @Given("^I am on page:  \"([^\"]*)\"$")
    public void iAmOnPage(String arg0) throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_new_person_with_a_job.html");

    }

    @When("^I enter infoname: \"([^\"]*)\"$")
    public void iEnterInfoname(String arg0) throws Throwable {
        driver.findElement(By.id("name")).sendKeys("Bruno");
        assertEquals("Bruno",driver.findElement(By.id("name")));
    }

    @And("^I enter jobname: \"([^\"]*)\"$")
    public void iEnterJobname(String arg0) throws Throwable {
        driver.findElement(By.id("job")).sendKeys("Cowboy");
        assertEquals("Cowboy",driver.findElement(By.id("job")));
    }

    @And("^I click button: \"([^\"]*)\"$")
    public void iClickButton(String arg0) throws Throwable {
        driver.findElement(By.xpath("//button[@id='addPersonBtn']")).click();
    }

    @Then("^I see all fields are empty$")
    public void iSeeAllFieldsAreEmpty() {
        assertFalse(driver.findElement(By.id("name")).isDisplayed());
        assertFalse(driver.findElement(By.id("job")).isDisplayed());
    }

}







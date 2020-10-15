package BDD.StepsDef;

import Base.BasePage;
import Pages.StudentsPage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class StudentDefs extends BasePage {

    public StudentsPage studentsPage;

    @Before
    public void setUp() throws InterruptedException {
        initialization();
        studentsPage=new StudentsPage();
    }

    @Given("^User is in student menu$")
    public void userIsInStudentMenu() throws InterruptedException {
        studentsPage.navigateStudentsmenu();
        Thread.sleep(5000);
    }

    @When("^User clicks on new student link$")
    public void userClicksOnNewStudentLink() throws InterruptedException {
        studentsPage.clickCreateNew();
        Thread.sleep(5000);
    }

    @Then("^User verifies create heading$")
    public void userVerifiesCreateHeading() {
        studentsPage.verifyHeadingCreate();
    }

    @When("^User enters last name$")
    public void userEntersLastName() throws InterruptedException {
        studentsPage.enterLastName();
        Thread.sleep(3000);
    }

    @And("^User enters first name$")
    public void userEntersFirstName() throws InterruptedException {
        // Enter forms Value
        studentsPage.enterFirstName();
        Thread.sleep(3000);
    }


    @And("^User enters enrollment date$")
    public void userEntersEnrollmentDate() throws InterruptedException {
        studentsPage.enterEnrollmentDate();
        Thread.sleep(3000);
    }

    @And("^User click on create button$")
    public void userClickOnCreateButton() {
        studentsPage.clickCreateButton();
    }

    @Then("^Verify User added is listed on the student list$")
    public void verifyUserAddedIsListedOnTheStudentList() throws InterruptedException {
        //
        String searchStudent="Nirman";
        byte count=0;
        List<String> students;
        students=studentsPage.getAllStudentsNameList();
        for(String eachStudent:students){
            System.out.println(eachStudent);
            if(eachStudent.equals(searchStudent)) {
                count++;
            }
            if(count>0)
                break;
            else
                continue;
        }
        //if count >0, we found the user
        if(count!=0)
            Assert.assertTrue(true);
        else
            Assert.assertFalse(false);
    }

    @When("^User enters find by name as \"([^\"]*)\"$")
    public void userEntersFindByNameAs(String name) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // new PendingException();
        studentsPage.enterNameSearchButton(name);

    }

    @And("^User clicks on search button$")
    public void userClicksOnSearchButton() {
        studentsPage.clickSearchButton();

    }

    @And("^User clicks on delete button$")
    public void userClicksOnDeleteButton() {
        studentsPage.clickAllDeleteButtons();
    }

    @And("^User clicks on confirm delete button$")
    public void userClicksOnConfirmDeleteButton() {
        studentsPage.clickDeleteConfirm();
    }

    @When("^User enters find by name as \"([^\"]*)\" and delete all from list$")
    public void userEntersFindByNameAsAndDeleteAllFromList(String name) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        boolean flag=true;
        while(flag==true) {
            studentsPage.enterNameSearchButton(name);
            studentsPage.clickSearchButton();
            if(studentsPage.getDeteleteButtonsSize()>0) {
                studentsPage.clickDeleteButtons();
                studentsPage.clickDeleteConfirm();
            }
            else
            {
                break;
            }
        }

    }

    @Then("^Verify user \"([^\"]*)\" is not in the student list$")
    public void verifyUserIsNotInTheStudentList(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @After
    public void exit(){
        wd.quit();
    }

}

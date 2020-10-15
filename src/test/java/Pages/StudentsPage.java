package Pages;

import Base.BasePage;
import Common.CommonPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentsPage extends BasePage {

    CommonPage cp=new CommonPage();

    @FindBy(xpath="//a[text()='Students']")
    WebElement studentsMenu;

    @FindBy(xpath = "/html/body/div/p/a")
    WebElement lnkCreateNew;

    //Create Heading
    @FindBy(xpath = "//h2[text()='Create']")
    WebElement headingCreate;

    //Students Info
    @FindBy(id="LastName")
    WebElement lastName;

    @FindBy(id="FirstMidName")
    WebElement firstName;

    @FindBy(id="EnrollmentDate")
    WebElement enrollmentDate;

    @FindBy(xpath ="//input[@class='btn btn-default']")
    WebElement createButton;

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr/td[2]")
    List<WebElement> eStudents;

    @FindBy(xpath ="//a[text()='»']")
    List<WebElement> nextButton;

    @FindBy(id="SearchString")
    WebElement eSearchTextBox;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement eSearchButton;

    @FindBy(xpath="/html/body/div[2]/table/tbody/tr/td[4]/a[3]")
    List<WebElement> eDeleteButtons;

    @FindBy(xpath="//input[@type='submit']")
    WebElement eDeleteConfirm;


    public StudentsPage() {
        PageFactory.initElements(wd,this);
    }

    public void navigateStudentsmenu(){
        studentsMenu.click();
    }

    public void clickCreateNew(){
        lnkCreateNew.click();
    }

    public void clickSearchButton(){
        eSearchButton.click();
    }


    public void verifyHeadingCreate(){
        cp.isElementDisplayed(headingCreate);
    }

    public void enterFirstName(){
        cp.enterData(firstName,prop.getProperty("FIRST_NAME"));
    }

    public void enterLastName(){
        cp.enterData(lastName,prop.getProperty("LAST_NAME"));
    }

    public void enterEnrollmentDate(){
        String pattern = "MM/dd/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        cp.enterData(enrollmentDate,date);
    }

    public void clickCreateButton(){
        createButton.click();
    }

    public String getHomePageTitle(){
        return wd.getTitle();
    }


    public List<String> getAllStudentsNameList() throws InterruptedException {
        //System.out.println(students.size());
        //click till the next button is disabled , add all the pages records
        //Note: if nextButton is not kept in array, it then we can't use the size(), and
        //since for single element, only
        List<String> students=new ArrayList<>();
        for(WebElement eStudent:eStudents) {
            students.add(eStudent.getText());
        }
        while(nextButton.size() > 0 && nextButton.get(0).isDisplayed()==true){
            nextButton.get(0).click();
            for(WebElement eStudent:eStudents) {
                students.add(eStudent.getText());
            }
           // Thread.sleep(3000);
        }
                return students;
    }

    public void enterNameSearchButton(String name) {
        eSearchTextBox.sendKeys(name);
    }

    public void clickAllDeleteButtons() {
        while (eDeleteButtons.size() > 0) {
            clickDeleteButtons();
            clickDeleteConfirm();
        }
    }

    public void clickDeleteButtons(){
        eDeleteButtons.get(0).click();
    }

    public int getDeteleteButtonsSize(){
        return eDeleteButtons.size();
    }

    public void clickDeleteConfirm(){
        eDeleteConfirm.click();
    }

    public void close(){
        wd.quit();
    }

}




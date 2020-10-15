package Common;

import Base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeaderPage extends BasePage {

    public HeaderPage() {
        PageFactory.initElements(wd, this);
    }

    //LIST of menues
    int expNoOfMenu=6;
    List<String> menuItems=new ArrayList<>(
            Arrays.asList("Home","About","Students","Courses","Instructors","Departments")
    );

    @FindBy(xpath="//ul[@class='nav navbar-nav']/li")
    public List<WebElement> menus;


    public void verifyMenus(){
        //This will verify menus has:  Home About Students Courses Instructors Departments
        List<String> elements=new ArrayList<>();
        for (WebElement element: menus) {
            elements.add(element.getText().toString());
        }
        Assert.assertEquals(elements.toString(),menuItems.toString());
    }
}

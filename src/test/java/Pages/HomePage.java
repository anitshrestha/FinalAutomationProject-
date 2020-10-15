package Pages;

import Base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePage extends BasePage {

    @FindBy(className="jumbotron")
    WebElement bannerTitle;


    public HomePage() {
        PageFactory.initElements(wd,this);
    }


    public String getHomePageTitle(){
        return wd.getTitle();
    }

    public String getBannerTitle(){
        return bannerTitle.getText();
    }

}




package Common;

import Base.BasePage;
import org.openqa.selenium.WebElement;

public class CommonPage extends BasePage {

    public boolean isElementDisplayed(WebElement webElement){
        return webElement.isDisplayed();
    }

    public void enterData(WebElement webElement, String value){
          webElement.sendKeys(value);
    }

}

package BDD.Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/BDD/Features",
        glue="BDD/StepsDef",
        tags = {"@Create"}
        )

public class CreateStudent_Runner {

}

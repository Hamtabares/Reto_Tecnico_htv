package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/datapiker.feature"},
        glue = {"stepdefinitions"},
        plugin = {"pretty", "html:build/serenity"},
        tags = "@id1"
)
public class TestRunner {

}

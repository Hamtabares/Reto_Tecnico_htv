package co.sqasa.tasks;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;

import static co.sqasa.ui.SearchDatePiker.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NextMonth implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        driver.switchTo().frame(
                driver.findElement(By.cssSelector(".demo-frame")));
        actor.attemptsTo(
                Click.on(DATE_BUTTON).afterWaitingUntilEnabled(),
                WaitUntil.the(NEXT_MONTH, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(NEXT_MONTH).afterWaitingUntilEnabled(),
                Click.on(NEXT_DAY_MONTH));

    }
public static NextMonth nextDay(){
        return Tasks.instrumented(NextMonth.class);
}
}

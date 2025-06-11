package co.sqasa.tasks;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;

import static co.sqasa.ui.SearchDatePiker.DATEPIKER;
import static co.sqasa.ui.SearchDatePiker.DATE_BUTTON;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CurrentDate implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        driver.switchTo().frame(
                driver.findElement(By.cssSelector(".demo-frame")));

        actor.attemptsTo(
                WaitUntil.the(DATE_BUTTON, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(DATE_BUTTON).afterWaitingUntilEnabled(),
                Click.on(DATEPIKER));

    }

    public static CurrentDate date15() {
        return Tasks.instrumented(CurrentDate.class);
    }
}

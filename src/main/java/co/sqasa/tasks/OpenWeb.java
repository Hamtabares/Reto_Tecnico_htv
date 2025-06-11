package co.sqasa.tasks;

import co.sqasa.ui.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class OpenWeb implements Task {
    private HomePage homePage;

    public static Performable theHomePage() {
        return Tasks.instrumented(OpenWeb.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(homePage));


    }
}

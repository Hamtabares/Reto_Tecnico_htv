package co.sqasa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.sqasa.ui.SearchDatePiker.*;

public class ManualDate implements Task {

    private final String date;

    public ManualDate(String date) {
        this.date = date;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DATE_BUTTON).afterWaitingUntilEnabled(),
                Clear.field(DATE_BUTTON),
                Enter.theValue(date).into(DATEPIKER));
    }

    public static NextMonth date(String date) {
        return Tasks.instrumented(NextMonth.class,date);
    }
}
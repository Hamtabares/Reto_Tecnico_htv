package co.sqasa.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ReadOnly implements Question<Boolean> {

    private final Target target;

    public ReadOnly(Target target) {
        this.target = target;
    }

    public static ReadOnly forField(Target target) {
        return new ReadOnly(target);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        WebElementFacade element = target.resolveFor(actor);
        return element.getAttribute("readonly") != null || element.getAttribute("disabled") != null;
    }
}
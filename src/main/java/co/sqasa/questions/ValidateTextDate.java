package co.sqasa.questions;

import co.sqasa.ui.SearchDatePiker;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ValidateTextDate implements Question<Boolean> {

    private final String expectedDate;

    public ValidateTextDate(String expectedDate) {
        this.expectedDate = expectedDate;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        WebElementFacade element = BrowseTheWeb.as(actor).find(SearchDatePiker.DATE_BUTTON);
        String actualText = element.getValue();
        System.out.println("Actual: [" + actualText + "] | Expected: [" + expectedDate + "]");
        return actualText.trim().equals(expectedDate.trim());

    }

    public static ValidateTextDate is(String expectedDate) {
        return new ValidateTextDate(expectedDate);
    }
}
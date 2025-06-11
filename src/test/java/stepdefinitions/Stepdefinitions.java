package stepdefinitions;

import co.sqasa.questions.ValidateTextDate;
import co.sqasa.tasks.CurrentDate;
import co.sqasa.tasks.ManualDate;
import co.sqasa.tasks.NextMonth;
import co.sqasa.tasks.OpenWeb;
import co.sqasa.ui.SearchDatePiker;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Attribute;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class Stepdefinitions {
    @Before
    public void configuracionInicial() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que abro la pagina principal de JQuery Datepicker")
    public void queAbroLaPaginaPrincipalDeJQueryDatepicker() {
        OnStage.theActor("sqandres").wasAbleTo(OpenWeb.theHomePage());
    }

    @When("hago clic en el campo de selección de fecha")
    public void hagoClicEnElCampoDeSelecciónDeFecha() {
        OnStage.theActorInTheSpotlight().wasAbleTo(CurrentDate.date15());
    }

    @Then("la fecha seleccionada debe aparecer en el campo de texto {string}")
    public void laFechaSeleccionadaDebeAparecerEnElCampoDeTexto(String date) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidateTextDate.is(date))
        );
    }

    @And("navego hasta el proximo mes")
    public void navegoHastaElProximoMes() {
        OnStage.theActorInTheSpotlight().wasAbleTo(NextMonth.nextDay());

    }

    @When("intento ingresar una fecha manualmente en el campo de texto {string}")
    public void intentoIngresarUnaFechaManualmenteEnElCampoDeTexto(String date) {
        OnStage.theActorInTheSpotlight().wasAbleTo(ManualDate.date(date));
    }

    @Then("no se debe permitir la edición manual")
    public void noSeDebePermitirLaEdiciónManual() {
        OnStage.theActorInTheSpotlight().should(
                seeThat("campo es readonly",
                        Attribute.of(SearchDatePiker.DATE_BUTTON, "readonly"),
                        equalTo("true"))


        );

    }


}

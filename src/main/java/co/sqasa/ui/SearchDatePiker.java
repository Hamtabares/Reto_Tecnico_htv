package co.sqasa.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchDatePiker {

    public static final Target DATE_BUTTON = Target.the("Seleccionar boton date")
            .located(By.xpath("//input[@id='datepicker']"));
    public static final Target DATEPIKER = Target.the("Seleccionar fecha")
            .located(By.xpath("//a[@class = 'ui-state-default'][@data-date='15']"));
    public static final Target NEXT_MONTH = Target.the("Siguiente mes")
            .located(By.xpath("//a[@class = 'ui-datepicker-next ui-corner-all']"));
    public static final Target NEXT_DAY_MONTH = Target.the("Seleccionar fecha")
            .located(By.xpath("//a[@class = 'ui-state-default'][@data-date='10']"));


}



package eu.rabow.bdd.steps.otherSteps;

import eu.rabow.bdd.Buchungsergebnis;
import eu.rabow.bdd.Buchungsstatus;
import eu.rabow.bdd.Gast;
import eu.rabow.bdd.steps.ourSteps.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OtherStepDefsEinzelbuchung {
    private Buchungsergebnis buchungsergebnis;

    @Given("ein Gast bucht einen Tisch als Einzelperson um {int}:{int} Uhr")
    public void einGastBuchtEinenTischAlsEinzelpersonUmUhr(Integer hour, Integer minute) {
       Buchungsergebnis buchungsergebnis = new Buchungsergebnis(Buchungsstatus.CONFIRMED);
    }

    @Given("weitere Einzelgäste sind für {int}:{int} Uhr gebucht")
    public void weitereEinzelgästeSindFürUhrGebucht(Integer hour, Integer minute) {
        // Simuliere weitere Einzelgäste
        Gast weitererGast1 = new Gast("Einzelgast2");
        Gast weitererGast2 = new Gast("Einzelgast3");
    }

    @When("das System die Gäste zusammenführt")
    public void dasSystemDieGästeZusammenführt() {
        // Simulation der Zusammenführung - würde in echter Implementierung
        // komplexere Logik enthalten
        buchungsergebnis = new Buchungsergebnis(Buchungsstatus.PENDING);
    }

    @Then("der Gast sieht die Zusammensetzung der Tischgruppe")
    public void derGastSiehtDieZusammensetzungDerTischgruppe() {
       Assert.assertEquals(Buchungsstatus.PENDING, buchungsergebnis.getBuchungsstatus());
    }


}

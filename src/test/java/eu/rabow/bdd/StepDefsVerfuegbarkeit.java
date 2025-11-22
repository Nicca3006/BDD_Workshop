package eu.rabow.bdd;

import io.cucumber.java.en.*;

public class StepDefsVerfuegbarkeit {
    @Given("Tisch {int} mit Kapazität {int} Personen")
    public void verfügbarerTischMitKapazitätPersonen(Integer int1, Integer int2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("der Gast bucht Tisch {int} für {int}:{int} Uhr")
    public void derGastBuchtTischFürUhr(Integer int1, Integer int2, Integer int3) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("die Buchung wird bestätigt")
    public void dieBuchungWirdBestätigt() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("der Gast erhält eine Bestätigung per E-Mail oder SMS")
    public void derGastErhältEineBestätigungPerEMailOderSMS() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("der Tisch ist für {int}:{int} Uhr reserviert und nicht verfügbar für andere")
    public void derTischIstFürUhrReserviertUndNichtVerfügbarFürAndere(Integer int1, Integer int2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("Tisch {int} ist von {int}:{int} bis {int}:{int} Uhr frei")
    public void tischIstVonBisUhrFrei(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verfügbare Tische werden angezeigt")
    public void verfügbareTischeWerdenAngezeigt() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("der Gast sucht verfügbare Tische für {int}:{int} Uhr")
    public void derGastSuchtVerfügbareTischeFürUhr(Integer int1, Integer int2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Tisch {int} wird nicht angezeigt")
    public void tischWirdNichtAngezeigt(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}

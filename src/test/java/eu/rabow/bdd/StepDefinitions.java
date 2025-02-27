package eu.rabow.bdd;

import io.cucumber.java.de.*;

public class StepDefinitions {

    Restaurant restaurant = new Restaurant();
    @Angenommen("alle Tische sind leer")
    public void alleTischeSindLeer() {
        restaurant.neuerTag();
    }
    Reservierung reservierung;
    @Wenn("eine Person reserviert einen Platz")
    public void einePersonReserviertEinenPlatz() {
        reservierung = restaurant.reserviere();
    }

    @Dann("die Person bekommt einen Platz an Tisch {int}")
    public void diePersonBekommtEinenPlatzAnTisch(Integer tischNummer) {
        assert reservierung.getTisch().getNummer() == tischNummer;
    }

    @Angenommen("ein Platz an einem bereits teilweise besetzten Tisch ist frei")
    public void einPlatzAnEinemBereitsTeilweiseBesetztenTischIstFrei() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Dann("die Person bekommt einen Platz an einem bereits teilweise besetzten Tisch")
    public void diePersonBekommtEinenPlatzAnEinemBereitsTeilweiseBesetztenTisch() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Gegebensei("kein Platz an einem bereits besetzten Tisch ist frei")
    public void keinPlatzAnEinemBereitsBesetztenTischIstFrei() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Gegebensei("ein Tisch ist leer")
    public void einTischIstLeer() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Dann("die Person bekommt einen Platz an dem neuen Tisch")
    public void diePersonBekommtEinenPlatzAnDemNeuenTisch() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Dann("eine Person von einem anderen Tisch wird an den neuen Tisch umgesetzt")
    public void einePersonVonEinemAnderenTischWirdAnDenNeuenTischUmgesetzt() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}

package eu.rabow.bdd;

import io.cucumber.java.en.*;
import static org.junit.Assert.*;
import java.time.LocalTime;

public class StepDefsBuchungskonflikt {
    private final TestContext testContext;

    public StepDefsBuchungskonflikt(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("Tisch {int} hat eine Kapazität von {int} Personen")
    public void tischHatEineKapazitätVonPersonen(Integer tischNummer, Integer kapazitaet) {
        testContext.getBuchungsservice().addTisch(new Tisch(tischNummer, kapazitaet));
    }

    @Given("Tisch {int} ist für {int}:{int} bis {int}:{int} Uhr komplett gebucht")
    public void tischIstFürBisUhrKomplettGebucht(Integer tischNummer, Integer startStunde, Integer startMinute, Integer endStunde, Integer endMinute) {
        LocalTime startzeit = LocalTime.of(startStunde, startMinute);
        LocalTime endzeit = LocalTime.of(endStunde, endMinute);
        Gast gast = new Gast("BereitsGebuchterGast");

        // Hole Kapazität des Tisches und buche komplett
        Tisch tisch = testContext.getBuchungsservice().tische.get(tischNummer);
        if (tisch != null) {
            Buchung buchung = new Buchung(gast, tischNummer, startzeit, endzeit, tisch.getKapazitaet());
            buchung.setStatus(Buchungsstatus.CONFIRMED);
            testContext.getBuchungsservice().addBuchung(buchung);
        }
    }

    @When("ein Gast eine Buchung für Tisch {int} um {int}:{int} Uhr für {int} Personen anfragt")
    public void einGastEineBuchungFürTischUmUhrFürPersonenAnfragt(Integer tischNummer, Integer stunde, Integer minute, Integer personen) {
        LocalTime startzeit = LocalTime.of(stunde, minute);
        LocalTime endzeit = startzeit.plusHours(2); // Standard 2h Buchung

        Buchungsergebnis buchungsergebnis = testContext.getBuchungsservice().tischBuchen(testContext.getAktuellerGast(), tischNummer, startzeit, endzeit, personen);
        testContext.setBuchungsergebnis(buchungsergebnis);
    }

    @Then("die Buchung wird abgelehnt")
    public void dieBuchungWirdAbgelehnt() {
        assertEquals(Buchungsstatus.REJECTED, testContext.getBuchungsergebnis().getBuchungsstatus());
    }

    @Then("der Gast erhält die Information, dass keine Kapazitäten verfügbar sind")
    public void derGastErhältDieInformationDassKeineKapazitätenVerfügbarSind() {
        assertTrue(testContext.getBuchungsergebnis().getNachricht().contains("Kapazitäten"));
    }

    @Given("Tisch {int} ist von {int}:{int} bis {int}:{int} Uhr für {int} Personen gebucht")
    public void tischIstVonBisUhrGebucht(Integer tischNummer, Integer startStunde, Integer startMinute, Integer endStunde, Integer endMinute, Integer personen) {
        LocalTime startzeit = LocalTime.of(startStunde, startMinute);
        LocalTime endzeit = LocalTime.of(endStunde, endMinute);
        Gast gast = new Gast("VorhandenerGast");

        Buchung buchung = new Buchung(gast, tischNummer, startzeit, endzeit, personen);
        buchung.setStatus(Buchungsstatus.CONFIRMED);
        testContext.getBuchungsservice().addBuchung(buchung);
    }

    @When("ein Gast eine Buchung für Tisch {int} von {int}:{int} bis {int}:{int} Uhr anfragt")
    public void einGastEineBuchungFürTischVonBisUhrAnfragt(Integer tischNummer, Integer startStunde, Integer startMinute, Integer endStunde, Integer endMinute) {
        LocalTime startzeit = LocalTime.of(startStunde, startMinute);
        LocalTime endzeit = LocalTime.of(endStunde, endMinute);

        Buchungsergebnis buchungsergebnis = testContext.getBuchungsservice().tischBuchen(testContext.getAktuellerGast(), tischNummer, startzeit, endzeit, 1);
        testContext.setBuchungsergebnis(buchungsergebnis);
    }

    @Then("der Gast wird über die Überschneidung informiert")
    public void derGastWirdÜberDieÜberschneidungInformiert() {
        assertTrue(testContext.getBuchungsergebnis().getNachricht().contains("Überschneidung"));
    }

    @When("ein Gast eine Buchung für Tisch {int} von {int}:{int} bis {int}:{int} Uhr für {int} Personen anfragt")
    public void einGastEineBuchungFürTischVonBisUhrFürPersonenAnfragt(Integer tischNummer, Integer startStunde, Integer startMinute, Integer endStunde, Integer endMinute, Integer personen) {
        LocalTime startzeit = LocalTime.of(startStunde, startMinute);
        LocalTime endzeit = LocalTime.of(endStunde, endMinute);

        Buchungsergebnis buchungsergebnis = testContext.getBuchungsservice().tischBuchen(testContext.getAktuellerGast(), tischNummer, startzeit, endzeit, personen);
        testContext.setBuchungsergebnis(buchungsergebnis);
    }

    @Then("die Kapazitäten sind für diese Uhrzeit reserviert")
    public void dieKapazitätenSindFürDieseUhrzeitReserviert() {
        assertEquals(Buchungsstatus.CONFIRMED, testContext.getBuchungsergebnis().getBuchungsstatus());
    }


}

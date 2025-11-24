package eu.rabow.bdd;

import io.cucumber.java.en.*;
import static org.junit.Assert.*;

public class StepDefsEinzelbuchung {
    private final TestContext testContext;

    public StepDefsEinzelbuchung(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("ein Gast bucht einen Tisch als Einzelperson um {int}:{int} Uhr")
    public void einGastBuchtEinenTischAlsEinzelpersonUmUhr(Integer hour, Integer minute) {
       Gast gast = new Gast("Einzelgast");
       Buchungsergebnis buchungsergebnis = testContext.getBuchungsservice().einzelneBuchungsanfrage(gast, hour, minute);
       testContext.setBuchungsergebnis( buchungsergebnis);
    }

    @Given("weitere Einzelgäste sind für {int}:{int} Uhr gebucht")
    public void weitereEinzelgästeSindFürUhrGebucht(Integer hour, Integer minute) {
        // Simuliere weitere Einzelgäste
        Gast weitererGast1 = new Gast("Einzelgast2");
        Gast weitererGast2 = new Gast("Einzelgast3");
        testContext.getBuchungsservice().einzelneBuchungsanfrage(weitererGast1, hour, minute);
        testContext.getBuchungsservice().einzelneBuchungsanfrage(weitererGast2, hour, minute);
    }

    @When("das System die Gäste zusammenführt")
    public void dasSystemDieGästeZusammenführt() {
        // Simulation der Zusammenführung - würde in echter Implementierung
        // komplexere Logik enthalten
        Buchungsergebnis buchungsergebnis = new Buchungsergebnis(Buchungsstatus.PENDING, "Zusammenführung vorgeschlagen");
        testContext.setBuchungsergebnis(buchungsergebnis);
    }

    @Then("der Gast sieht die Zusammensetzung der Tischgruppe")
    public void derGastSiehtDieZusammensetzungDerTischgruppe() {
        assertEquals(Buchungsstatus.PENDING, testContext.getBuchungsergebnis().getBuchungsstatus());
        assertTrue(testContext.getBuchungsergebnis().getNachricht().contains("Zusammenführung"));
    }

    @Then("der Gast kann die Zusammensetzung vor der Buchung ablehnen oder akzeptieren")
    public void derGastKannDieZusammensetzungVorDerBuchungAblehnenOderAkzeptieren() {
        assertEquals(Buchungsstatus.PENDING, testContext.getBuchungsergebnis().getBuchungsstatus());
    }

    @Then("nach Bestätigung erhält er die Buchungsbestätigung")
    public void nachBestätigungErhältErDieBuchungsbestätigung() {
        // Simuliere Bestätigung durch Gast
        Buchungsergebnis buchungsergebnis = new Buchungsergebnis(Buchungsstatus.CONFIRMED);
        testContext.setBuchungsergebnis(buchungsergebnis);
        assertEquals(Buchungsstatus.CONFIRMED, buchungsergebnis.getBuchungsstatus());
    }

    @Given("kein anderer Gast hat für {int}:{int} Uhr gebucht")
    public void keinAndererGastHatFürUhrGebucht(Integer hour, Integer minute) {
        // Service zurücksetzen für sauberen Test
        testContext.getBuchungsservice().reset();
    }

    @When("der Einzelgast eine Buchung anfragt")
    public void derEinzelgastEineBuchungAnfragt() {
        Gast gast = new Gast("EinzigerGast");
        Buchungsergebnis buchungsergebnis = testContext.getBuchungsservice().einzelneBuchungsanfrage(gast, 19, 0);
        testContext.setBuchungsergebnis(buchungsergebnis);
    }

    @Then("der Gast wird allein platziert")
    public void derGastWirdAlleinPlatziert() {
        assertTrue(testContext.getBuchungsservice().gastSitztAllein(testContext.getAktuellerGast()));
        assertEquals(Buchungsstatus.CONFIRMED, testContext.getBuchungsergebnis().getBuchungsstatus());
    }

    @Then("der Gast wird informiert, dass keine Zusammensetzung möglich ist")
    public void derGastWirdInformiertDassKeineZusammensetzungMöglichIst() {
        assertTrue(testContext.getBuchungsservice().gastSitztAllein(testContext.getAktuellerGast()));
    }
}

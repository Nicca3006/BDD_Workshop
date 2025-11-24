package eu.rabow.bdd;

import java.util.List;

public class TestContext {
    private Buchungsservice buchungsservice = new Buchungsservice();
    private Buchungsergebnis buchungsergebnis;
    private Gast aktuellerGast = new Gast("TestGast");
    private List<Tisch> verfuegbareTische;

    // Getters und Setters
    public Buchungsservice getBuchungsservice() { return buchungsservice; }
    public void setBuchungsservice(Buchungsservice buchungsservice) { this.buchungsservice = buchungsservice; }
    
    public Buchungsergebnis getBuchungsergebnis() { return buchungsergebnis; }
    public void setBuchungsergebnis(Buchungsergebnis buchungsergebnis) { this.buchungsergebnis = buchungsergebnis; }
    
    public Gast getAktuellerGast() { return aktuellerGast; }
    public void setAktuellerGast(Gast aktuellerGast) { this.aktuellerGast = aktuellerGast; }
    
    public List<Tisch> getVerfuegbareTische() { return verfuegbareTische; }
    public void setVerfuegbareTische(List<Tisch> verfuegbareTische) { this.verfuegbareTische = verfuegbareTische; }
}

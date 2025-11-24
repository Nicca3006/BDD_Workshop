package eu.rabow.bdd;

public class Buchungsergebnis {
    private Buchungsstatus buchungsstatus;
    private String nachricht;

    public Buchungsergebnis(Buchungsstatus buchungsstatus) {
        this.buchungsstatus = buchungsstatus;    }

    public Buchungsergebnis(Buchungsstatus buchungsstatus, String nachricht) {
        this.buchungsstatus = buchungsstatus;
        this.nachricht = nachricht;
    }

    public Buchungsstatus getBuchungsstatus() {
        return buchungsstatus;
    }

    public String getNachricht() {
        return nachricht;
    }
}

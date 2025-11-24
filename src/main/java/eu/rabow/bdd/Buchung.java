
package eu.rabow.bdd;

import java.time.LocalTime;

public class Buchung {
    private Gast gast;
    private int tischNummer;
    private LocalTime startzeit;
    private LocalTime endzeit;
    private int anzahlPersonen;
    private Buchungsstatus status;

    public Buchung(Gast gast, int tischNummer, LocalTime startzeit, LocalTime endzeit, int anzahlPersonen) {
        this.gast = gast;
        this.tischNummer = tischNummer;
        this.startzeit = startzeit;
        this.endzeit = endzeit;
        this.anzahlPersonen = anzahlPersonen;
        this.status = Buchungsstatus.PENDING;
    }

    public Gast getGast() {
        return gast;
    }

    public int getTischNummer() {
        return tischNummer;
    }

    public LocalTime getStartzeit() {
        return startzeit;
    }

    public LocalTime getEndzeit() {
        return endzeit;
    }

    public int getAnzahlPersonen() {
        return anzahlPersonen;
    }

    public Buchungsstatus getStatus() {
        return status;
    }

    public void setStatus(Buchungsstatus status) {
        this.status = status;
    }
}

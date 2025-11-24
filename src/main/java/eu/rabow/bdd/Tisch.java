package eu.rabow.bdd;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Tisch {
    private int tischNummer;
    private int kapazitaet;
    private List<Buchung> buchungen = new ArrayList<>();

    public Tisch(int tischNummer, int kapazitaet) {
        this.tischNummer = tischNummer;
        this.kapazitaet = kapazitaet;
    }

    public int getTischNummer() {
        return tischNummer;
    }

    public int getKapazitaet() {
        return kapazitaet;
    }

    public List<Buchung> getBuchungen() {
        return buchungen;
    }

    public void addBuchung(Buchung buchung) {
        buchungen.add(buchung);
    }

    public boolean istVerfuegbar(LocalTime startzeit, LocalTime endzeit) {
        return buchungen.stream().noneMatch(b -> 
            zeitenUeberschneiden(b.getStartzeit(), b.getEndzeit(), startzeit, endzeit));
    }

    private boolean zeitenUeberschneiden(LocalTime start1, LocalTime end1, LocalTime start2, LocalTime end2) {
        return start1.isBefore(end2) && end1.isAfter(start2);
    }

    public boolean istKapazitaetVerfuegbar(LocalTime startzeit, LocalTime endzeit, int benoetigtePersonen) {
        int belegteKapazitaet = buchungen.stream()
            .filter(b -> zeitenUeberschneiden(b.getStartzeit(), b.getEndzeit(), startzeit, endzeit))
            .mapToInt(Buchung::getAnzahlPersonen)
            .sum();
        
        return (belegteKapazitaet + benoetigtePersonen) <= kapazitaet;
    }

    public boolean istKomplettGebucht(LocalTime startzeit, LocalTime endzeit) {
        int belegteKapazitaet = buchungen.stream()
            .filter(b -> zeitenUeberschneiden(b.getStartzeit(), b.getEndzeit(), startzeit, endzeit))
            .mapToInt(Buchung::getAnzahlPersonen)
            .sum();
        
        return belegteKapazitaet >= kapazitaet;
    }
}

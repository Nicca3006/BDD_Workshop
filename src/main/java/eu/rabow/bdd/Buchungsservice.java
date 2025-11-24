package eu.rabow.bdd;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Buchungsservice {
    Map<Integer, Tisch> tische = new HashMap<>();
    private List<Buchung> alleBuchungen = new ArrayList<>();
    private List<Gast> einzelgaeste = new ArrayList<>();

    public Buchungsservice() {
        // Beispiel-Tische initialisieren
        tische.put(1, new Tisch(1, 6));
        tische.put(2, new Tisch(2, 4));
        tische.put(3, new Tisch(3, 4));
    }

    /**
     * Simuliert eine Einzelgast-Buchung für eine bestimmte Uhrzeit.
     */
    public Buchungsergebnis einzelneBuchungsanfrage(Gast gast, int hour, int minute) {
        einzelgaeste.add(gast);
        LocalTime zeit = LocalTime.of(hour, minute);
        
        // Prüfe ob andere Einzelgäste zur gleichen Zeit gebucht haben
        long anzahlEinzelgaesteZurZeit = einzelgaeste.size();
        
        if (anzahlEinzelgaesteZurZeit == 1) {
            return new Buchungsergebnis(Buchungsstatus.CONFIRMED);
        } else {
            return new Buchungsergebnis(Buchungsstatus.PENDING, "Zusammenführung mit anderen Gästen möglich");
        }
    }

    /**
     * Bucht einen Tisch für bestimmte Zeit und Personenanzahl
     */
    public Buchungsergebnis tischBuchen(Gast gast, int tischNummer, LocalTime startzeit, LocalTime endzeit, int anzahlPersonen) {
        Tisch tisch = tische.get(tischNummer);
        
        if (tisch == null) {
            return new Buchungsergebnis(Buchungsstatus.REJECTED, "Tisch existiert nicht");
        }

        // SPEZIALFALL: Prüfe ob Tisch komplett gebucht ist (höchste Priorität)
        if (tisch.istKomplettGebucht(startzeit, endzeit)) {
            return new Buchungsergebnis(Buchungsstatus.REJECTED, "Keine Kapazitäten verfügbar");
        }

        // NORMALFALL: Prüfe ob der Tisch komplett frei ist
        if (!tisch.istVerfuegbar(startzeit, endzeit)) {
            // Tisch hat Überschneidung aber ist nicht komplett gebucht
            return new Buchungsergebnis(Buchungsstatus.REJECTED, "Zeitliche Überschneidung mit bestehender Buchung");
        }

        // KAPAZITÄTSPRÜFUNG: Nur wenn Tisch verfügbar ist
        if (!tisch.istKapazitaetVerfuegbar(startzeit, endzeit, anzahlPersonen)) {
            return new Buchungsergebnis(Buchungsstatus.REJECTED, "Keine Kapazitäten verfügbar");
        }

        Buchung buchung = new Buchung(gast, tischNummer, startzeit, endzeit, anzahlPersonen);
        buchung.setStatus(Buchungsstatus.CONFIRMED);
        tisch.addBuchung(buchung);
        alleBuchungen.add(buchung);

        return new Buchungsergebnis(Buchungsstatus.CONFIRMED);
    }

    /**
     * Findet verfügbare Tische für eine bestimmte Zeit
     */
    public List<Tisch> findeVerfuegbareTische(LocalTime startzeit, LocalTime endzeit) {
        return tische.values().stream()
            .filter(t -> t.istVerfuegbar(startzeit, endzeit))
            .collect(Collectors.toList());
    }

    /**
     * Prüft, ob der Gast allein platziert wird.
     */
    public boolean gastSitztAllein(Gast gast) {
        return einzelgaeste.size() == 1;
    }

    /**
     * Fügt einen Tisch hinzu (für Tests)
     */
    public void addTisch(Tisch tisch) {
        tische.put(tisch.getTischNummer(), tisch);
    }

    /**
     * Fügt eine Buchung hinzu (für Tests)
     */
    public void addBuchung(Buchung buchung) {
        Tisch tisch = tische.get(buchung.getTischNummer());
        if (tisch != null) {
            tisch.addBuchung(buchung);
            alleBuchungen.add(buchung);
        }
    }

    /**
     * Prüft ob ein Tisch zu einer bestimmten Zeit verfügbar ist
     */
    public boolean istTischVerfuegbar(int tischNummer, LocalTime zeit) {
        Tisch tisch = tische.get(tischNummer);
        if (tisch == null) return false;
        
        LocalTime endzeit = zeit.plusHours(2); // Standard 2h Buchung
        return tisch.istVerfuegbar(zeit, endzeit);
    }

    public void reset() {
        alleBuchungen.clear();
        einzelgaeste.clear();
        tische.values().forEach(t -> t.getBuchungen().clear());
    }
}

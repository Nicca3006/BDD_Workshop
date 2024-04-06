package eu.rabow.bdd;

import java.util.Optional;

public class Tisch {
    private final int nummer;
    private int freiePlaetze = 4;

    private Optional<TischFreiePlaetzeListener> listener = Optional.empty();

    public Tisch(int nummer) {
        this.nummer = nummer;
    }

    public int getNummer() {
        return nummer;
    }

    public int getFreiePlaetze() {
        return freiePlaetze;
    }

    public boolean hatFreienPlatz() {
        return freiePlaetze > 0;
    }

    public void reserviere() {
        freiePlaetze--;
        listener.ifPresent(TischFreiePlaetzeListener::freiePlaetzeGeaendert);
    }

    public String toString() {
        return "Tisch " + nummer + " hat " + freiePlaetze + " freie Plätze";
    }

    public void setListener(TischFreiePlaetzeListener tischViewModel) {
        this.listener = Optional.of(tischViewModel);
    }
}

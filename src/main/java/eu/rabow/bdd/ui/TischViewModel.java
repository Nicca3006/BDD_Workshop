package eu.rabow.bdd.ui;

import eu.rabow.bdd.Tisch;
import eu.rabow.bdd.TischFreiePlaetzeListener;
import javafx.beans.property.SimpleIntegerProperty;

public class TischViewModel implements TischFreiePlaetzeListener {
    private Tisch tisch;
    private SimpleIntegerProperty freiePlaetze;

    public TischViewModel(Tisch tisch) {
        this.tisch = tisch;
        this.freiePlaetze = new SimpleIntegerProperty(tisch.getFreiePlaetze());
        tisch.setListener(this);
    }

    public SimpleIntegerProperty freiePlaetzeProperty() {
        return freiePlaetze;
    }

    public int getNummer() {
        return tisch.getNummer();
    }

    @Override
    public void freiePlaetzeGeaendert() {
        freiePlaetze.set(tisch.getFreiePlaetze());
    }
}
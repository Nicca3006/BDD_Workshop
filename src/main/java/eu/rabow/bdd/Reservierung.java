package eu.rabow.bdd;

public class Reservierung {
    private Tisch tisch;

    public Reservierung(Tisch tisch) {
        this.tisch = tisch;
    }

    public Tisch getTisch() {
        return tisch;
    }
}

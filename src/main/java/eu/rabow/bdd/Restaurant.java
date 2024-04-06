package eu.rabow.bdd;
public class Restaurant {

    private Tisch[] tische;

    public Restaurant() {
        this(10);
    }

    public Restaurant(final int anzahlTische) {
        tische = new Tisch[anzahlTische];
        neuerTag();
    }

    public void neuerTag() {
        for (int i = 0; i < tische.length; i++) {
            tische[i] = new Tisch(i + 1);
        }
    }

    public Reservierung reserviere() {
        Tisch tischMitPlatz = sucheTischMitPlatz();
        if (tischMitPlatz != null) {
            tischMitPlatz.reserviere();
            return new Reservierung(tischMitPlatz);
        }

        return null;
    }

    private Tisch sucheTischMitPlatz() {
        for (Tisch tisch : tische) {
            if (tisch.hatFreienPlatz()) {
                return tisch;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        restaurant.neuerTag();
        Reservierung reservierung = restaurant.reserviere();
        System.out.println("Erste Reservierung war an " + reservierung.getTisch());
        for (Tisch tisch : restaurant.tische) {
            System.out.println(tisch);
        }
    }

    public Tisch[] getTische() {
        return tische;
    }
}
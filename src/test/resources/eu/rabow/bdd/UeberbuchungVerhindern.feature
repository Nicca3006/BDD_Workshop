Feature: Vermeidung von Überbuchungen
  Als Restaurantbetreiber möchte ich sicherstellen, dass Tische nicht überbucht werden,
  damit ich keine Gäste wegschicken muss.

  Scenario: Buchung wird abgelehnt bei unzureichender Kapazität
    Given Tisch 1 hat eine Kapazität von 4 Personen
    And Tisch 1 ist für 19:00 bis 21:00 Uhr komplett gebucht
    When ein Gast eine Buchung für Tisch 1 um 19:30 Uhr für 2 Personen anfragt
    Then die Buchung wird abgelehnt
    And der Gast erhält die Information, dass keine Kapazitäten verfügbar sind

  Scenario: Buchung wird akzeptiert bei freier Kapazität und Zeitfenster
    Given Tisch 3 hat eine Kapazität von 6 Personen
    And Tisch 3 ist von 20:00 bis 22:00 Uhr frei
    When ein Gast eine Buchung für Tisch 3 von 19:00 bis 20:00 Uhr anfragt
    Then die Buchung wird bestätigt
    And die Kapazitäten sind für diese Uhrzeit reserviert

  Scenario: Buchung wird abgelehnt bei zeitlicher Überschneidung
    Given Tisch 2 ist von 18:00 bis 20:00 Uhr für 2 Personen gebucht
    When ein Gast eine Buchung für Tisch 2 von 19:30 bis 21:00 Uhr anfragt
    Then die Buchung wird abgelehnt
    And der Gast wird über die Überschneidung informiert

  Scenario Outline: Buchung wird wegen Zeitüberschneidung abgelehnt
    Given Tisch <Tischnummer> ist von <Startzeit_gebucht> bis <Endzeit_gebucht> Uhr für <Personen_gebucht> Personen gebucht
    When ein Gast eine Buchung für Tisch <Tischnummer> von <Startzeit_neu> bis <Endzeit_neu> Uhr für <Personen_neu> Personen anfragt
    Then die Buchung wird abgelehnt
    And der Gast wird über die Überschneidung informiert

    Examples:
      | Tischnummer | Startzeit_gebucht | Endzeit_gebucht | Personen_gebucht | Startzeit_neu | Endzeit_neu | Personen_neu |
      | 1           | 18:00             | 20:00           | 4                | 19:00         | 21:00       | 2            |
      | 2           | 19:30             | 21:00           | 2                | 20:30         | 22:00       | 3            |
      | 3           | 17:00             | 19:00           | 3                | 18:30         | 20:30       | 1            |

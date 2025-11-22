Feature: Tischbuchung zu einer bestimmten Uhrzeit
  Als Gast möchte ich einen Tisch für eine bestimmte Uhrzeit buchen,
  damit ich sicherstellen kann, dass mir ein Platz reserviert wird.

  Scenario: Buchung eines verfügbaren Tisches zu Wunschzeit
    Given verfügbarer Tisch 3 mit Kapazität 4 Personen
    When der Gast bucht Tisch 3 für 19:00 Uhr
    Then die Buchung wird bestätigt
    And der Gast erhält eine Bestätigung per E-Mail oder SMS
    And der Tisch ist für 19:00 Uhr reserviert und nicht verfügbar für andere

  Scenario: Anzeige nur verfügbarer Tische bei Buchungssuche
    Given Tisch 1 ist von 18:00 bis 20:00 Uhr gebucht
    When der Gast sucht verfügbare Tische für 19:00 Uhr
    Then Tisch 1 wird nicht angezeigt
    And verfügbare Tische werden angezeigt

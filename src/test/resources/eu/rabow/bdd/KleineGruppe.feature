Feature: Zusammenlegung von kleinen Gruppen zu größeren Tischrunden
  Als Gast einer kleinen Gruppe möchte ich mit anderen Gruppen zusammengelegt werden,
  damit ich neue Leute kennenlernen kann.

  Scenario: Offenheit für Zusammenlegung bei Buchung
    Given eine Gruppe von 3 Personen und eine Gruppe von 2 Personen buchen um 20:00 Uhr
    And beide Gruppen sind offen für eine Zusammenlegung
    When das System Gruppen zusammenlegt
    Then wird den Gästen die neue Tischkonstellation angezeigt
    And die Gäste bestätigen die Zusammenlegung
    And die Buchung wird bestätigt

  Scenario: Ablehnung der Zusammenlegung durch eine Gruppe
    Given zwei Gruppen sind für 20:00 Uhr gebucht
    And eine Gruppe lehnt die Zusammenlegung ab
    When das System die Zusammenlegung vorschlägt
    Then wird die Zusammenlegung für diese Gruppe nicht durchgeführt
    And beide Gruppen werden getrennt platziert

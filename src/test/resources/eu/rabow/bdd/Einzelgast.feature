Feature: Einzelgast Buchung mit gemeinsamer Tischplatzierung
  Als Einzelgast möchte ich einen Tisch buchen und automatisch mit anderen Gästen zusammengesetzt werden,
  damit ich nicht alleine essen muss.

  Scenario: Einzelgast bucht Tisch und wird zusammengesetzt
    Given ein Gast bucht einen Tisch als Einzelperson um 19:00 Uhr
    And weitere Einzelgäste sind für 19:00 Uhr gebucht
    When das System die Gäste zusammenführt
    Then der Gast sieht die Zusammensetzung der Tischgruppe
    And der Gast kann die Zusammensetzung vor der Buchung ablehnen oder akzeptieren
    And nach Bestätigung erhält er die Buchungsbestätigung

  Scenario: Keine Zusammensetzung möglich bei Einzelgastbuchung
    Given kein anderer Gast hat für 19:00 Uhr gebucht
    When der Einzelgast eine Buchung anfragt
    Then der Gast wird allein platziert
    And der Gast wird informiert, dass keine Zusammensetzung möglich ist

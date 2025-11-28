@other
Feature: Dieses Feature ist lediglich ein Beispiel dafür, dass wir das gleiche Scenario (oder einzelne Schritte daraus) unterschiedlich implementieren können.
  Dafür bräuchten wir nicht einmal das "OtherFeature", wir können auch das gleiche Feature File unterschiedlich implementieren.
  In der Realität passiert es eher umgekehrt und wir erstellen gleiche Steps mit einer anderen Intention.
  Über die Differenzierung im Glue-Code können wir damit umgehen.
  Selbstverständlich sollten wir uns sehr klar darüber sein, wieso die gleichen Steps unterschiedlich gehandelt werden.

  Scenario: Einzelgast bucht Tisch und wird zusammengesetzt
    Given ein Gast bucht einen Tisch als Einzelperson um 19:00 Uhr
    And weitere Einzelgäste sind für 19:00 Uhr gebucht
    When das System die Gäste zusammenführt
    Then der Gast sieht die Zusammensetzung der Tischgruppe



@other
Feature: Exempel, wieso wir bei TDD immer darauf achten sollten, dass der Test zu Beginn rot ist
  Scenario: Steps sind nicht definiert und werfen keine Exception
    Given ein Step wird definiert
    And ist leer
    When der Test ausgeführt wird
    Then ist er grün
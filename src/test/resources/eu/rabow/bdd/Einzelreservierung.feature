#language:de
  @MVP
  Funktionalität: Eine einzelne Person reserviert einen Platz
    Jede Person soll mit mindestens einer anderen Person an einem Tisch sitzen.
    Als Einzelperson möchte ich einen Platz an einem Tisch mit anderen Personen reservieren können, damit ich nicht alleine essen muss.
  @done
  Szenario: Erste Reservierung des Tages
    Angenommen alle Tische sind leer
    Wenn eine Person reserviert einen Platz
    Dann die Person bekommt einen Platz an Tisch 1
  @ready
  Szenario: Weitere Reservierung an einem teiweise besetzten Tisch
    Angenommen ein Platz an einem bereits teilweise besetzten Tisch ist frei
    Wenn eine Person reserviert einen Platz
    Dann die Person bekommt einen Platz an einem bereits teilweise besetzten Tisch
  @ready
  Szenario: Weitere Reservierung an einem leeren Tisch
    Gegeben sei kein Platz an einem bereits besetzten Tisch ist frei
    Und ein Tisch ist leer
    Wenn eine Person reserviert einen Platz
    Dann die Person bekommt einen Platz an dem neuen Tisch
    Und eine Person von einem anderen Tisch wird an den neuen Tisch umgesetzt
public class Mitarbeiter extends Person {
  private int MID;
  private int versicherungsnummer;

  public Mitarbeiter(String nachname, String vorname, String anrede,
      String geburtstag, String wohnort, String PLZ, String strasse, String hausnummer, int MID, int versicherungsnummer) {
    super(nachname, vorname, anrede, geburtstag, wohnort, PLZ, strasse, hausnummer);
    this.MID = MID;
    this.versicherungsnummer = versicherungsnummer;
  }

  public int getMID() {
    return MID;
  }

  public void setMID(int MID) {
    this.MID = MID;
  }

  public int getVersicherungsnummer() {
    return versicherungsnummer;
  }

  public void setVersicherungsnummer(int versicherungsnummer) {
    this.versicherungsnummer = versicherungsnummer;
  }
}

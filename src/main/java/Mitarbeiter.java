public class Mitarbeiter extends Person {
  private int MID;
  private int versicherungsnummer;
  private String password;

  public Mitarbeiter(String nachname, String vorname, String anrede,
      String geburtstag, String wohnort, String PLZ, String strasse, String hausnummer, int MID, int versicherungsnummer, String password) {
    super(nachname, vorname, anrede, geburtstag, wohnort, PLZ, strasse, hausnummer);
    this.MID = MID;
    this.versicherungsnummer = versicherungsnummer;
    this.password = password;
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

  public boolean isPassword(String pw){
    if (pw.equals(this.password)) return true;
    return false;
  }
}

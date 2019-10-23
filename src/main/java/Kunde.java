public class Kunde extends Person {
  private int KID;
  private Verleihliste persVerleihiste;

  public Kunde( String nachname, String vorname, String anrede, String geburtstag,
      String wohnort, String PLZ, String strasse, String hausnummer, int KID,
      Verleihliste persVerleihiste) {
    super(nachname, vorname, anrede, geburtstag, wohnort, PLZ, strasse, hausnummer);
    this.KID = KID;
    this.persVerleihiste = persVerleihiste;
  }

  public int getKID() {
    return KID;
  }

  public void setKID(int KID) {
    this.KID = KID;
  }

  public Verleihliste getPersVerleihiste() {
    return persVerleihiste;
  }

  public void setPersVerleihiste(Verleihliste persVerleihiste) {
    this.persVerleihiste = persVerleihiste;
  }
}

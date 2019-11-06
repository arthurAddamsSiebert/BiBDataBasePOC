public class Leihe {
  private int LID;
  private String Zeitstempel;
  private int Zeitspanne;
  private double ueberziehungsPreis;
  private Mitarbeiter mitarbeiter;
  private Buch buch;


  //ISBN zu Buch ändern
  public Leihe(int LID, String zeitstempel, int zeitspanne, double ueberziehungsPreis,
      Mitarbeiter mitarbeiter, Buch buch) {
    this.LID = LID;
    this.Zeitstempel = zeitstempel;
    this.Zeitspanne = zeitspanne;
    this.ueberziehungsPreis = ueberziehungsPreis;
    this.mitarbeiter = mitarbeiter;
    this.buch = buch;
  }

  public Buch getBuch() {
    return buch;
  }

  public void setBuch(Buch buch) {
    this.buch = buch;
  }

  public int getLID() {
    return LID;
  }

  public void setLID(int LID) {
    this.LID = LID;
  }

  public String getZeitstempel() {
    return Zeitstempel;
  }

  public void setZeitstempel(String zeitstempel) {
    Zeitstempel = zeitstempel;
  }

  public int getZeitspanne() {
    return Zeitspanne;
  }

  public void setZeitspanne(int zeitspanne) {
    Zeitspanne = zeitspanne;
  }

  public double getUeberziehungsPreis() {
    return ueberziehungsPreis;
  }

  public void setUeberziehungsPreis(double ueberziehungsPreis) {
    this.ueberziehungsPreis = ueberziehungsPreis;
  }

  public Mitarbeiter getMitarbeiter() {
    return mitarbeiter;
  }

  public void setMitarbeiter(Mitarbeiter mitarbeiter) {
    this.mitarbeiter = mitarbeiter;
  }
}

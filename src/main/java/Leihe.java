public class Leihe {
  private int LID;
  private String Zeitstempel;
  private int Zeitspanne;
  private double ueberziehungsPreis;
  private Mitarbeiter mitarbeiter;

  public Leihe(int LID, String zeitstempel, int zeitspanne, double ueberziehungsPreis,
      Mitarbeiter mitarbeiter) {
    this.LID = LID;
    this.Zeitstempel = zeitstempel;
    this.Zeitspanne = zeitspanne;
    this.ueberziehungsPreis = ueberziehungsPreis;
    this.mitarbeiter = mitarbeiter;
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

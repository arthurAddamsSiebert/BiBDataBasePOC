import java.util.ArrayList;

public class Verleihliste {
  private int VID;
  private Kunde kunde;
  private ArrayList<Leihe> liste = new ArrayList<Leihe>();

  public Verleihliste(int VID, ArrayList<Leihe> liste) {
    this.VID = VID;
    this.liste = liste;
  }

  public int getVID() {
    return VID;
  }

  public void setVID(int VID) {
    this.VID = VID;
  }

  public Kunde getKunde() {
    return kunde;
  }

  public void setKunde(Kunde kunde) {
    this.kunde = kunde;
  }

  public ArrayList<Leihe> getListe() {
    return liste;
  }

  public void setListe(ArrayList<Leihe> liste) {
    this.liste = liste;
  }
}

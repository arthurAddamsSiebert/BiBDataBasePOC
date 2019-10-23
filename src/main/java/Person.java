public abstract class Person {
  private String nachname;
  private String vorname;
  private String anrede;
  private String geburtstag;
  private String wohnort;
  private String PLZ;
  private String Strasse;
  private String Hausnummer;

  public Person(String nachname, String vorname, String anrede, String geburtstag,
      String wohnort, String PLZ, String strasse, String hausnummer) {
    this.nachname = nachname;
    this.vorname = vorname;
    this.anrede = anrede;
    this.geburtstag = geburtstag;
    this.wohnort = wohnort;
    this.PLZ = PLZ;
    Strasse = strasse;
    Hausnummer = hausnummer;
  }

  public String getNachname() {
    return nachname;
  }

  public void setNachname(String nachname) {
    this.nachname = nachname;
  }

  public String getVorname() {
    return vorname;
  }

  public void setVorname(String vorname) {
    this.vorname = vorname;
  }

  public String getAnrede() {
    return anrede;
  }

  public void setAnrede(String anrede) {
    this.anrede = anrede;
  }

  public String getGeburtstag() {
    return geburtstag;
  }

  public void setGeburtstag(String geburtstag) {
    this.geburtstag = geburtstag;
  }

  public String getWohnort() {
    return wohnort;
  }

  public void setWohnort(String wohnort) {
    this.wohnort = wohnort;
  }

  public String getPLZ() {
    return PLZ;
  }

  public void setPLZ(String PLZ) {
    this.PLZ = PLZ;
  }

  public String getStrasse() {
    return Strasse;
  }

  public void setStrasse(String strasse) {
    Strasse = strasse;
  }

  public String getHausnummer() {
    return Hausnummer;
  }

  public void setHausnummer(String hausnummer) {
    Hausnummer = hausnummer;
  }
}

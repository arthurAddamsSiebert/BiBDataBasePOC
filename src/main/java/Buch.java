import java.util.ArrayList;

public class Buch {
  private String isbn;
  private int exemplarNummer;
  private ArrayList<String> autoren = new ArrayList<String>();
  private int year;
  private String title;
  private double price;
  private String address;
  private String series;
  private String doi;
  private String aAbstract;
  private String publisher;
  private ArrayList<String> genre = new ArrayList<String>();
  private int Regal;
  private int Zeile;
  private int Stelle;

  public Buch(String isbn, int exemplarNummer, ArrayList<String> autoren, int year,
      String title, double price, String address, String series, String doi,
      String aAbstract, String publisher, ArrayList<String> genre, int regal, int zeile,
      int stelle) {
    this.isbn = isbn;
    this.exemplarNummer = exemplarNummer;
    this.autoren = autoren;
    this.year = year;
    this.title = title;
    this.price = price;
    this.address = address;
    this.series = series;
    this.doi = doi;
    this.aAbstract = aAbstract;
    this.publisher = publisher;
    this.genre = genre;
    Regal = regal;
    Zeile = zeile;
    Stelle = stelle;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public int getExemplarNummer() {
    return exemplarNummer;
  }

  public void setExemplarNummer(int exemplarNummer) {
    this.exemplarNummer = exemplarNummer;
  }

  public ArrayList<String> getAutoren() {
    return autoren;
  }

  public void setAutoren(ArrayList<String> autoren) {
    this.autoren = autoren;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getAdress() {
    return address;
  }

  public void setAdress(String address) {
    this.address = address;
  }

  public String getSeries() {
    return series;
  }

  public void setSeries(String series) {
    this.series = series;
  }

  public String getDoi() {
    return doi;
  }

  public void setDoi(String doi) {
    this.doi = doi;
  }

  public String getaAbstract() {
    return aAbstract;
  }

  public void setaAbstract(String aAbstract) {
    this.aAbstract = aAbstract;
  }

  public String getPublischer() {
    return publisher;
  }

  public void setPublischer(String publisher) {
    this.publisher = publisher;
  }

  public ArrayList<String> getGenre() {
    return genre;
  }

  public void setGenre(ArrayList<String> genre) {
    this.genre = genre;
  }

  public int getRegal() {
    return Regal;
  }

  public void setRegal(int regal) {
    Regal = regal;
  }

  public int getZeile() {
    return Zeile;
  }

  public void setZeile(int zeile) {
    Zeile = zeile;
  }

  public int getStelle() {
    return Stelle;
  }

  public void setStelle(int stelle) {
    Stelle = stelle;
  }
}

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.Date;
//import jdk.swing.interop.SwingInterOpUtils;


public class DatabaseHandler {
  private Firestore db;
  private static DatabaseHandler handler = new DatabaseHandler();

  public static void main(String[] args)
      throws IOException, ExecutionException, InterruptedException {
    handler.connectToDatabase();
  }


  public void connectToDatabase() throws IOException {
    InputStream serviceAccount = new FileInputStream("C:\\Users\\A703967\\Desktop\\DHBW\\Semester 3\\DB+\\DBplus private key\\dbplus-6b6d0-firebase-adminsdk-pjqw4-c98218d98b.json");
    GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
    FirebaseOptions options = new FirebaseOptions.Builder()
        .setCredentials(credentials)
        .build();
    FirebaseApp.initializeApp(options);
    db = FirestoreClient.getFirestore();
  }

  public void writeBook(Buch buch) throws ExecutionException, InterruptedException {
    DocumentReference docRef = db.collection("books").document(buch.getIsbn()+"-"+buch.getExemplarNummer());
    Map<String, Object> data = new HashMap<>();
    data.put("isbn",buch.getIsbn());
    data.put("exemplarNummer",buch.getExemplarNummer());
    data.put("autoren",buch.getAutoren());
    data.put("year",buch.getYear());
    data.put("title",buch.getTitle());
    data.put("price",buch.getPrice());
    data.put("adress",buch.getAdress());
    data.put("series",buch.getSeries());
    data.put("doi",buch.getDoi());
    data.put("aAbstract",buch.getaAbstract());
    data.put("publisher",buch.getPublischer());
    data.put("genre",buch.getGenre());
    data.put("regal",buch.getRegal());
    data.put("zeile",buch.getZeile());
    data.put("stelle",buch.getStelle());

    ApiFuture<WriteResult> result = docRef.set(data);
    System.out.println("Update time : " + result.get().getUpdateTime());
  }

  public ArrayList<Buch> getBuecher() throws ExecutionException, InterruptedException {
    ApiFuture<QuerySnapshot> query = db.collection("books").get();
    QuerySnapshot querySnapshot = query.get();
    List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
    ArrayList<Buch> result = new ArrayList<Buch>();
    for (QueryDocumentSnapshot document : documents){
      String isbn = document.getString("isbn");
      long exemplarNummer = document.getLong("exemplarNummer");
      ArrayList<String> autoren = new ArrayList<String>();
      long year= document.getLong("year");
      String title= document.getString("title");
      double price= document.getDouble("price");
      String address= document.getString("adress");
      String series= document.getString("series");
      String doi= document.getString("doi");
      String aAbstract= document.getString("aAbstract");
      String publisher= document.getString("publisher");
      ArrayList<String> genre = new ArrayList<String>();
      long regal= document.getLong("regal");
      long zeile= document.getLong("zeile");
      long stelle= document.getLong("stelle");
      result.add(new Buch(isbn,(int)exemplarNummer,autoren,(int)year,title,price,address,series,doi,aAbstract,publisher,genre,(int)regal,(int)zeile,(int)stelle));
    }
    for (int i = 0;i<result.size();i++){
      System.out.println(result.get(i).getIsbn());
      System.out.println("____");
    }
    return result;

  }
  public Buch getBuchByID(String isbnEx) throws ExecutionException, InterruptedException {
    ApiFuture<QuerySnapshot> query = db.collection("books").get();
    QuerySnapshot querySnapshot = query.get();
    List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
    for (QueryDocumentSnapshot document : documents){
      if (document.getId().equals(isbnEx)){
        String isbn = document.getString("isbn");
        long exemplarNummer = document.getLong("exemplarNummer");
        ArrayList<String> autoren = new ArrayList<String>();
        long year= document.getLong("year");
        String title= document.getString("title");
        double price= document.getDouble("price");
        String address= document.getString("adress");
        String series= document.getString("series");
        String doi= document.getString("doi");
        String aAbstract= document.getString("aAbstract");
        String publisher= document.getString("publisher");
        ArrayList<String> genre = new ArrayList<String>();
        long regal= document.getLong("regal");
        long zeile= document.getLong("zeile");
        long stelle= document.getLong("stelle");
        return new Buch(isbn,(int)exemplarNummer,autoren,(int)year,title,price,address,series,doi,aAbstract,publisher,genre,(int)regal,(int)zeile,(int)stelle);
      }
    }
    return null;
  }

  public void buchConverter() throws ExecutionException, InterruptedException {
    int regal = 1;
    int zeile = 1;
    int stelle = 1;
    ApiFuture<QuerySnapshot> query = db.collection("books").get();
    QuerySnapshot querySnapshot = query.get();
    DatabaseHandler handler = new DatabaseHandler();
    List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
    ArrayList<Buch> buecherVorher = new ArrayList<Buch>();
    for (QueryDocumentSnapshot document : documents){
      String isbn = document.getString("isbn");
      long exemplarNummer = 1;
      ArrayList<String> autoren = new ArrayList<String>();
      autoren.add(document.getString("author"));
      String jahr= document.getString("year");
      String title= document.getString("title");
      double price= 9.99;
      String address= document.getString("adress");
      String series = "";
      if(document.contains("series")) {
        series = document.getString("series");
      }
      String doi= document.getString("doi");
      String  aAbstract = "";
      String publisher= document.getString("publisher");
      ArrayList<String> genre = new ArrayList<String>();
      buecherVorher.add(new Buch(isbn,(int)exemplarNummer,autoren,Integer.parseInt(jahr),title,price,address,series,doi,aAbstract,publisher,genre,regal,zeile,stelle));
      stelle++;
      autoren.remove(0);
      if (stelle>10){
        zeile++;
        stelle = 0;
        if (zeile>10){
          zeile = 0;
          regal++;
        }
      }
    }
    for (int i = 0;i<buecherVorher.size();i++){
      handler.writeBook(buecherVorher.get(i));
    }
  }

  public void writeKunde(Kunde neuKunde) throws ExecutionException, InterruptedException {
    ApiFuture<QuerySnapshot> query = db.collection("Kunde").get();
    QuerySnapshot querySnapshot = query.get();
    List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
    DocumentReference docRef = db.collection("Kunde").document(""+documents.size());
    Map<String, Object> data = new HashMap<>();
    data.put("KID",documents.size());
    data.put("nachname",neuKunde.getNachname());
    data.put("vorname",neuKunde.getVorname());
    data.put("anrede",neuKunde.getAnrede());
    data.put("geburtstag",neuKunde.getGeburtstag());
    data.put("wohnort",neuKunde.getWohnort());
    data.put("PLZ",neuKunde.getPLZ());
    data.put("strasse",neuKunde.getStrasse());
    data.put("hausnummer",neuKunde.getHausnummer());
    data.put("verleihlisteRef",writeVerleihliste());
    ApiFuture<WriteResult> result = docRef.set(data);
    System.out.println("Update time : " + result.get().getUpdateTime());
  }

  public ArrayList<Kunde> getKunden() throws ExecutionException, InterruptedException {
    ApiFuture<QuerySnapshot> query = db.collection("Kunde").get();
    QuerySnapshot querySnapshot = query.get();
    List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
    ArrayList<Kunde> result = new ArrayList<Kunde>();
    for (QueryDocumentSnapshot document : documents){
      long KID = document.getLong("KID");
      String nachname = document.getString("nachname");
      String vorname = document.getString("vorname");
      String anrede = document.getString("anrede");
      String gebrutstag = document.getString("geburtstag");
      String wohnort = document.getString("wohnort");
      String PLZ = document.getString("PLZ");
      String strasse = document.getString("strasse");
      String hausnummer = document.getString("hausnummer");
      long verleihlisteRef = document.getLong("verleihlisteRef");
      Verleihliste verleihliste = handler.getVerleihlisteByID((int)verleihlisteRef,(int)KID);
      result.add(new Kunde(nachname,vorname,anrede,gebrutstag,wohnort,PLZ,strasse,hausnummer,(int)KID,verleihliste));
    }
    return result;
  }

  public Kunde getKundeByID(int id) throws ExecutionException, InterruptedException {
    ArrayList<Kunde> kunden = handler.getKunden();
    for (int i=0;i<kunden.size();i++){
      if (kunden.get(i).getKID()==id){
        return kunden.get(i);
      }
    }
    return null;
  }

  public int writeLeihe(Leihe neueLeihe, int KID) throws ExecutionException, InterruptedException {
    Kunde kunde = handler.getKundeByID(KID);
    Verleihliste verleihliste = kunde.getPersVerleihiste();
    int VID = verleihliste.getVID();
    ApiFuture<QuerySnapshot> query = db.collection("Verleihliste").document("VID").collection("Leihe").get();
    QuerySnapshot querySnapshot = query.get();
    List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
    DocumentReference docRef = db.collection("Verleihliste").document("VID").collection("Leihe").document(documents.size()+"");
    Map<String, Object> data = new HashMap<>();
    data.put("LID",documents.size());
    data.put("Zeitstempel", ""+System.currentTimeMillis());
    data.put("zeitspanne",neueLeihe.getZeitspanne());
    data.put("ueberziehungsPreis",neueLeihe.getUeberziehungsPreis());
    data.put("MID",neueLeihe.getMitarbeiter().getMID());
    ApiFuture<WriteResult> result = docRef.set(data);
    System.out.println("Update time : " + result.get().getUpdateTime());
    return documents.size();
  }

  public ArrayList<Leihe> getLeihen(int KID) throws ExecutionException, InterruptedException {
    Kunde kunde = handler.getKundeByID(KID);
    Verleihliste verleihliste = kunde.getPersVerleihiste();
    int VID = verleihliste.getVID();
    ApiFuture<QuerySnapshot> query = db.collection("Verleihliste").document(VID+"").collection("Leihe").get();
    QuerySnapshot querySnapshot = query.get();
    List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
    ArrayList<Leihe> result = new ArrayList<Leihe>();
    for (QueryDocumentSnapshot document : documents){
      long LID = document.getLong("LID");
      String zeitstempel = document.getString("Zeitstempel");
      long zeitspanne = document.getLong("zeitstempel");
      double ueberziehungsPreis = document.getDouble("ueberziehungsPreis");
      long MID = document.getLong("MID");
      Mitarbeiter mitarbeiter = getMitarbeiterByID((int)MID);
      result.add(new Leihe((int)LID,zeitstempel,(int)zeitspanne,ueberziehungsPreis,mitarbeiter));
    }
    return result;
  }


  public Leihe getLeiheByID(int ID, int KID) throws ExecutionException, InterruptedException {
    ArrayList<Leihe> leihen = getLeihen(KID);
    for (int i = 0;i<leihen.size();i++){
      if (leihen.get(i).getLID()==ID) return leihen.get(i);
    }
    return null;
  }

  public void writeMitarbeiter(Mitarbeiter neuerMitarbeiter)
      throws ExecutionException, InterruptedException {
    ApiFuture<QuerySnapshot> query = db.collection("Mitarbeiter").get();
    QuerySnapshot querySnapshot = query.get();
    List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
    DocumentReference docRef = db.collection("Mitarbeiter").document(""+documents.size());
    Map<String, Object> data = new HashMap<>();
    data.put("MID",documents.size());
    data.put("nachname",neuerMitarbeiter.getNachname());
    data.put("vorname",neuerMitarbeiter.getVorname());
    data.put("anrede",neuerMitarbeiter.getAnrede());
    data.put("geburtstag",neuerMitarbeiter.getGeburtstag());
    data.put("wohnort",neuerMitarbeiter.getWohnort());
    data.put("PLZ",neuerMitarbeiter.getPLZ());
    data.put("strasse",neuerMitarbeiter.getStrasse());
    data.put("hausnummer",neuerMitarbeiter.getHausnummer());
    data.put("versicherungsnummer",neuerMitarbeiter.getVersicherungsnummer());
    data.put("password",neuerMitarbeiter.getPassword());
    ApiFuture<WriteResult> result = docRef.set(data);
    System.out.println("Update time : " + result.get().getUpdateTime());
  }

  public ArrayList<Mitarbeiter> getMitarbeiter() throws ExecutionException, InterruptedException {
    ApiFuture<QuerySnapshot> query = db.collection("Mitarbeiter").get();
    QuerySnapshot querySnapshot = query.get();
    List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
    ArrayList<Mitarbeiter> result = new ArrayList<Mitarbeiter>();
    for (QueryDocumentSnapshot document : documents){
      long MID = document.getLong("MID");
      String nachname = document.getString("nachname");
      String vorname = document.getString("vorname");
      String anrede = document.getString("anrede");
      String gebrutstag = document.getString("geburtstag");
      String wohnort = document.getString("wohnort");
      String PLZ = document.getString("PLZ");
      String strasse = document.getString("strasse");
      String hausnummer = document.getString("hausnummer");
      long versicherungsnummer = document.getLong("versicherungsnummer");
      String password = document.getString("password");
      result.add(new Mitarbeiter(nachname,vorname,anrede,gebrutstag,wohnort,PLZ,strasse,hausnummer,(int)MID,(int)versicherungsnummer,password));
    }
    return result;
  }

  public Mitarbeiter getMitarbeiterByID(int id) throws ExecutionException, InterruptedException {
    ArrayList<Mitarbeiter> mitarbeiters = handler.getMitarbeiter();
    for (int i=0;i<mitarbeiters.size();i++){
      if (mitarbeiters.get(i).getMID()==id){
        return mitarbeiters.get(i);
      }
    }
    return null;
  }

  public int writeVerleihliste()
      throws ExecutionException, InterruptedException {
    ApiFuture<QuerySnapshot> query = db.collection("Verleihliste").get();
    QuerySnapshot querySnapshot = query.get();
    List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
    DocumentReference docRef = db.collection("Verleihliste").document(""+documents.size());
    Map<String, Object> data = new HashMap<>();
    data.put("VID",documents.size());
    ApiFuture<WriteResult> result = docRef.set(data);
    ApiFuture<QuerySnapshot> query2 = db.collection("Verleihliste").document(""+documents.size()).collection("Leihe").get();
    QuerySnapshot querySnapshot2 = query2.get();
    List<QueryDocumentSnapshot> documents2 = querySnapshot2.getDocuments();
    DocumentReference docRef2 = db.collection("Verleihliste").document(""+documents.size()).collection("Leihe").document(""+documents2.size());
    Map<String, Object> data2 = new HashMap<>();
    data2.put("Inital Entry","Init");
    ApiFuture<WriteResult> result2 = docRef2.set(data2);
    System.out.println("Update time : " + result.get().getUpdateTime());
    System.out.println("Update time : " + result2.get().getUpdateTime());
    return documents.size();
  }

  public ArrayList<Verleihliste> getVerleihliste(int KID) throws ExecutionException, InterruptedException {
    ApiFuture<QuerySnapshot> query = db.collection("Verleihliste").get();
    QuerySnapshot querySnapshot = query.get();
    List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();

    ArrayList<Verleihliste> result = new ArrayList<Verleihliste>();
    for (QueryDocumentSnapshot document : documents){
      long VID = document.getLong("VID");
      ApiFuture<QuerySnapshot> query2 = db.collection("Verleihliste").document(document.getId()).collection("Leihe").get();
      QuerySnapshot querySnapshot2 = query2.get();
      List<QueryDocumentSnapshot> documents2 = querySnapshot2.getDocuments();
      ArrayList<Leihe> leihen = new ArrayList<>();
      for (QueryDocumentSnapshot document2 : documents2){
        long id = document2.getLong("LID");
        int ID = (int)id;
        leihen.add(handler.getLeiheByID(ID, KID));
      }
      result.add(new Verleihliste((int)VID,leihen));
    }
    return result;
  }

  public Verleihliste getVerleihlisteByID(int ID, int KID) throws ExecutionException, InterruptedException {
    ArrayList<Verleihliste> list = handler.getVerleihliste(KID);
    for (int i = 0;i<list.size();i++){
      if (list.get(i).getVID()==ID) return list.get(i);
    }
    return null;
  }

}
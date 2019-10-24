import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.FileInputStream;
import java.io.IOException;

public class DatabaseHandler {
  public static void main(String[] args) throws IOException {
    FileInputStream refreshToken = new FileInputStream("DBplus-191023173134.json");

    FirebaseOptions options = new FirebaseOptions.Builder()
        .setCredentials(GoogleCredentials.fromStream(refreshToken))
        .setDatabaseUrl("https://dbplus-6b6d0.firebaseio.com")
        .build();

    FirebaseApp.initializeApp(options);
  }

  public void connectToDatabase() throws IOException {
    FileInputStream refreshToken = new FileInputStream("DBplus-191023173134.json");

    FirebaseOptions options = new FirebaseOptions.Builder()
        .setCredentials(GoogleCredentials.fromStream(refreshToken))
        .setDatabaseUrl("https://dbplus-6b6d0.firebaseio.com")
        .build();

    FirebaseApp.initializeApp(options);
  }

}
//
////GOOGLE_APPLICATION_CREDENTIALS=C:\Users\A703967\Desktop\DHBW\Semester 3\DB+\DBplus private key\DBplus-191023173134.json
//$env:GOOGLE_APPLICATION_CREDENTIALS=C:\Users\A703967\Desktop\DHBW\Semester 3\DB+\DBplus private key\DBplus-191023173134.json
////    GOOGLE_CLOUD_PROJECT=dbplus-6b6d0
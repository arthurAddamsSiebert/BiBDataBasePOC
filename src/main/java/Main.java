import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Main {

  public static void main(String[] args)
      throws ExecutionException, InterruptedException, IOException {
    DatabaseHandler handler = new DatabaseHandler();
    handler.connectToDatabase();
    Mitarbeiter mitarbeiter = handler.getMitarbeiterByID(1);
    //System.out.println(handler.getBuchByID());
    Leihe leihe = new Leihe(2,"",3,9.99,mitarbeiter,handler.getBuecher().get(1));
    handler.writeLeihe(leihe,1);
  }
}

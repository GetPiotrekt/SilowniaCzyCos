import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Zapisywanie {
    public static void zapisWynikow(String cw, int nrSer, float ciez, int obj, int powt) {
        try {
            FileWriter postepy = new FileWriter("wynik.txt", true);
            postepy.write("Cwiczenie: " + cw + "\n");
            postepy.write("Numer serii: " + nrSer + "\n");
            postepy.write("Ciezar: " + ciez + "\n");
            postepy.write("Ilosc powtorzen: " + powt + "\n");
            postepy.write("Aktualna objetosc: " + obj + "\n\n");
            postepy.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void zapiszDate() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("[dd.MM.yyyy; HH:mm]");
            Date currentDate = new Date();
            String formattedDate = dateFormat.format(currentDate);

            FileWriter plik = new FileWriter("wynik.txt", true);
            plik.write("Rozpoczęcie treningu: " + formattedDate + "\n\n");
            plik.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void zapisCzasuTreningu(long totalTime) {
        try {
            FileWriter plik = new FileWriter("wynik.txt", true); // Dodaj czas treningu do pliku "wynik.txt"
            plik.write("Czas treningu: " + formatujCzas(totalTime) + "\n\n");
            plik.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String formatujCzas(long millis) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        return dateFormat.format(new Date(millis));
    }
}
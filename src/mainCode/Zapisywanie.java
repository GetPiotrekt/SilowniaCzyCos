import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
public class Zapisywanie {
    public static void zapisWynikow(String cw, int nrSer, float ciez, int obj, int powt) {
        try {
            BufferedWriter postepy = new BufferedWriter(new FileWriter("wynik.txt", true));
            postepy.write("Cwiczenie: " + cw + "\n");
            postepy.write("Numer serii: " + nrSer + "\n");
            postepy.write("Ciezar: " + ciez + "\n");
            postepy.write("Ilosc powtorzen: " + powt + "\n");
            postepy.write("Aktualna objetosc: " + obj + "\n\n");
            postepy.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter postepy = new BufferedWriter(new FileWriter("odczyt.txt", true));
            postepy.write(cw + " ; " + nrSer + " ; " + ciez + " ; " + powt + " ; " + obj + "\n");
            postepy.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void wyswietlZawartosc() {
        try {
            BufferedReader czytaj = new BufferedReader(new FileReader("odczyt.txt"));
            String linia;
            System.out.println("Cwiczenie; Numer Serii; Ciezar; ilosc powtorzen; objetosc;");
            while ((linia = czytaj.readLine()) != null) {
                System.out.println(linia);
            }
            czytaj.close();
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

    public static String formatujCzas(long millis) {
        Duration duration = Duration.ofMillis(millis);
        long hours = duration.toHours();
        int minutes = duration.toMinutesPart();
        int seconds = duration.toSecondsPart();
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
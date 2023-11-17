package mainCode;

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

        zapiszDateDoOdczytu(); // Dodaj datę na początku pliku "odczyt.txt"

        try {
            BufferedWriter postepy = new BufferedWriter(new FileWriter("odczyt.txt", true));
            postepy.write(cw + " ; " + nrSer + " ; " + ciez + " ; " + powt + " ; " + obj + "\n");
            postepy.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void wyswietlZawartosc() {
        BufferedReader czytaj = new BufferedReader(new FileReader("odczyt.txt"));
        String linia;
        System.out.println("Data; Cwiczenie; Numer Serii; Ciezar; ilosc powtorzen; objetosc;");

        while ((linia = czytaj.readLine()) != null) {
            String[] elements = linia.split(" ; ");

            if (elements.length == 6) {
                String formattedDate = elements[0];
                formattedDate = formattedDate.substring(0, 2) + "." + formattedDate.substring(2, 4) + "." + formattedDate.substring(4);
                System.out.println(formattedDate + " ; " + elements[1] + " ; " + elements[2] + " ; " + elements[3] + " ; " + elements[4] + " ; " + elements[5]);
            }
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

    public static void zapiszDateDoOdczytu() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
            Date currentDate = new Date();
            String formattedDate = dateFormat.format(currentDate);

            // Dodanie zer przed jednocyfrowymi dniami i miesiącami
            formattedDate = formattedDate.substring(0, 2) + formattedDate.substring(2, 4) + formattedDate.substring(4);

            FileWriter plik = new FileWriter("odczyt.txt", true);
            plik.write(formattedDate + " ; ");
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

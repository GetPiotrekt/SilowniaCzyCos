import java.util.Scanner;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Zapisywanie.zapiszDate(); // zapisanie daty
        int aktualneCwiczenie = 1;
        Scanner scanner = new Scanner(System.in);

        Date startTime = new Date(); // Rozpoczęcie pomiaru czasu

        while (aktualneCwiczenie != 4) {
            System.out.println("\nWybierz cwiczenie z listy:");
            System.out.println("0. Kalkulator zapotrzebowania kalorycznego");
            System.out.println("1. Wyciskanie sztangi na lawce plaskiej");
            System.out.println("2. Podciaganie na drazku");
            System.out.println("3. Martwy ciag");
            System.out.println("4. Koniec treningu\n");
            System.out.print("Twoj wybor: ");

            int wybor = scanner.nextInt();

            switch (wybor) {
                case 0 -> {
                    KalkulatorKalorii kalkulator = new KalkulatorKalorii();
                    double zapotrzebowanieKaloryczne = kalkulator.obliczZapotrzebowanieKaloryczne();
                    System.out.println("Twoje podstawowe zapotrzebowanie kaloryczne wynosi: " + zapotrzebowanieKaloryczne + " kcal");
                }
                case 1 -> Cwiczenia.lawkaPlaska();
                case 2 -> Cwiczenia.podciaganie();
                case 3 -> Cwiczenia.martwyCiag();
                case 4 -> {
                    Date endTime = new Date(); // Zakończenie pomiaru czasu
                    long totalTime = endTime.getTime() - startTime.getTime();
                    System.out.println("Czas treningu: " + totalTime / 1000 + " sekundy");
                    Zapisywanie.zapisCzasuTreningu(totalTime);
                    System.out.println("Zakonczono program.");
                    aktualneCwiczenie = 4;
                }
                default -> System.out.println("Niepoprawny wybor. Wybierz ponownie.");
            }
        }

        System.out.println("Program zakonczyl dzialanie. Wcisnij 'enter', aby zamknac");
        scanner.close();
    }
}
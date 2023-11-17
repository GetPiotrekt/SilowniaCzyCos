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
            System.out.println("1. Wyciskanie sztangi na lawce plaskiej");
            System.out.println("2. Podciaganie na drazku");
            System.out.println("3. Martwy ciag");
            System.out.println("4. Pokaż wyniki");
            System.out.println("5. Koniec treningu\n");
            System.out.print("Twoj wybor: ");

            int wybor = scanner.nextInt();

            switch (wybor) {
                case 1:
                    Cwiczenia.lawkaPlaska();
                    break;
                case 2:
                    Cwiczenia.podciaganie();
                    break;
                case 3:
                    Cwiczenia.martwyCiag();
                    break;
                case 4:
                    Zapisywanie.wyswietlZawartosc();
                    break;
                case 5:
                    Date endTime = new Date(); // Zakończenie pomiaru czasu
                    long totalTime = endTime.getTime() - startTime.getTime();
                    System.out.println("Czas treningu: " + Zapisywanie.formatujCzas(totalTime));

                    Zapisywanie.zapisCzasuTreningu(totalTime);

                    System.out.println("Zakonczono program.");
                    aktualneCwiczenie = 4;
                    break;
                default:
                    System.out.println("Niepoprawny wybor. Wybierz ponownie.");
                    break;
            }
        }

        System.out.println("Program zakonczyl dzialanie. Wcisnij 'enter', aby zamknac");
        scanner.close();
    }
}
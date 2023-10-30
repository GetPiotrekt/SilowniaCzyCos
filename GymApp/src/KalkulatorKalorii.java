import java.util.Scanner;

public class KalkulatorKalorii {
    private String plec;
    private int wiek;
    private double waga;
    private double wzrost;
    private int poziomAktywnosci;

    public KalkulatorKalorii() {
        pobierzDaneOdUzytkownika();
    }

    public void pobierzDaneOdUzytkownika() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Witaj w kalkulatorze kalorii!");
        do {
            System.out.print("Podaj swoja plec (mezczyzna/kobieta): ");
            plec = scanner.nextLine().toLowerCase(); // Wprowadzona płeć zostanie zmieniona na małe litery
            if (!plec.equals("mezczyzna") && !plec.equals("kobieta")) {
                System.out.println("Niepoprawna plec. Wprowadz 'mezczyzna' lub 'kobieta'.");
            }
        } while (!plec.equals("mezczyzna") && !plec.equals("kobieta"));

        System.out.print("Podaj swoj wiek: ");
        wiek = scanner.nextInt();

        System.out.print("Podaj swoja wage (w kg): ");
        waga = scanner.nextDouble();

        System.out.print("Podaj swoj wzrost (w cm): ");
        wzrost = scanner.nextDouble();

        System.out.println("Wybierz swoj poziom aktywnosci:");
        System.out.println("1. Brak aktywnosci lub siedzacy tryb zycia");
        System.out.println("2. Umiarkowana aktywnosc (cwiczenia 1-3 razy w tygodniu)");
        System.out.println("3. Aktywny (cwiczenia 3-5 razy w tygodniu)");
        System.out.println("4. Bardzo aktywny (cwiczenia codziennie)");
        System.out.println("5. Super aktywny (ciezki trening codziennie)");
        System.out.print("Wybierz numer: ");
        poziomAktywnosci = scanner.nextInt();

        System.out.println("Dane zostały zapisane.");
    }

    public double obliczZapotrzebowanieKaloryczne() {
        // Obliczanie BMR (Bazowego wskaźnika metabolicznego) w zależności od płci
        double bmr;
        if (plec.equalsIgnoreCase("mezczyzna")) {
            bmr = 88.362 + (13.397 * waga) + (4.799 * wzrost) - (5.677 * wiek);
        } else if (plec.equalsIgnoreCase("kobieta")) {
            bmr = 447.593 + (9.247 * waga) + (3.098 * wzrost) - (4.330 * wiek);
        } else {
            throw new IllegalArgumentException("Niepoprawna płeć. Wybierz 'mezczyzna' lub 'kobieta'.");
        }

        // Obliczanie zapotrzebowania kalorycznego z uwzględnieniem poziomu aktywności
        double zapotrzebowanie;
        do {
            switch (poziomAktywnosci) {
                case 1:
                    zapotrzebowanie = bmr * 1.2; // Brak aktywności lub siedzący tryb życia
                    break;
                case 2:
                    zapotrzebowanie = bmr * 1.375; // Umiarkowana aktywność (ćwiczenia 1-3 razy w tygodniu)
                    break;
                case 3:
                    zapotrzebowanie = bmr * 1.55; // Aktywny (ćwiczenia 3-5 razy w tygodniu)
                    break;
                case 4:
                    zapotrzebowanie = bmr * 1.725; // Bardzo aktywny (ćwiczenia codziennie)
                    break;
                case 5:
                    zapotrzebowanie = bmr * 1.9; // Super aktywny (ciężki trening codziennie)
                    break;
                default:
                    throw new IllegalArgumentException("Niepoprawny poziom aktywności. Wybierz wartość od 1 do 5.");
            }
        } while (poziomAktywnosci < 1 || poziomAktywnosci > 5);

        return zapotrzebowanie;
    }
}

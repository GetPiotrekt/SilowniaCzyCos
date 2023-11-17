import java.util.Scanner;
public class Cwiczenia {
    public static int podciaganie() {
        String cwiczenie = "Podciaganie";
        float masaCiala, masaObiektu, dodatkowyCiezar = 0, objetosc = 0;
        int iloscPodciagniec, numerSerii = 1;
        char znak;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj swoja aktualna mase: ");
        masaCiala = scanner.nextFloat();

        while (true) {
            System.out.println("Czy tym razem dokladasz dodatkowy ciezar, do podciagania (1-NIE; 2-TAK): ");
            char ciezar = scanner.next().charAt(0);

            if (ciezar == '2') {
                System.out.println("Podaj wartosc tego obciazenia: ");
                dodatkowyCiezar = scanner.nextFloat();
            }

            System.out.println(numerSerii + " seria");
            System.out.println("Ile razy udalo ci sie tym razem podciagnac?");
            iloscPodciagniec = scanner.nextInt();

            masaObiektu = masaCiala + dodatkowyCiezar;
            objetosc += (masaObiektu * iloscPodciagniec);
            System.out.println("Aktualna objetosc treningowa wynosi: " + objetosc + "\n");

            Zapisywanie.zapisWynikow(cwiczenie, numerSerii, masaObiektu, (int) objetosc, iloscPodciagniec);

            numerSerii++;

            System.out.println("Jesli chcesz dalej cwiczyc podciaganie wpisz '1'");
            System.out.println("Jesli chcesz zakonczyc to cwiczenie, wpisz '2'\n");

            znak = scanner.next().charAt(0);

            if (znak == '2') {
                return znak;
            }
        }
    }
    public static int lawkaPlaska() {
        String cwiczenie = "Wyciskanie sztangi na lawce plaskiej";
        float ciezar;
        float objetosc = 0;
        int numerSerii = 1, iloscPowtorzen;
        char znak;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj aktualny ciezar: ");
        ciezar = scanner.nextFloat();

        while (true) {
            System.out.println(numerSerii + " seria");
            System.out.println("Ile razy udalo ci sie tym razem podniesc?");
            iloscPowtorzen = scanner.nextInt();

            objetosc += (iloscPowtorzen * ciezar);
            System.out.println("Aktualna objetosc treningowa wynosi: " + objetosc + "\n");

            Zapisywanie.zapisWynikow(cwiczenie, numerSerii, ciezar, (int) objetosc, iloscPowtorzen);

            numerSerii++;

            System.out.println("Jesli chcesz cwiczyc, z tym ciezarem dalej, wpisz '1'");
            System.out.println("Jesli chcesz zmienic ciezar, wpisz '2'");
            System.out.println("Jesli chcesz zakonczyc to cwiczenie, wpisz '3'\n");

            znak = scanner.next().charAt(0);

            if (znak == '2') {
                System.out.println("Podaj nowy ciezar: ");
                ciezar = scanner.nextFloat();
            } else if (znak == '3') {
                return znak;
            }
        }
    }
    public static int martwyCiag() {
        String cwiczenie = "Martwy ciag";
        float ciezar;
        float objetosc = 0;
        int numerSerii = 1, iloscPowtorzen;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj aktualny ciezar: ");
        ciezar = scanner.nextFloat();

        while (true) {
            System.out.println(numerSerii + " seria");
            System.out.println("Ile razy udalo ci sie tym razem podniesc?");
            iloscPowtorzen = scanner.nextInt();

            objetosc += (iloscPowtorzen * ciezar);
            System.out.println("Aktualna objetosc treningowa wynosi: " + objetosc + "\n");

            Zapisywanie.zapisWynikow(cwiczenie, numerSerii, ciezar, (int) objetosc, iloscPowtorzen);

            numerSerii++;

            System.out.println("Jesli chcesz cwiczyc, z tym ciezarem dalej, wpisz '1'");
            System.out.println("Jesli chcesz zmienic ciezar, wpisz '2'");
            System.out.println("Jesli chcesz zakonczyc to cwiczenie, wpisz '3'\n");

            char znak = scanner.next().charAt(0);

            if (znak == '2') {
                System.out.println("Podaj nowy ciezar: ");
                ciezar = scanner.nextFloat();
            } else if (znak == '3') {
                return znak;
            }
        }
    }
}

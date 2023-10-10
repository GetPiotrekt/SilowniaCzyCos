package mainCode;

import java.util.Scanner;

public class ExerciseTypes {
    Scanner scanner = new Scanner(System.in);
    public static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }

    public void pullUps(){

        float userWeight;
        float objectWeight=0;
        float additionalWeight=0;
        float volume=0;
        int reps=0;
        int sets=0;
        char weightType;
        char Symbol;
        clearConsole();
        System.out.println("Podaj aktualna mase ciala: ");
        userWeight=scanner.nextFloat();


        for(;;){
            System.out.println("Czy chcesz dodac obciazenie? (T/N)");
            weightType=scanner.next().charAt(0);
            if (weightType=='T'||weightType=='t'){
                System.out.println("Podaj mase obciazenia: ");
                additionalWeight=scanner.nextFloat();
                clearConsole();

            }
            else if (weightType=='N'||weightType=='n'){
                clearConsole();

            }
            else{
                System.out.println("Niepoprawny znak");
            }
            System.out.println(sets+" seria");
            System.out.println("Ile razy udało ci się podciągnąć?");
            reps=scanner.nextInt();
            objectWeight=userWeight+additionalWeight;
            volume += (objectWeight*reps);
            System.out.println("Podciągnąłeś: "+volume+" kg");
            SaveToFile.saveToFile("exercise.txt", ExerciseTypes.class.getName(), sets, reps, volume,objectWeight);

            sets++;

            System.out.println("Czy chcesz kontynuować? (T/N)");
            Symbol= scanner.next().charAt(0);
            switch (Symbol){
                case 'T':
                    clearConsole();

                case 't':
                    clearConsole();
                case 'N':
                    clearConsole();
                    System.out.println("Koniec treningu");
                    System.exit(0);
                case 'n':
                    clearConsole();
                    System.out.println("Koniec treningu");
                    System.exit(0);

                default:
                    System.out.println("Niepoprawny znak");

            }



        }


    }


}

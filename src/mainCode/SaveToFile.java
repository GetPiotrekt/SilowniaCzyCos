package mainCode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveToFile {

    //basic method of saving to txt file
    public static void saveToFile(String fileName, String text, int sets, int reps, float volume, float objectWeight){
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(text);
            bufferedWriter.close();
        }
        catch (IOException e){
            System.out.println("Error while saving to file");
        }
    }
}

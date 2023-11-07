package lab4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Translator translator = new Translator();
        String dictionaryPath = "dictionary.txt";
        String translatePath = "translate.txt";
        try {
            translator.loadDictionary(dictionaryPath);
            try (BufferedReader reader = new BufferedReader(new FileReader(translatePath))){
                String line;
                while ((line = reader.readLine()) != null){
                    translator.printTranslation(line);
                }
            } catch (IOException e){
                System.err.println("Error while reading file: " + e.getMessage());
            }
        } catch (FileReadException | InvalidFileFormatException e) {
            System.err.println("Error while loading file: " + e.getMessage());
        }
    }
}
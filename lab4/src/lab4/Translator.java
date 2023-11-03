package lab4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Translator {
    Map<String, String> dictionary = new HashMap<>();   //используем Map, чтобы можно было обращаться по ключу

    public void loadDictionary(String filename) throws FileReadException, InvalidFileFormatException{
        File file = new File(filename);
        if (!file.exists()){
            throw new FileReadException(filename + " doesn't exist");
        }       //проверка существует ли файл
        Path path = Paths.get(filename);    //получение пути для дальнейшей обработки искючения доступа
        if (!(Files.isReadable(path))){
            throw new FileReadException(filename + " access denied");
        } //проверка на доступность файла
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){      //читаем файл
            String line = reader.readLine();    //читаем строчку
            if (line == null){
                throw new InvalidFileFormatException("Invalid format in file. Empty line");
            }
            while (line != null){
                String[] keyValue = line.split("//|");
                if (keyValue.length != 2 || keyValue[0].isBlank() || keyValue[0].isEmpty() || keyValue[1].isBlank()
                        || keyValue[1].isEmpty()) {      //обработка исключений по строке
                    throw new InvalidFileFormatException("Invalid format in file. Invalid line");
                }
                dictionary.put(keyValue[0].trim().toLowerCase(), keyValue[1].trim());   //добавляем одно слово, как
                // ключ, второе, как значени
                line = reader.readLine();
            }
        } catch (IOException e){
            throw new FileReadException("Error in reading file" + e);
        }
    }
}

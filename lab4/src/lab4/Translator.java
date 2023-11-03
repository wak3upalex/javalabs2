package lab4;

import java.io.File;
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
    }
}

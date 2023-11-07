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
                String[] keyValue = line.split("\\|");
                if (keyValue.length != 2 || keyValue[0].isBlank() || keyValue[0].isEmpty() || keyValue[1].isBlank()
                        || keyValue[1].isEmpty()) {      //обработка исключений по строке
                    throw new InvalidFileFormatException("Invalid format in file. Invalid line");
                }
                dictionary.put(keyValue[0].trim().toLowerCase(), keyValue[1].trim());   //добавляем одно слово, как
                // ключ, второе, как значение
                line = reader.readLine();
            }
        } catch (IOException e){
            throw new FileReadException("Error in reading file" + e);
        }
    }

    private String[] translateExpression(String text, int start){
        String longestTranslation = null;
        int longestKeyLength = 0;
        for (String key : dictionary.keySet()){     //проходимся по значению ключей из словаря
            if (text.regionMatches(true, start, key, 0, key.length())){
                //игнорим регистр, сравнивет text начиная со 'start', сравнвает на соответствие с key, идм с первого
                //элемента строки, идем по длине всего слова, которое мы взяли через key из dictionary

                if (longestTranslation == null || key.length() > longestKeyLength){ //если это первый перевод или
                    // длина текущего ключа key больше длины предыдущего наиболее длинного ключа
                    longestTranslation = dictionary.get(key.toLowerCase()); //сохраняем новый длинный перевод
                    longestKeyLength = key.length();    //обновляем длину самого длинного ключа
                }
            }
        }
        return new String[]{longestTranslation, Integer.toString(longestKeyLength)};
        //возвращаем через массив строк самый длинный перевод и длину самой длинной строки
    }

    public String translate (String text){
        StringBuilder finalTranslation = new StringBuilder();    //используем StringBuilder для того, чтобы можно было
        // изменять строчку без создавания новых строк
        int i = 0;
        while (i < text.length()){
            String[] translationInfo = translateExpression(text, i);//ищем перевод, начиная с позиции i
            String translation = translationInfo[0];
            if (translation != null){
                finalTranslation.append(translation);
                i += Integer.parseInt(translationInfo[1]);
                //Увеличивает индекс i на длину переведенной фразы (translationInfo[1]). Это гарантирует, что следующая
                //итерация цикла начнется сразу после конца последней успешно переведенной фразы.
            }else {
                finalTranslation.append(text.charAt(i));//если перевода не нашли, то просто добавляем без изменений
                i++;
            }
        }
        return finalTranslation.toString();
    }

    public void printTranslation (String text){
        System.out.println(translate(text));
    }
}

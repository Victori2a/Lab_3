package managers;

import model.Coordinates;
import model.EyeColor;
import model.HairColor;
import model.StudyGroup;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.LinkedList;

public class FileManager {
    public static LinkedList<StudyGroup> readCollectionFromCSV(String filename, ConsoleHandler consoleHandler) {
        LinkedList<StudyGroup> collection = new LinkedList<>();
        try {
            File file = new File(filename);
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String firstLine = bufferedReader.readLine();
            if (firstLine == null) throw new NullPointerException("Этот файл пустой!");
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                collection.add(parseOrganizationFromStrings(values));
            }
            consoleHandler.println("Коллекция загружена!");
            consoleHandler.printAdvice("Напишите help для просмотра списка команд");
            return collection;
        } catch (IOException e) {
            consoleHandler.printError("Файл с таким именем не найден. Попробуйте еще раз.");
            return null;
        } catch (NullPointerException e) {
            consoleHandler.printError(e.toString());
            return null;
        }
    }
    private static StudyGroup parseStudyGroupFromStrings(String[] data) {
        Long id = Long.parseLong(data[0]); //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
        String name = data[1]; //Поле не может быть null, Строка не может быть пустой
        Coordinates coordinates = new Coordinates(Integer.parseInt(data[2]), Long.parseLong(data[3])); //Поле не может быть null
        EyeColor eye = EyeColor.values()[Integer.parseInt(data[7])];
        HairColor hair = HairColor.values()[Integer.parseInt(data[7])];
        java.time.LocalDate creationDate = LocalDate.parse(data[4]); //Поле не может быть null, Значение этого поля должно генерироваться автоматически
        return new StudyGroup();
    }
}

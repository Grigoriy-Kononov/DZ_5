import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * DZ_5
 */
public class DZ_5 {

    public static void main(String[] args) {
        System.out.println("Здравствуйте!");
        System.out.println("Вашему вниманию представлена домашняя работа по теме:");
        System.out.println("'Хранение и обработка данных ч2: множество коллекций Map'");
        System.out.println("Задача №1:");
        System.out.println(
                "Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.");
        System.out.println("Задача №2:");
        System.out.println("Пусть дан список сотрудников:");
        System.out.println(
                "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, " +
                        "Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова,"
                        +
                        " Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, " +
                        "Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.");
        System.out.println("Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. "
                +
                "Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.");

        System.out.println("");
        System.out.println(task1("Иванов, +7(918)6756577, Васильев, +7(918)6765258, Петрова, +7(918)6748657," +
                " Иванов, +7(928)6655277, Петрова, +7(900)3213217, Иванов, +7(906)6854684"));
        System.out.println("");
        System.out.println(task2(
                "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, " +
                        "Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, " +
                        "Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов."));
    }

    static Map<String, List<String>> task1(String s) {
        System.out.println("Задача №1: ");
        s = s.replace(",", "");
        String[] temp = s.split(" ");
        TreeMap<String, List<String>> treeMap = new TreeMap<>();
        for (int index = 0; index < temp.length - 1; index++) {
            if (index % 2 == 0 && treeMap.containsKey(temp[index])) {
                List<String> list = treeMap.get(temp[index]);
                list.add(temp[index + 1]);
            }
            if (index % 2 == 0 && !treeMap.containsKey(temp[index])) {
                List<String> list = new ArrayList<>();
                list.add(temp[index + 1]);
                treeMap.put(temp[index], list);
            }
        }
        return treeMap;
    }

    static TreeMap<Integer, List<String>> task2(String s) {
        System.out.print("Задача №2: ");
        s = s.replace(".", "").replace(",", "");
        String[] words = s.split(" ");

        ArrayList<String> arrayList = new ArrayList<>();
        TreeMap<Integer, List<String>> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        for (int i = 0; i < words.length; i++) {
            if (i % 2 == 0) {
                arrayList.add(words[i]);
            }
        }

        for (int i = 0; i < arrayList.size(); i++) {
            int a = 0;
            for (int j = 0; j < arrayList.size(); j++) {
                if (arrayList.get(i).equals(arrayList.get(j))) {
                    a++;
                }
            }
            if (treeMap.containsKey(a)) {
                List<String> list = treeMap.get(a);
                list.add(arrayList.get(i));
            } else {
                List<String> list = new ArrayList<>();
                list.add(arrayList.get(i));
                treeMap.put(a, list);
            }

        }
        System.out.println("");
        return treeMap;

    }

}
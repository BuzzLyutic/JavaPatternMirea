package Practice_2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Инициализация дат рождения объектов списка
        LocalDate mySpecificDatea = LocalDate.of(1970, 2, 2);
        LocalDate mySpecificDateb = LocalDate.of(2024, 3, 14);
        LocalDate mySpecificDatec = LocalDate.of(2024, 7, 23);

        Human a = new Human(45, "Walter", "White", mySpecificDatea, 85);
        Human b = new Human(35, "Jessi", "Pinkman", mySpecificDateb, 55);
        Human c = new Human(90, "Bill", "Bob", mySpecificDatec, 100);

        List<Human> input = new ArrayList<>();
        input.add(a);
        input.add(b);
        input.add(c);
        Stream<Human> stream1 = input.stream();
        Stream<Human> stream2 = input.stream();
        Stream<Human> stream3 = input.stream();

        //Сортировка по второй букве имени в обратном порядке
        stream1.sorted(Comparator.comparing(obj -> obj.firstName.charAt(1), Comparator.reverseOrder())).forEach(Human::print);
        System.out.println("___________________________________________");
        //Фильтрация по весу больше, чем 60
        stream2.filter(obj -> obj.weight > 60).forEach(Human::print);
        System.out.println("___________________________________________");
        //Сортировка по возрасту
        stream3.sorted(Comparator.comparingInt(Human::getAge)).forEach(Human::print);
        System.out.println("___________________________________________");
        //Произведение всех возрастов
        int mux = input.stream().mapToInt(Human::getAge).reduce(1, (x, y) -> x * y);
        System.out.println();
        System.out.println(mux);
    }
}

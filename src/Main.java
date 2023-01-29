import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

   //Задание 1
    /*Напишите метод findMinMax,
    находящий в стриме минимальный и максимальный элементы
    в соответствии порядком, заданным Comparator'ом.*/
    public static <T> void FindMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> items = stream.sorted(order).collect(Collectors.toList());
        if (!items.isEmpty()) {
            minMaxConsumer.accept(items.get(0), items.get(items.size() - 1));

        } else {
            minMaxConsumer.accept(null, null);
        }
    }

    public static void main(String[] args) throws Exception {

        //Задание 1
        System.out.println("Задание №1 - Нахождение мин. и макс. элемента в потоке");
        Stream<Integer> stream = new ArrayList<>(Arrays.asList(4, 2, 3, 5, 8, 13, 15)).stream();
        FindMinMax(
                stream,
                Integer::compareTo,
                (x, y) -> System.out.println(String.format("min: %s, max: %s", x, y))
        );

        stream.close();
        System.out.println("");
        //Задание 2
        System.out.println("Задание №2 - Расчёт количества четных чисел");
        EvenNumber();
    }

    public static void EvenNumber() {

        ArrayList<Integer> randomList = new ArrayList<Integer>();
        int number;
        Random rnd = new Random();
        for (int i=0; i<10; i++) {
            number = rnd.nextInt() % 100;
            randomList.add(number);
        }
        System.out.println("1) Выводим массив случайных 10 значений:");
        System.out.println(randomList);

        int n2 = (int)(randomList.stream().filter((n)->(n%2)==0)).count();
        System.out.println("2) Количество четных чисел = " + n2);
    }
}
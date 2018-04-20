package kae.hello.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HelloStream {

  public static void main(String[] args) {
    List<Dish> menu = Arrays.asList(
        new Dish("pork", false, 800, Dish.Type.MEAT),
        new Dish("beef", false, 700, Dish.Type.MEAT),
        new Dish("chicken", false, 400, Dish.Type.MEAT),
        new Dish("french fries", true, 530, Dish.Type.OTHER),
        new Dish("rice", true, 350, Dish.Type.OTHER),
        new Dish("season fruit", true, 120, Dish.Type.OTHER),
        new Dish("salad", true, 120, Dish.Type.OTHER),
        new Dish("pizza", true, 550, Dish.Type.OTHER),
        new Dish("prawns", false, 350, Dish.Type.FISH),
        new Dish("salmon", false, 450, Dish.Type.FISH));

    final List<String> sortedList = menu.stream()
        .sorted(Comparator
            .comparing(Dish::getCalories)
            .thenComparing(Dish::getName))
        .map((dish) -> dish.getName() + " (" + dish.getCalories() + ")")
        .collect(Collectors.toList());
    System.out.println(sortedList);

    List<String> threeHighCaloriesList = menu.stream()
        .filter(dish -> dish.getCalories() > 300)
        .sorted(Comparator.comparing(Dish::getCalories).reversed())
        .map(Dish::getName)
        .limit(3)
        .collect(Collectors.toList());
    System.out.println(threeHighCaloriesList);

    List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
    numbers.stream()
        .filter(i -> i % 2 == 1)
        .distinct()
        .forEach(System.out::println);

    menu.stream().filter(dish -> dish.getType() == Dish.Type.MEAT).skip(2).forEach(System.out::println);

    List<String> uniqueLetters =
        Arrays.stream("Hello World" .split(" "))
            .map(s -> s.split(""))
            .flatMap(Arrays::stream)
            .distinct()
            .collect(Collectors.toList());
    System.out.println(uniqueLetters);

    numbers = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> squares = numbers.stream().map(v -> v * v).collect(Collectors.toList());
    System.out.println(squares);

    List<Integer> numbers1 = Arrays.asList(1, 2, 3);
    List<Integer> numbers2 = Arrays.asList(3, 4);

    List<List<Integer>> pairs =
        numbers1.stream().flatMap(i -> numbers2.stream().map(j -> Arrays.asList(i, j))).collect(Collectors.toList());
    System.out.println(pairs);

    List<List<Integer>> filteredPairs = numbers1.stream()
        .flatMap(i -> numbers2
            .stream()
            .filter(j -> (i + j) % 3 == 0)
            .map(j -> Arrays.asList(i, j)))
        .collect(Collectors.toList());
    System.out.println(filteredPairs);
    System.out.println(Stream.of(1, 2).reduce((a, b) -> a + b));

    System.out.println(menu.stream().map(Dish::getCalories).reduce(0, (a, b) -> a + b));
    System.out.println(menu.stream().map(Dish::getCalories).reduce(0, Integer::max));

    System.out.println("Fibbonacci");
    Stream.iterate(new int[]{0, 1}, tuple -> new int[]{tuple[0] + tuple[1], tuple[1] + tuple[0] + tuple[1]})
        .limit(10)
        .flatMap(x -> Arrays.stream(x).boxed())
        .forEach(x -> System.out.printf("%d, ", x));
    System.out.println();

    Stream.generate(Math::random)
        .limit(5)
        .forEach(System.out::println);

    System.out.println();
    IntSummaryStatistics caloriesStatistics = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
    System.out.println(caloriesStatistics);

    final Map<String, Dish> caloriesMap = menu
        .stream()
        .collect(Collectors.toMap(
            dish -> dish.getName().toUpperCase(),
            Function.identity()));
    System.out.println(caloriesMap);
  }

}

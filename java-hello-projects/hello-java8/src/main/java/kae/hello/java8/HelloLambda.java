package kae.hello.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class HelloLambda {

  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>(10);
    for (int i = 0; i < 10; i++) {
      numbers.add(i);
    }
    final List<Integer> oddNumbers = filter(numbers, (Integer number) -> number % 2 == 1);
    System.out.println(oddNumbers);

    print(() -> "Hello!");
    print(() -> {
      //noinspection UnnecessaryLocalVariable
      String s = String.valueOf(System.currentTimeMillis());
      return s;
    });

    System.out.println(newInstance(String::new, "Hello method reference!"));

    Function<Double, Double> cos = Math::cos;
    Function<Double, Double> sin = Math::sin;

    System.out.println(cos.apply(Math.PI));
    System.out.println(sin.apply(Math.PI));
    System.out.println(sin.andThen(cos).apply(Math.PI));
    System.out.println(cos.compose(sin).apply(Math.PI));

    Map<Integer, Integer> squareMap = numbers.stream().collect(Collectors.toMap(UnaryOperator.identity(), v -> v * v));
    System.out.println(squareMap.keySet());
    System.out.println(squareMap.values());

    new HelloLambda().callLambdaWithThis();

    try {
      print(() -> {throw new RuntimeException("abc");});
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      print(() -> {throw new RuntimeException("def");});
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void callLambdaWithThis() {
    print(() -> this.getClass().toString());
  }

  public static <T> List<T> filter(List<T> src, Predicate<T> predicate) {
    List<T> dst = new ArrayList<>(src.size());
    //noinspection Convert2streamapi
    for (T t : src) {
      if (predicate.test(t)) {
        dst.add(t);
      }
    }
    return dst;
  }

  public static void print(StringGetter stringGetter) {
    System.out.println(stringGetter.get());
  }

  private static <T> T newInstance(Function<T, T> f, T t) {
    return f.apply(t);
  }

}

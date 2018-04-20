package kae.hello.java8;

import java.util.Objects;

public class Dish {

  private final String name;
  private final boolean vegetarian;
  private final int calories;
  private final Type type;

  public Dish(String name, boolean vegetarian, int calories, Type type) {
    this.name = name;
    this.vegetarian = vegetarian;
    this.calories = calories;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public boolean isVegetarian() {
    return vegetarian;
  }

  public int getCalories() {
    return calories;
  }

  public Type getType() {
    return type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Dish)) {
      return false;
    }
    Dish dish = (Dish) o;
    return vegetarian == dish.vegetarian &&
        calories == dish.calories &&
        Objects.equals(name, dish.name) &&
        type == dish.type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, vegetarian, calories, type);
  }

  @Override
  public String toString() {
    return "Dish{" +
        "name='" + name + '\'' +
        ", vegetarian=" + vegetarian +
        ", calories=" + calories +
        ", type=" + type +
        '}';
  }

  public enum Type {MEAT, FISH, OTHER}

}

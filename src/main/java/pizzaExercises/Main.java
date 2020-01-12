package pizzaExercises;

public class Main {
    public static void main(String[] args) {

        PizzaController pc = new PizzaController();
//        System.out.println(pc.getPizzasWithPrice());
//        System.out.println(pc.getCheapestSpicy());
//        System.out.println(pc.findMostExpensiveVegetarian());
//        pc.iLikeMeat().forEach(System.out::println);
//        System.out.println(pc.getPizzasWithMeatIngredients());
//        pc.groupByPrice().forEach((key, value) -> System.out.printf("%.2f zł | %s\n", key, value));
//        pc.groupByMeat().forEach((key, value) -> System.out.printf(
//                "%s | %s\n",
//                (key.equals(true) ? "mięsne" : "wege"), value));
//        pc.groupBySpicy().forEach(
//                (key, value) -> System.out.printf(
//                                "%s | %s \n",
//                                key.equals(true) ? "spicy" : "light",
//                                value));
//        System.out.println(pc.formatedMenu());
        System.out.println(pc.formatedMenuWithFilter(pc.findPizzasByNamePattern("c")));
    }
}

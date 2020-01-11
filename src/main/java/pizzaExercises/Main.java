package pizzaExercises;

public class Main {
    public static void main(String[] args) {

        PizzaController pc = new PizzaController();
        System.out.println(pc.getPizzasWithPrice());
        System.out.println(pc.getCheapestSpicy());
    }
}

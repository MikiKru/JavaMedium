package pizzaExercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class PizzaController {
    //    double calculatePizzaPice() - metoda cenę pizzy podanej w argumencie
    private double calculatePizzaPice(Pizza pizza) {
        return pizza.getIngredients().stream()              // Stream
                        .mapToDouble(Ingredient::getPrice)  // mapowanie składników na ceny
                        .sum();                             // sumuje ceny wszystkich składników danej pizzy
    }
    // String getPizzasPrice() - metoda zwracająca nazzy i ceny dla wszystkich pizz
    public String getPizzasWithPrice(){
        return Arrays.stream(Pizza.values()).                       // Stream
                map(pizza -> String.format(
                        "%s %.2f",
                        pizza.getName(),
                        calculatePizzaPice(pizza)))                  // mapowanie obiektu pizza na String
                .collect(Collectors.joining("\n"));          // zamiana na String z separatorem \n
    }
    // Pizza getChepestSpicy() - najtańsza pizza ostra
    public Pizza getCheapestSpicy(){
        return Arrays.stream(Pizza.values())                            // stream
                .filter(pizza -> pizza.getIngredients().stream()        
                                    .anyMatch(Ingredient::isSpicy))     // filtrowanie tylko pizz z składnikiem ostrym
                .sorted(Comparator.comparing(pizza -> calculatePizzaPice(pizza))) // sortowanie po sumie cen wszystkich składniów
                .findFirst()                                            // pobranie pierwszej pozycji Optional
                .get();                                                 // pobranie wartości
    }

    //    Pizza findMostExpensiveVegetarian() - metoda zwracająca najdroższą pizzę wegetariańską.

    //    List iLikeMeat() - metoda zwracająca same pizzę mięsne, posortowane malejąco po liczbie składników mięsnych.

    //    Map groupByPrice() - metoda grupujące pizzę po cenie.

    //    String formatedMenu() - metoda zwracająca string w postaci nazwa_pizzy: składnik1, składnik2, składnik3 - cena, kolejne pizzę oddzielone znakiem nowej linii.


}

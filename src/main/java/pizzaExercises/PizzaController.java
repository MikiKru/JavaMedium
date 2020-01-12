package pizzaExercises;

import java.util.*;
import java.util.stream.Collectors;

public class PizzaController {
    //    double calculatePizzaPice() - metoda cenę pizzy podanej w argumencie
    private double calculatePizzaPice(Pizza pizza) {
        return pizza.getIngredients().stream()              // Stream
                .mapToDouble(Ingredient::getPrice)  // mapowanie składników na ceny
                .sum();                             // sumuje ceny wszystkich składników danej pizzy
    }

    // String getPizzasPrice() - metoda zwracająca nazzy i ceny dla wszystkich pizz
    public String getPizzasWithPrice() {
        return Arrays.stream(Pizza.values()).                       // Stream
                map(pizza -> String.format(
                "%s %.2f",
                pizza.getName(),
                calculatePizzaPice(pizza)))                  // mapowanie obiektu pizza na String
                .collect(Collectors.joining("\n"));          // zamiana na String z separatorem \n
    }

    // Pizza getChepestSpicy() - najtańsza pizza ostra
    public Pizza getCheapestSpicy() {
        return Arrays.stream(Pizza.values())                            // stream
                .filter(pizza -> pizza.getIngredients().stream()
                        .anyMatch(Ingredient::isSpicy))     // filtrowanie tylko pizz z składnikiem ostrym
                .sorted(Comparator.comparing(pizza -> calculatePizzaPice(pizza))) // sortowanie po sumie cen wszystkich składniów
                .findFirst()                                            // pobranie pierwszej pozycji Optional
                .get();                                                 // pobranie wartości
    }

    //    Pizza findMostExpensiveVegetarian() - metoda zwracająca najdroższą pizzę wegetariańską.
    public Pizza findMostExpensiveVegetarian() {
        return Arrays.stream(Pizza.values())                                        // stream
                .filter(pizza -> pizza.getIngredients().stream()
                        .noneMatch(Ingredient::isMeat))                             // filtrowanie pizz nie zawierających składników miesnych
                .sorted(Comparator.comparing(this::calculatePizzaPice).reversed())  // sortowanie po cenie DESC
                .findFirst()                                                        // pobranie pierwszego elementu -> Optional
                .get();                                                             // pobranie wartości z optional
    }
    //    List iLikeMeat() - metoda zwracająca same pizzę mięsne, posortowane malejąco po liczbie składników mięsnych.
    public List iLikeMeat(){
        return Arrays.stream(Pizza.values())                                                        // stream
                            .filter(pizza -> pizza.getIngredients().stream()
                                                .anyMatch(Ingredient::isMeat)                       // filtrowanie pizz miesnych
                            )
                            .sorted(Comparator.comparing(pizza -> pizza.getIngredients().stream()
                                                .filter(Ingredient::isMeat)                         // filtrowanie składników miesnych
                                                .count()                                            // zliczanie składników miesnych
                                )
                            )
//                            .sorted(Comparator.reverseOrder())                                      // kolejność odwrotna DESC
                            .collect(Collectors.toList());                                         // zapis do listy
    }
    // pizze wraz z ich składnikami mięsnymi
    public String getPizzasWithMeatIngredients(){
        return Arrays.stream(Pizza.values())                                            // stream
                        .map(pizza -> String.format(                                    // mapowanie pizzy na String
                                "%15s | %s",
                                pizza.getName(),                                        // pobranie nazwy pizzy
                                pizza.getIngredients().stream()                         // pobranie składników -> Stream
                                        .filter(Ingredient::isMeat)                     // filtrujemy składniki mięsne
                                        .map(Ingredient::getName)                       // mapujemy Ingedient na String
                                        .collect(Collectors.joining(", "))       // zapisujemy do String z separatorem ,
                                )
                        )
                        .collect(Collectors.joining("\n"));                     // zapis do String + \n
    }
    //    Map groupByPrice() - metoda grupujące pizzę po cenie.
    public Map groupByPrice(){
        return Arrays.stream(Pizza.values())
                    .collect(Collectors.groupingBy(this::calculatePizzaPice));         // grupowanie po kategorii
    }                                                                                  // Map<kategoria, Obiekt>
    // grupowanie pizz po typie składników mięsne bez mięsne
    public Map groupByMeat(){
        return Arrays.stream(Pizza.values())
                .collect(Collectors.groupingBy(pizza -> pizza.getIngredients().stream()
                                .anyMatch(Ingredient::isMeat)
                ));         // grupowanie po kategorii
    }
    // grupowanie pizz po ostrości składników -> ostra | łagodna
    public Map groupBySpicy(){
        return Arrays.stream(Pizza.values())
                .collect(Collectors.groupingBy(pizza -> pizza.getIngredients().stream()
                        .anyMatch(Ingredient::isSpicy)
                ));         // grupowanie po kategorii
    }
    //    String formatedMenu() - metoda zwracająca string w postaci
    //    nazwa_pizzy: składnik1, składnik2, składnik3 - cena, kolejne pizzę oddzielone znakiem nowej linii.
    //    gdy pizza jest ostra dopisz po składnikach komantarz ostra
    //    gdy pizza jest wegetariańska dopisz komentarz wege
    public String formatedMenu(){
        // zaczynamy od wylosowania pizzy dnia
        Pizza discountPizza = randomGeneratedPizza();
        return Arrays.stream(Pizza.values())                                    // stream
                .map(pizza -> String.format(                                    // mapowanie pizzy na String
                        "%12s : %-90s | %5s | %4s | %.2f zł %1s",
                        pizza.getName(),                                        // pobranie nazwy pizzy
                        pizza.getIngredients().stream()                         // pobranie składników -> Stream
                                .map(Ingredient::getName)                       // mapujemy Ingedient na String
                                .collect(Collectors.joining(", ")),      // zapisujemy do String z separatorem ,
                        isSpicyPizza(pizza),
                        isVegePizza(pizza),
                        calculatePizzaPice(pizza),
                        discountPizza.getName().equals(pizza.getName()) ? "*" : ""
                        )
                )
                .collect(Collectors.joining("\n"));
    }
    // losowo wybrana pizza dnia była przeceniona o 30%
    private Pizza randomGeneratedPizza(){
        Random random = new Random();
        // odwołanie do elementu tablicy Pizza.values() -> Pizza[]
        // random.nextInt(bound) -> 0 - bound -1
        // random.nextInt(Pizza.values().length) - (0 - length - 1)
        return Pizza.values()[random.nextInt(Pizza.values().length)];        // bound = 5 -> 0 - 4
    }
    private String isSpicyPizza(Pizza pizza){
        return pizza.getIngredients().stream().anyMatch(Ingredient::isSpicy) ? "ostra" : "";
    }
    private String isVegePizza(Pizza pizza){
        return pizza.getIngredients().stream().noneMatch(Ingredient::isMeat) ? "wege" : "";
    }

//    private Pizza setDiscount(Pizza pizza){
//        pizza
//        return
//    }

}

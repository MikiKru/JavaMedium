package lambdaBasic;

import java.text.NumberFormat;
import java.util.Comparator;
import java.util.Locale;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

// klasa implementująca metody wykorzystujące wyrażenia lambda i stream API
public class ProjectController {

    // metoda wypisująca wszystkie projekty
    public void getAllProjects(){
        InMemoryDB.projects.stream()                                        // zamiana listy na stream
                        .forEach(project -> System.out.println(project));   // metoda końcąca forEach()
//        InMemoryDB.projects.forEach(System.out::println);                 // to samo co wyżej
    }
    public void getProjectsAcronimAndBudget(){
        Locale locale = new Locale("pl", "PL");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        InMemoryDB.projects.stream()
                .forEach(project -> System.out.printf(
                        "Nazwa: %-30s Budżet: %15s\n",
                        project.getAcronim(), currencyFormatter.format(project.getBudget())));
    }
    // metoda zwracająca listę projektów posortowanych po budżecie max-min
    public List<Project> getAllProjectsOrderByBudgetDesc(){
        return InMemoryDB.projects.stream()                                   // zamiana List na Stream
                .sorted(Comparator.comparing(Project::getBudget).reversed())  // sortowanie po budżecie DESC
                .collect(Collectors.toList());                                // zamiana Stream na List
    }
    // metoda zwracającą listę projektów zawierających katerogię podaną w argumencie metody posortowanych po budżecie max-min
    public List<Project> getAllProjectsContainsCategoryOrderByBudgetDesc(Category category){
        return InMemoryDB.projects.stream()                                   // zamiana List na Stream
                .filter(project -> project.getCategories().contains(category))// filtrowanie po kategorii występującej w liście kategorii
                .sorted(Comparator.comparing(Project::getBudget).reversed())  // sortowanie po budżecie DESC
                .collect(Collectors.toList());                                // zamiana Stream na List
    }
    // metoda zawacająca listę projektów posiadających podana w argumencie Listę kategorii
    public List<Project> getAllProjectsWithCategoriesOrderByBudgetDesc(List<Category> categories){
        return InMemoryDB.projects.stream()                                   // zamiana List na Stream
                .filter(project -> project.getCategories().equals(categories))// filtrowanie po kategorii występującej w liście kategorii
                .sorted(Comparator.comparing(Project::getBudget).reversed())  // sortowanie po budżecie DESC
                .collect(Collectors.toList());                                // zamiana Stream na List
    }
    // metoda zwracająca sumę całkowitego dofinansowania wszystkich projektów
    public double sumAllProjectFounds(){
        return InMemoryDB.projects.stream()                       // zamiana listy obiektów na stream
                .mapToDouble(Project::getProjectFounds)           // mapowanie każdego obiektu na wartość dofinansowania (double)
                .sum();
    }
    // oblicz średnie dofinansowanie projektów zawierających kategorie podaną w argumencie
    public double avgProjectsFoundsContainsCategory(Category category){
        OptionalDouble avgOptional= InMemoryDB.projects.stream()
                .filter(project -> project.getCategories().contains(category))
                .mapToDouble(Project::getProjectFounds)
                .average();                                                             // Optional<Double
        return avgOptional.isPresent() ? avgOptional.getAsDouble() : 0;                 // Double
    }
    // metoda wypisująca nazwę projektu ilość kategorii oraz nazwy kategorii wypisane po przecinku
    public String getAllProjectsFormatted(){
        return InMemoryDB.projects.stream()                         // zamiana listy projektów na Stream
                .map(project -> String.format("%30s | %2d | %s ",         // mapowanie obiektów z listy do napisu
                        project.getAcronim(),
                        project.getCategories().stream()            // zamiana listy kategorii na stream
                                                    .count(),       // zliczenie kategorii -> long
                        project.getCategories().stream()            // zamiana listy kategorii na stream
                                .map(Enum::name)                    // mapowanie nazwy kategorii
                                .collect(Collectors.joining(", "))  // zamiana listy na String z separatorem ","
                        )
                )
                .collect(Collectors.joining("\n"));          // zamiana stream na String
    }
    // metoda zwracająca projekt z największą liczbą pracowników
    public Project getProjectWithMaxEmployees(){
        return InMemoryDB.projects.stream()
                    .sorted(Comparator.comparing(Project::getNoEmployees).reversed())   // sortowanie projektów po noEmplyees DESC
                    .findFirst()                    // zawarca Optional
                    .get();                         // pobiera wartość z Optional
    }
    // sprawdź czy projekt o podanej nazwie istnieje
    public boolean existsProject(String acronim){
        return InMemoryDB.projects.stream()
                .anyMatch(project -> project.getAcronim().toUpperCase().equals(acronim.toUpperCase()));
    }

}

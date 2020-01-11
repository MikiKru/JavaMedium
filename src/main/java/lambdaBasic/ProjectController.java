package lambdaBasic;

import java.text.NumberFormat;
import java.util.Comparator;
import java.util.Locale;
import java.util.List;
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

}

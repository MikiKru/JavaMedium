package lambdaBasic;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ProjectController pc = new ProjectController();
//        pc.getAllProjects();
//        pc.getProjectsAcronimAndBudget();
//        pc.getAllProjectsOrderByBudgetDesc().forEach(System.out::println);
//        pc.getAllProjectsContainsCategoryOrderByBudgetDesc(Category.IT).forEach(System.out::println);
//        pc.getAllProjectsWithCategoriesOrderByBudgetDesc(Arrays.asList(Category.FINANCE, Category.IT)).forEach(System.out::println);
//        System.out.printf("Całkowite dofinansowanie: %20.2f PLN", pc.sumAllProjectFounds());
//        Category category = Category.IT;
//        System.out.printf("Srednie dofinansowanie projektów w kategorii %s: %20.2f PLN",
//                category,
//                pc.avgProjectsFoundsContainsCategory(category));
//        System.out.println(pc.getAllProjectsFormatted());
//        System.out.println(pc.getProjectWithMaxEmployees());
        System.out.println(pc.existsProject("smartcity"));
    }
}

package lambdaBasic;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ProjectController pc = new ProjectController();
//        pc.getAllProjects();
//        pc.getProjectsAcronimAndBudget();
//        pc.getAllProjectsOrderByBudgetDesc().forEach(System.out::println);
//        pc.getAllProjectsContainsCategoryOrderByBudgetDesc(Category.IT).forEach(System.out::println);
        pc.getAllProjectsWithCategoriesOrderByBudgetDesc(Arrays.asList(Category.FINANCE, Category.IT))
                .forEach(System.out::println);

    }
}

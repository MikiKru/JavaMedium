package lambdaBasic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface InMemoryDB {
    // tylko metody publiczne i abstrakcyjne
    void dbConnection();
    // pola statyczne
    List<Project> projects = new ArrayList<>(
            Arrays.asList(
                    new Project("SmartCity", 1_500_000, 15, 85,
                    new ArrayList<>(Arrays.asList(Category.IT, Category.ENGINEERING, Category.TELECOMMUNICATION))),
                    new Project("ThermoNuclearCar",40_000_000,250,85.00,Arrays.asList(Category.ENGINEERING)),
                    new Project("Formula 1 Poslish Racing Team", 5_000_000, 25, 65, new ArrayList<>(Arrays.asList(Category.ENGINEERING))),
                    new Project("BetterThanSmartCity", 1_200_00, 100, 90, new ArrayList<>(Arrays.asList(Category.IT))),
                    new Project("CleanAir", 4_000_000, 25,95, new ArrayList<>(Arrays.asList(Category.EDUCATION))),
                    new Project("DebtCollection",2_000_000, 6, 100, new ArrayList<>(Arrays.asList(Category.FINANCE, Category.IT))),
                    new Project ("EgzoSkeleton", 6000000, 50, 50,new ArrayList<>(Arrays.asList(Category.ENGINEERING, Category.ELECTRONICS, Category.IT))),
                    new Project ("Java", 20000,20,50, new ArrayList<>(Arrays.asList(Category.IT))
            )
    );
    // metody statyczne
    static int getSize(){
        return projects.size();
    }
    // pole stałe
    double PI = 3.14;
}

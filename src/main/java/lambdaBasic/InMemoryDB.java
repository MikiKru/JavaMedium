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
                            new ArrayList<>(Arrays.asList(Category.IT, Category.ENGINEERING, Category.TELECOMMUNICATION)))
            )
    );
    // metody statyczne
    static int getSize(){
        return projects.size();
    }
    // pole stałe
    double PI = 3.14;
}

package lambdaBasic;
import lombok.*;

import java.util.List;
// klasa modelu

//@Getter                         // dodaje gettery
//@Setter                         // dodaje settery
//@ToString                       // dodatje metodę toString
@AllArgsConstructor               // dodaje konstruktor implementujący wszystkie pola
@Data                             // dodaje gettery settery i metodę toString
public class Project {
    private String acronim;
    private double budget;
    private int noEmployees;
    private double percentOfFounds;
    private List<Category> categories;

    public double getProjectFounds(){
        return budget * (percentOfFounds / 100);
    }
}

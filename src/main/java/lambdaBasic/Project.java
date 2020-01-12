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

//    private Boolean objectFlag;
//    private boolean primitiveFlag;
//
//    public boolean isPrimitiveFlag() {
//        return primitiveFlag;
//    }
//
//    public void setPrimitiveFlag(boolean primitiveFlag) {
//        this.primitiveFlag = primitiveFlag;
//    }
//
//    public Boolean getObjectFlag() {
//        return objectFlag;
//    }
//
//    public void setObjectFlag(Boolean objectFlag) {
//        this.objectFlag = objectFlag;
//    }
}

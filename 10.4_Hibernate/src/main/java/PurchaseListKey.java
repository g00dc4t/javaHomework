import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Data
public class PurchaseListKey implements Serializable {

    @Column(name = "student_name")
    private String student;

    @Column(name = "course_name")
    private String course;
}

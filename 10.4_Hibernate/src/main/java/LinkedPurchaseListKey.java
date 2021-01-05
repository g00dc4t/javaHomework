import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LinkedPurchaseListKey implements Serializable {

    @Column(name = "student_id")
    private Integer student;

    @Column(name = "course_id")
    private Integer course;
}

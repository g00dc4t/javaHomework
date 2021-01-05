import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Data
public class SubscriptionKey implements Serializable {

    @Column(name = "student_id")
    private Integer student;

    @Column(name = "course_id")
    private Integer course;
}



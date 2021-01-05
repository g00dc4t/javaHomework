import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Data
@AllArgsConstructor
public class SubscriptionID implements Serializable {

    @ManyToOne//(fetch = FetchType.LAZY)//(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne//(fetch = FetchType.LAZY)//(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;
}



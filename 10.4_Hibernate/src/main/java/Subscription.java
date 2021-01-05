import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "subscriptions")
public class Subscription {

    @EmbeddedId
    private SubscriptionKey subscriptionKey;

    @Column(name = "subscription_date")
    private Date subscriptionDate;
}

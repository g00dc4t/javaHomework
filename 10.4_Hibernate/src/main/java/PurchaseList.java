import lombok.Data;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "purchaselist")
public class PurchaseList {

    @EmbeddedId
    private PurchaseListKey purchaseListKey;

    private Integer price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;
}

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "linkedpurchaselist")
public class LinkedPurchaseList {

    @EmbeddedId
    private LinkedPurchaseListKey linkedPurchaseListKey;
}


package payment.model;

import java.util.List;
import lombok.Data;

@Data
@SuppressWarnings("unused")
public class ItemList {

    private List<Item> items;
    private ShippingAddress shippingAddress;

}

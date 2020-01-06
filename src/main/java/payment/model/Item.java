
package payment.model;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Item {

    private String currency;
    private String description;
    private String name;
    private String price;
    private String quantity;
    private String sku;
    private String tax;

}

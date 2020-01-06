
package payment.model;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Details {

    private String handlingFee;
    private String insurance;
    private String shipping;
    private String shippingDiscount;
    private String subtotal;
    private String tax;

}

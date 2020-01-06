
package payment.model;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Amount {

    private String currency;
    private Details details;
    private String total;

}

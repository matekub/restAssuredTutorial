
package payment.model;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class ShippingAddress {

    private String city;
    private String countryCode;
    private String line1;
    private String line2;
    private String phone;
    private String postalCode;
    private String recipientName;
    private String state;

}


package payment.model;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Transaction {

    private Amount amount;
    private String custom;
    private String description;
    private String invoiceNumber;
    private ItemList itemList;
    private PaymentOptions paymentOptions;
    private String softDescriptor;

}

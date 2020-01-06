
package payment.model;

import java.util.List;
import lombok.Data;

@Data
@SuppressWarnings("unused")
public class Payment {

    private String intent;
    private String noteToPayer;
    private Payer payer;
    private RedirectUrls redirectUrls;
    private List<Transaction> transactions;

}

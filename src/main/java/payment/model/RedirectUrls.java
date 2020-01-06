
package payment.model;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class RedirectUrls {

    private String cancelUrl;
    private String returnUrl;

}

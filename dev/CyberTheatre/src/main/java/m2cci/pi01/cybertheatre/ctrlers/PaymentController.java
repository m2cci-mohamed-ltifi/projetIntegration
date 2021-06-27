package m2cci.pi01.cybertheatre.ctrlers;

import org.springframework.web.bind.annotation.RestController;
import java.nio.file.Paths;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.post;
import static spark.Spark.port;
import static spark.Spark.staticFiles;

import com.google.gson.Gson;

import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

/**
 *
 * @author Ltifi
 */
@RestController
public class PaymentController {

    /*@PostMapping("/create-payment-intent")
    public void createPaymentIntent() {
        response.type("application/json");
        CreatePayment postBody = gson.fromJson(request.body(), CreatePayment.class);
        PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder().setCurrency("usd").setAmmount(new Long(calculateOrderAmmount(postBody.getItems()))).build();
        PaymentIntent intent =PaymentIntent.create(createParams);
        createPaymentResponse = new CreatePaymentResponse(intent.getClientSecret());
        return gson.toJson(paymentResponse);
    }*/
    private static Gson gson = new Gson();

  public static void main(String[] args) {
    port(4242);

    // This is your real test secret API key.
    Stripe.apiKey = "sk_test_51J6CxVCkLlQznzQ3htZHKiG1J176B81eZGXOHOnsF8191pYzGTs4pBciI77ei0F53xIqGrmrEiA7pNGD4O4dTyvI008GRHZDtW";

    staticFiles.externalLocation(
        Paths.get("").toAbsolutePath().toString());

    
    post("/create-checkout-session", (request, response) -> {
        response.type("application/json");

        final String YOUR_DOMAIN = "http://localhost:4242";
        SessionCreateParams params =
          SessionCreateParams.builder()
            .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
            .setMode(SessionCreateParams.Mode.PAYMENT)
            .setSuccessUrl(YOUR_DOMAIN + "/success.html")
            .setCancelUrl(YOUR_DOMAIN + "/cancel.html")
            .addLineItem(
              SessionCreateParams.LineItem.builder()
                .setQuantity(1L)
                .setPriceData(
                  SessionCreateParams.LineItem.PriceData.builder()
                    .setCurrency("usd")
                    .setUnitAmount(2000L)
                    .setProductData(
                      SessionCreateParams.LineItem.PriceData.ProductData.builder()
                        .setName("Stubborn Attachments")
                        .build())
                    .build())
                .build())
            .build();
      Session session = Session.create(params);
      HashMap<String, String> responseData = new HashMap<String, String>();
      responseData.put("id", session.getId());
      return gson.toJson(responseData);
    });
  }

}

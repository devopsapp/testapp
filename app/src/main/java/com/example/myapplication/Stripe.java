//package com.example.myapplication;
//
//import android.os.Bundle;
//import android.os.StrictMode;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.View;
//import android.widget.Toast;
//
//import com.stripe.android.TokenCallback;
//import com.stripe.android.model.Card;
//import com.stripe.android.model.Token;
//import com.stripe.android.view.CardMultilineWidget;
//import com.stripe.model.Charge;
//import com.stripe.model.Customer;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Stripe {
//
//    package com.example.myapplication;
//
//import android.os.StrictMode;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Toast;
//
//import com.stripe.android.Stripe;
//import com.stripe.android.TokenCallback;
//import com.stripe.android.exception.APIConnectionException;
//import com.stripe.android.exception.APIException;
//import com.stripe.android.exception.AuthenticationException;
//import com.stripe.android.exception.CardException;
//import com.stripe.android.exception.InvalidRequestException;
//import com.stripe.android.model.Card;
//import com.stripe.android.model.Token;
//import com.stripe.android.view.CardMultilineWidget;
//import com.stripe.model.BankAccount;
//import com.stripe.model.Charge;
//import com.stripe.model.Customer;
//import com.stripe.model.Transfer;
//
//import java.util.HashMap;
//import java.util.Map;
//
//    public class MainActivity extends AppCompatActivity {
//
//        CardMultilineWidget mCardMultilineWidget;
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_main);
//
//            if (android.os.Build.VERSION.SDK_INT > 9) {
//                StrictMode.ThreadPolicy policy =
//                        new StrictMode.ThreadPolicy.Builder().permitAll().build();
//                StrictMode.setThreadPolicy(policy);
//            }
//
//            mCardMultilineWidget = (CardMultilineWidget) findViewById(R.id.card_multiline_widget);
//
//            final com.stripe.android.Stripe stripe = new com.stripe.android.Stripe(getApplicationContext());
//            stripe.setDefaultPublishableKey("pk_test_W8SfnQTCA4Tf4Puwj1O5xRX000jnzEooa1");
//            com.stripe.Stripe.apiKey = "sk_test_tkGctHUZtH516zxOuPJ1gGKk00mchkuFvT";
//
//            findViewById(R.id.checkout_card).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Card cardToSave = mCardMultilineWidget.getCard();
//
//                    if (cardToSave == null) {
//                        Log.d("Error Log : ", "Invalid Card Data");
//                        return;
//                    } else {
//                        stripe.createToken(
//
//                                new Card(cardToSave.getNumber(), cardToSave.getExpMonth(), cardToSave.getExpYear(), cardToSave.getCVC()),
//                                new TokenCallback() {
//                                    public void onSuccess(Token token) {
//                                        Log.d("Error Log : ", token.getId().toString());
//
//                                        // Charge the Customer instead of the card:
//                                        Map<String, Object> params = new HashMap<>();
//                                        params.put("amount", 100);
//                                        params.put("currency", "usd");
//                                        params.put("description", "test charge");
////                                    params.put("source",token);
//                                        params.put("customer", "cus_EojPoDPbyd715V");
//
//                                        Map<String, String> metadata = new HashMap<>();
//                                        metadata.put("name", "sami");
//                                        params.put("metadata", metadata);
//
//                                        // Create a Customer:
//                                        Map<String, Object> customerParams = new HashMap<String, Object>();
//                                        customerParams.put("email", "paying.user@example.com");
//                                        customerParams.put("description", "Example charge");
//                                        customerParams.put("account_balance", 10000);
//                                        customerParams.put("source", token.getId());
//                                        customerParams.put("balance", 10000);
//
//
//
//                                        try {
//
//                                            Customer customer = Customer.create(customerParams);
//                                            Charge charge = Charge.create(params);
//
//                                            Toast.makeText(com.example.myapplication.MainActivity.this, "Done Transaction", Toast.LENGTH_LONG).show();
//                                        } catch (Exception e) {
//                                            Toast.makeText(com.example.myapplication.MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                                        }
//                                    }
//
//                                    public void onError(Exception error) {
//                                        Toast.makeText(getApplicationContext(),
//                                                error.getLocalizedMessage(),
//                                                Toast.LENGTH_LONG).show();
//                                    }
//                                }
//                        );
//
//                    }
//
//                }
//            });
//
//        }
//    }
//}
//

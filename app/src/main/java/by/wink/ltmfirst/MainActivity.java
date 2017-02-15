package by.wink.ltmfirst;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by amine on 06/02/17.
 */

public class MainActivity extends Activity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    TextView phoneNumberTV;
    Button callBtn, shareBtn;
    private TextView addressTV, emailTextView;
    Intent intent;
    String email = "";
    static LinearLayout layout;


    // recyclerView items
    RecyclerView businessCardsRV;
    LinearLayoutManager layoutManager;
    BusinessCardAdapter adapter;

    // constants
    private static final String ELIS_ADDRESS = "via Sandro Sandri 71";
    private static final String LTM_COURSE = "LTM 11";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main);
        layout = (LinearLayout) findViewById(R.id.main_layout);
        intent = getIntent();

        if (intent.getStringExtra(LoginActivity.EMAIL_KEY) != null) {
            email = intent.getStringExtra(LoginActivity.EMAIL_KEY);
        } else {
            String action = intent.getAction();
            if (Intent.ACTION_SEND.equals(action)) {
                email = intent.getStringExtra(Intent.EXTRA_TEXT);

            }

        }

        businessCardsRV = (RecyclerView) findViewById(R.id.business_cards_rv);
        layoutManager = new LinearLayoutManager(this);
        adapter = new BusinessCardAdapter();
        businessCardsRV.setLayoutManager(layoutManager);
        businessCardsRV.setAdapter(adapter);

//        emailTextView = (TextView)findViewById(R.id.email_text_view);
//        emailTextView.setText(email);
//        phoneNumberTV = (TextView)findViewById(R.id.phone_numberTV);
//        addressTV = (TextView)findViewById(R.id.address_textView);
//        callBtn = (Button) findViewById(R.id.call_btn);
//        shareBtn = (Button) findViewById(R.id.share_btn);
//        callBtn.setOnClickListener(this);
//        shareBtn.setOnClickListener(this);
//        findViewById(R.id.send_mail_btn).setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

//        if (view.getId() == R.id.call_btn) {
//            Intent intent = new Intent();
//
//            intent.setAction(Intent.ACTION_VIEW);
//            Uri uri = Uri.parse("tel:" + phoneNumberTV.getText().toString());
//            intent.setData(uri);
//            startActivity(intent);
//
//        } else if (view.getId() == R.id.share_btn) {
//
//            Intent intent = new Intent();
//            intent.setAction(Intent.ACTION_VIEW);
//            Uri uri = Uri.parse("geo:0,0?q=" + addressTV.getText().toString());
//            intent.setData(uri);
//            startActivity(intent);
//
//        } else if (view.getId() == R.id.send_mail_btn) {
//            Intent intent = new Intent();
//            intent.setAction(Intent.ACTION_SEND);
//            intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.email_text));
//            intent.setType("text/plain");
//            startActivity(intent);
//
//        }

    }

    public static void  showSnackBar(String name){

        Snackbar snackbar = Snackbar.make(layout,name,Snackbar.LENGTH_SHORT);
        snackbar.setAction("OK", new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        snackbar.show();

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
        adapter.setDataSet(getBusinessCards());

    }


    private ArrayList<BusinessCard> getBusinessCards() {
        ArrayList<BusinessCard> businessCards = new ArrayList<>();
        BusinessCard francescoBC = new BusinessCard("Francesco Cipolla", "francescocpll@gmail.com", "333281213", LTM_COURSE, ELIS_ADDRESS);
        BusinessCard matteoBC = new BusinessCard("Matteo Manfreda", "manfredamatteo44@gmail.com", "348974379", LTM_COURSE, ELIS_ADDRESS);
        BusinessCard micheleBC = new BusinessCard("Michele Foderaro", "michele.foderaro@virgilio.it", "3891379123", LTM_COURSE, ELIS_ADDRESS);
        BusinessCard domenicoBC = new BusinessCard("Domenico Licciardi", "licciardi.domenico98@gmail.com", "333281213", LTM_COURSE, ELIS_ADDRESS);
        BusinessCard gaetanoBC = new BusinessCard("Gaetano Ciccone", "gaetano.ciccone97@gmail.com", "333281213", LTM_COURSE, ELIS_ADDRESS);

        businessCards.add(francescoBC);
        businessCards.add(matteoBC);
        businessCards.add(micheleBC);
        businessCards.add(domenicoBC);
        businessCards.add(gaetanoBC);

        return businessCards;


    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");

    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");

    }
}

package by.wink.ltmfirst;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by amine on 06/02/17.
 */

public class MainActivity extends Activity implements View.OnClickListener{

    private static final String TAG = "MainActivity";

    TextView phoneNumberTV;
    Button callBtn,shareBtn;
    private TextView addressTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumberTV = (TextView)findViewById(R.id.phone_numberTV);
        addressTV = (TextView)findViewById(R.id.address_textView);

        callBtn = (Button) findViewById(R.id.call_btn);
        shareBtn = (Button) findViewById(R.id.share_btn);
        callBtn.setOnClickListener(this);
        shareBtn.setOnClickListener(this);
        findViewById(R.id.send_mail_btn).setOnClickListener(this);
        Log.d(TAG,"onCreate");
    }



    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.call_btn){
            Intent intent = new Intent();

            intent.setAction(Intent.ACTION_VIEW);
            Uri uri = Uri.parse("tel:"+phoneNumberTV.getText().toString());
            intent.setData(uri);
            startActivity(intent);

        }else if(view.getId() == R.id.share_btn){

            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            Uri uri = Uri.parse("geo:0,0?q=" + addressTV.getText().toString());
            intent.setData(uri);
            startActivity(intent);

        }else if(view.getId() == R.id.send_mail_btn){
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT,getString(R.string.email_text));
            intent.setType("text/plain");
            startActivity(intent);

        }

    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");

    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");

    }
}

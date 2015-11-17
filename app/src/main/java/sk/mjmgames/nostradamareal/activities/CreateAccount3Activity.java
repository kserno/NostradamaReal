package sk.mjmgames.nostradamareal.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.prefs.Preferences;

import sk.mjmgames.nostradamareal.R;

/**
 * Created by Filip on 27.7.2015.
 */
public class CreateAccount3Activity extends Activity implements View.OnClickListener {

    private CheckBox cbAgreement;
    private Button btRegister;
    private ImageButton ibBack2;
    private TextView tvTerms;

    private static final String PREFS_FILENAME = "sk.mjmgames.nostramareal.PREFS_FILE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account3);
        initWidgets();

    }

    private void initWidgets() {
        cbAgreement = (CheckBox) findViewById(R.id.cbAgreement);
        btRegister = (Button) findViewById(R.id.btRegister);
        btRegister.setOnClickListener(this);
        tvTerms = (TextView) findViewById(R.id.tvTerms);
        tvTerms.setText(Html.fromHtml(getResources().getString(R.string.agreement_link)));
        tvTerms.setMovementMethod(LinkMovementMethod.getInstance());
        //ibBack2 = (ImageButton) findViewById();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btRegister:
                if (cbAgreement.isChecked()) {
                    SharedPreferences prefs= getSharedPreferences(PREFS_FILENAME,Context.MODE_PRIVATE);
                    SharedPreferences.Editor spEditor = prefs.edit();
                    spEditor.putInt("used", 1);
                    spEditor.commit();
                    startActivity(new Intent(this, MainActivity.class));
                }
                break;
            /*case R.id. ibBack
               //     finish();
                break;
            */
        }
    }

    public class RegisterTask extends AsyncTask<String, String, Boolean> {

        private Context context;
        private ProgressDialog progressDialog;

        public RegisterTask(Context context) {
            this.context = context;
        }


        @Override
        protected Boolean doInBackground(String... params) {
            return false;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(context);
            progressDialog.setMessage(context.getResources().getString(R.string.account_register));
            progressDialog.setCancelable(false);
            progressDialog.show();

        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            progressDialog.dismiss();
        }
    }
}

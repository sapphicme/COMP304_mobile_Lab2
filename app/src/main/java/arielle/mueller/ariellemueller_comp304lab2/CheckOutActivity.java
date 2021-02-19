package arielle.mueller.ariellemueller_comp304lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CheckOutActivity extends AppCompatActivity {

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        SharedPreferences myPref = getSharedPreferences("info", MODE_PRIVATE);
        boolean apartment1state = myPref.getBoolean("apartment1state", false);
        boolean apartment2state = myPref.getBoolean("apartment2state", false);

        boolean condo1state = myPref.getBoolean("condo1state", false);
        boolean condo2state = myPref.getBoolean("condo2state", false);

        boolean det1state = myPref.getBoolean("det1state", false);
        boolean det2state = myPref.getBoolean("det2state", false);

        boolean semidet1state = myPref.getBoolean("semidet1state", false);
        boolean semidet2state = myPref.getBoolean("semidet2state", false);

        boolean town1state = myPref.getBoolean("town1state", false);
        boolean town2state = myPref.getBoolean("town2state", false);

        boolean options_exist = false;
        RadioGroup rg = (RadioGroup) findViewById(R.id.radiohomes);

        //checking the check boxes to see if adding a radio button is required

        if (apartment1state){
            RadioButton rb1 = new RadioButton(this);
            rb1.setText(R.string.apartment1);
            rb1.setId(1);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            rg.addView(rb1, params);
            options_exist = true;
        }

        if(apartment2state){
            RadioButton rb2 = new RadioButton(this);
            rb2.setText(R.string.apartment2);
            rb2.setId(2);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            rg.addView(rb2, params);
            options_exist = true;
        }

        if(condo1state){
            RadioButton rb3 = new RadioButton(this);
            rb3.setText(R.string.condo1);
            rb3.setId(3);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            rg.addView(rb3, params);
            options_exist = true;
        }

        if(condo2state){
            RadioButton rb4 = new RadioButton(this);
            rb4.setText(R.string.condo2);
            rb4.setId(4);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            rg.addView(rb4, params);
            options_exist = true;
        }

        if(det1state){
            RadioButton rb5 = new RadioButton(this);
            rb5.setText(R.string.detached1);
            rb5.setId(5);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            rg.addView(rb5, params);
            options_exist = true;
        }

        if(det2state){
            RadioButton rb6 = new RadioButton(this);
            rb6.setText(R.string.detached2);
            rb6.setId(6);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            rg.addView(rb6, params);
            options_exist = true;
        }

        if(semidet1state){
            RadioButton rb7 = new RadioButton(this);
            rb7.setText(R.string.semi1);
            rb7.setId(7);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            rg.addView(rb7, params);
            options_exist = true;
        }

        if(semidet2state){
            RadioButton rb8 = new RadioButton(this);
            rb8.setText(R.string.semi2);
            rb8.setId(8);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            rg.addView(rb8, params);
            options_exist = true;
        }

        if(town1state){
            RadioButton rb9 = new RadioButton(this);
            rb9.setText(R.string.town1);
            rb9.setId(9);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            rg.addView(rb9, params);
            options_exist = true;
        }

        if(town2state){
            RadioButton rb10 = new RadioButton(this);
            rb10.setText(R.string.town2);
            rb10.setId(10);
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            rg.addView(rb10, params);
            options_exist = true;
        }

        if(!options_exist){
            Button PaymentButton = (Button) findViewById(R.id.paymentButton);
            PaymentButton.setVisibility(View.INVISIBLE);
        }


    }

    public void PaymentClick(View view){
        RadioGroup radioGroup = findViewById(R.id.radiohomes);
        int selectedId = radioGroup.getCheckedRadioButtonId();

        if(selectedId == -1){
            Toast.makeText(this, "You didn't choose any options!", Toast.LENGTH_SHORT).show();
        }
        else {
            RadioButton radioButton = (RadioButton) findViewById(selectedId);
            String chosenHome = (String) radioButton.getText();
            SharedPreferences myPreference =
                    getSharedPreferences("info", 0);
            SharedPreferences.Editor prefEditor = myPreference.edit();
            prefEditor.putString("chosenHome", chosenHome);
            prefEditor.commit();

            Intent intent = new Intent(this, PaymentActivity.class);
            startActivity(intent);
        }
    }

}
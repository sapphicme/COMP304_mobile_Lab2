package arielle.mueller.ariellemueller_comp304lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
    }

    public void onClickPayment(View view){
        RadioGroup radioGroup = findViewById(R.id.payment_options);

        int selectedId = radioGroup.getCheckedRadioButtonId();

        if(selectedId == -1){
            Toast.makeText(this, "You didn't choose and option", Toast.LENGTH_SHORT).show();

        }
        else{
            RadioButton radioButton = (RadioButton) findViewById(selectedId);
            String chosenPay = (String) radioButton.getText();

            SharedPreferences myPreference =
                    getSharedPreferences("info", 0);
            SharedPreferences.Editor prefEditor = myPreference.edit();
            prefEditor.putString("chosenPay", chosenPay);
            prefEditor.commit();

            Intent intent = new Intent(this, FinalOrderActivity.class);
            startActivity(intent);
        }
    }
}
package arielle.mueller.ariellemueller_comp304lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

import static arielle.mueller.ariellemueller_comp304lab2.R.id.apartment_one_check;
import static arielle.mueller.ariellemueller_comp304lab2.R.id.apartment_two_check;
import static arielle.mueller.ariellemueller_comp304lab2.R.id.radioApartmentOne;

public class ApartmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment);

        final CheckBox checkBoxOne = (CheckBox) findViewById(apartment_one_check);
        final RadioButton radioOne = (RadioButton) findViewById(radioApartmentOne);


        if(checkBoxOne.isChecked()){
            radioOne.setVisibility(View.VISIBLE);
        }
    }

}
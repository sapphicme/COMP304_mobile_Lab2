package arielle.mueller.ariellemueller_comp304lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import static arielle.mueller.ariellemueller_comp304lab2.R.id.apartment_one_check;
import static arielle.mueller.ariellemueller_comp304lab2.R.id.apartment_option;
import static arielle.mueller.ariellemueller_comp304lab2.R.id.apartment_two_check;
import static arielle.mueller.ariellemueller_comp304lab2.R.id.condo_option;
import static arielle.mueller.ariellemueller_comp304lab2.R.id.detached_options;
import static arielle.mueller.ariellemueller_comp304lab2.R.id.semi_options;

public class ApartmentActivity extends AppCompatActivity {
CheckBox apartment1checkbox, apartment2checkbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apartment);
        apartment1checkbox = findViewById(apartment_one_check);
        apartment2checkbox = findViewById(apartment_two_check);

    }

        public void saveCheck(View view){
            SharedPreferences myPreference = getSharedPreferences("info", 0);
            SharedPreferences.Editor prefEditor = myPreference.edit();
            boolean apartment1state = apartment1checkbox.isChecked();
            boolean apartment2state = apartment2checkbox.isChecked();
            prefEditor.putBoolean("apartment1state", apartment1state);
            prefEditor.putBoolean("apartment2state", apartment2state);
            prefEditor.commit();
            Toast.makeText(this, "added to checkout", Toast.LENGTH_SHORT).show();

        }

        public void checkoutPageOpen(View view){
            saveCheck(view);
            Intent intent = new Intent(this, CheckOutActivity.class);
            startActivity(intent);
            //in case user doesn't want to look at other home options
            //take them directly to checkout
        }

        // options menu

        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_example, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case apartment_option:
                    Intent intent1 = new Intent(this, ApartmentActivity.class);
                    startActivity(intent1);
                    break;
                case condo_option:
                    Intent intent2 = new Intent(this, CondoActivity.class);
                    startActivity(intent2);
                    break;
                case detached_options:
                    Intent intent3 = new Intent(this, DetachedHomeActivity.class);
                    startActivity(intent3);
                    break;
                case semi_options:
                    Intent intent4 = new Intent(this, SemiDetachedActivity.class);
                    startActivity(intent4);
                    break;
                case R.id.townhouse_option:
                    Intent intent5 = new Intent(this, TownHouseActivity.class);
                    startActivity(intent5);
                    break;
                default:
                    return super.onOptionsItemSelected(item);
            }
            return true;
        }

}
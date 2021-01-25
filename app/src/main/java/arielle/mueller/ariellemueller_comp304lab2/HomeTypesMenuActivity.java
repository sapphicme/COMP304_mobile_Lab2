package arielle.mueller.ariellemueller_comp304lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import static arielle.mueller.ariellemueller_comp304lab2.R.id.apartment_option;
import static arielle.mueller.ariellemueller_comp304lab2.R.id.condo_option;
import static arielle.mueller.ariellemueller_comp304lab2.R.id.detached_options;
import static arielle.mueller.ariellemueller_comp304lab2.R.id.semi_options;

public class HomeTypesMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_types_menu);
    }

    public void loadCheckOutPage(View view){
        Intent intent = new Intent(this, CheckOutActivity.class);
        startActivity(intent);
    }

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
                return true;
            case condo_option:
                Intent intent2 = new Intent(this, CondoActivity.class);
                startActivity(intent2);
                return true;
            case detached_options:
                Intent intent3 = new Intent(this, DetachedHomeActivity.class);
                startActivity(intent3);
                return true;
            case semi_options:
                Intent intent4 = new Intent(this, SemiDetachedActivity.class);
                startActivity(intent4);
                return true;
            case R.id.townhouse_option:
                Intent intent5 = new Intent(this, TownHouseActivity.class);
                startActivity(intent5);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
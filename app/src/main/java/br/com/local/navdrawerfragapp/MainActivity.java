package br.com.local.navdrawerfragapp;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MaterialToolbar toolbar = findViewById(R.id.idTopAppBar);
        DrawerLayout drawerLayout = findViewById(R.id.main);
        NavigationView navigationView = findViewById(R.id.navigation_view);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();
                menuItem.setChecked(true);
                drawerLayout.closeDrawer(GravityCompat.START);

                if (id == R.id.mNavHome) {
                    carregaFragment(new HomeFragment());
                }
                if (id == R.id.mNavMessage) {
                    carregaFragment(new MessageFragment());
                }
                if (id == R.id.mNavSynch) {
                    Toast.makeText(getApplicationContext(), "Click on Synch", Toast.LENGTH_SHORT).show();
                }
                if (id == R.id.mNavTrash) {
                    Toast.makeText(getApplicationContext(), "Click on Trash", Toast.LENGTH_SHORT).show();
                }
                if (id == R.id.mNavSettings) {
                    carregaFragment(new SettingsFragment());
                }
                if (id == R.id.mNavLogin) {
                    Toast.makeText(getApplicationContext(), "Click on Login", Toast.LENGTH_SHORT).show();
                }
                if (id == R.id.mNavShare) {
                    Toast.makeText(getApplicationContext(), "Click on Share", Toast.LENGTH_SHORT).show();
                }
                if (id == R.id.mNavRate) {
                    Toast.makeText(getApplicationContext(), "Click on Rate us", Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });
    }

    private void carregaFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.commit();
    }
}
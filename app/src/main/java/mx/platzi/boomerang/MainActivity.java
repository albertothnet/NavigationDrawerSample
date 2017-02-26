package mx.platzi.boomerang;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import org.litepal.LitePal;



public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private String drawerTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LitePal.initialize(this);
        setContentView(R.layout.activity_main);

        setToolbar(); // Setear Toolbar como action bar

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        drawerTitle = getResources().getString(R.string.home_item);
        if (savedInstanceState == null) {
            selectItem(drawerTitle);
        }

    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            // Poner ícono del drawer toggle
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }

    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // Marcar item presionado
                        menuItem.setChecked(true);
                        // Crear nuevo fragmento
                        String title = menuItem.getTitle().toString();
                        selectItem(title);
                        return true;
                    }
                }
        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void selectItem(String title) {
        // Enviar título como arguemento del fragmento

        if (title.equals("Nueva Operación"))
        {

            Intent i = new Intent(getBaseContext(), EnviaOperacion.class);
            //i.putExtra("PersonID", personID);
            startActivity(i);

            drawerLayout.closeDrawers(); // Cerrar drawer
            //setTitle(title); // Setear título actual

        }

        if (title.equals("Buscar Tarjeta"))
        {

            Intent i = new Intent(getBaseContext(), BuscaTarjeta.class);
            //i.putExtra("PersonID", personID);
            startActivity(i);

            drawerLayout.closeDrawers(); // Cerrar drawer
            //setTitle(title); // Setear título actual

        }

        if (title.equals("Consulta Saldo"))
        {

            Intent i = new Intent(getBaseContext(), ConsultaSaldo.class);
            //i.putExtra("PersonID", personID);
            startActivity(i);

            drawerLayout.closeDrawers(); // Cerrar drawer
            //setTitle(title); // Setear título actual

        }

        if (title.equals("Configuración")) {
            //SQLiteDatabase dbBoomerang = LitePal.getDatabase();

            Intent i = new Intent(getBaseContext(), ConfigActivity.class);
            //i.putExtra("PersonID", personID);
            startActivity(i);

            drawerLayout.closeDrawers(); // Cerrar drawer
            //setTitle(title); // Setear título actual
        }

        if (title.equals("Cerrar Sesión"))
        {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
    }

    @Override
    public void onBackPressed(){


    }


}

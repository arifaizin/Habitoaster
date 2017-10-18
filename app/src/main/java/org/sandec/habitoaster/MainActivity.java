package org.sandec.habitoaster;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.sandec.habitoaster.utils.Analytics;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FirebaseAuth mAuth;
    private FirebaseUser firebaseUser;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager manajer = getSupportFragmentManager();
        manajer.beginTransaction()
                .replace(R.id.layout_untuk_fragment, new HomeFragment())
                .commit();

        mAuth=FirebaseAuth.getInstance();
        extractUserData();
    }

    private void extractUserData() {
        firebaseUser = mAuth.getCurrentUser();
        String userId = firebaseUser.getUid();

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mFirebaseAnalytics.setUserProperty("user_id", "userId");
        mFirebaseAnalytics.setCurrentScreen(this, "Main Activity", null /* class override */);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            Analytics.logEventSelectContent("Nav drawer 1", "Home", "menu item", mFirebaseAnalytics);
            FragmentManager manajer = getSupportFragmentManager();
            manajer.beginTransaction()
                    .replace(R.id.layout_untuk_fragment, new HomeFragment())
                    .commit();
        } else if (id == R.id.nav_add) {
            Analytics.logEventSelectContent("Nav drawer 2", "Add habit", "menu item", mFirebaseAnalytics);
            Intent i = new Intent(MainActivity.this,AddHabitActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_today) {
            Analytics.logEventSelectContent("Nav drawer 3", "Target today", "menu item", mFirebaseAnalytics);

        } else if (id == R.id.nav_reward) {
            Analytics.logEventSelectContent("Nav drawer 4", "Reward", "menu item", mFirebaseAnalytics);
            FragmentManager manajer = getSupportFragmentManager();
            manajer.beginTransaction()
                    .replace(R.id.layout_untuk_fragment, new RewardFragment())
                    .commit();
        } else if (id == R.id.nav_share) {
            Analytics.logEventSelectContent("Nav drawer 5", "Share", "menu item", mFirebaseAnalytics);

        } else if (id == R.id.nav_send) {
            Analytics.logEventSelectContent("Nav drawer 6", "Send", "menu item", mFirebaseAnalytics);

        } else if (id == R.id.logout) {
            Analytics.logEventSelectContent("Nav drawer 7", "Log out", "menu item", mFirebaseAnalytics);
            mAuth.signOut();
            Intent i = new Intent(MainActivity.this,LoginACtivity.class);
            startActivity(i);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}

package com.example.ieeehmr;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;

public class HOME extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private MenuItem item;

    List<ListItem> listItem;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RecyclerView recyclerView =  findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the list
        listItem = new ArrayList<>();

        //adding some items to our list
        listItem.add(
                new ListItem(
                        R.color.white,
                        R.drawable.events,
                        "EVENTS"
                ));

        listItem.add(
                new ListItem(
                        R.color.white,
                        R.drawable.achivements,
                        "ACHIVEMENTS"
                ));

        listItem.add(
                new ListItem(
                        R.color.white,
                        R.drawable.projects,
                        "PROJECTS"
                ));

        listItem.add(
                new ListItem(
                        R.color.white,
                        R.drawable.activities,
                        "ACTIVITIES"
                ));



        //creating recyclerview adapter
        ListAdapter adapter = new ListAdapter(this, listItem);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ViewPager viewPager=findViewById(R.id.viewPager);

        ImageAdapter imageAdapter=new ImageAdapter(this);
        viewPager.setAdapter(imageAdapter);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView =findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
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
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        this.item = item;
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            startActivity(new Intent(this,HOME.class));
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            startActivity(new Intent(this,IEEE_BENIFITS.class));

        } else if (id == R.id.nav_slideshow) {
            startActivity(new Intent(this,EVENTS_AND_ACTIVITIES.class));

        } else if (id == R.id.nav_manage) {

            startActivity(new Intent(this,ABOUT_US.class));


        }

        else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
                Intent browserIntent= new Intent(Intent.ACTION_VIEW, Uri.parse("http://sites.ieee.org/sb-hmritm/"));
                startActivity(browserIntent);

        }


        DrawerLayout drawer =findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void login(MenuItem item) {
        Intent intent=new Intent(HOME.this,LOGIN.class);
        startActivity(intent);
    }

}


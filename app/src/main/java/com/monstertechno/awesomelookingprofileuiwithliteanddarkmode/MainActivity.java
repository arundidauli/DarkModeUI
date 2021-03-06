package com.monstertechno.awesomelookingprofileuiwithliteanddarkmode;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    private boolean isChecked = false;
    ImageButton like,back;
    Button poke;
    ImageView facebook,instagram,follow;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if(AppCompatDelegate.getDefaultNightMode()== AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.darktheam);
        }else
            setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar =  findViewById(R.id.toolbar);
        toolbar.setTitle("Hello Arun");
        setSupportActionBar(toolbar);
        like =  findViewById(R.id.like);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"You Like me",Toast.LENGTH_SHORT).show();
            }
        });

        back =  findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Clicked the Back Button",Toast.LENGTH_SHORT).show();
            }
        });

        poke =  findViewById(R.id.button);
        poke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"You Poked Me ;)",Toast.LENGTH_SHORT).show();
            }
        });

        facebook = findViewById(R.id.imageView4) ;
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Follow me on Facebook",Toast.LENGTH_SHORT).show();
            }
        });

        instagram = findViewById(R.id.imageView7) ;
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Follow me on Instagram",Toast.LENGTH_SHORT).show();
            }
        });

        follow =  findViewById(R.id.imageView6) ;
        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Follow me",Toast.LENGTH_SHORT).show();
            }
        });




    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem checkable = menu.findItem(R.id.theam);
        checkable.setChecked(isChecked);
        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            checkable.setChecked(true);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.theam:
                isChecked = !item.isChecked();
                item.setChecked(isChecked);
                if(isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    Toast.makeText(MainActivity.this,"Dark Mode On",Toast.LENGTH_SHORT).show();
                    restartApp();

                }else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    Toast.makeText(MainActivity.this,"Dark Mode Off",Toast.LENGTH_SHORT).show();
                    restartApp();
                }
                return true;
            default:
                return true;
        }
    }

    private void restartApp() {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
        finish();
    }
}

package com.example.hiitproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.Toast;

//Main Class for Homepage.java
public class HomePage extends AppCompatActivity {
    boolean clicked = false;
    boolean newplaylistboo;
    //Hides the standard android studio header
    public void hideTopAction(){
        try{
            this.getSupportActionBar().hide();
        }
        catch(NullPointerException e){System.out.println("Top bar has been hidden.");}
    }
    //Transfers integers into pixel measurements for xml
    public int intToPixels(int i){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, i, getResources().getDisplayMetrics());
    }
    //Personal boolean to string method
    public String toString(boolean boo){
        String s = "";
        s += boo;
        return s;
    }


    //Main loop for activity_home_page.xml
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        hideTopAction();
        Intent homin= getIntent();
        final SearchView searchView = (SearchView)findViewById(R.id.searchwork);
        Button createbutton = findViewById(R.id.creatplaybt);
        Button createcusworkbt = findViewById(R.id.custcreate);
        LinearLayout playlists = findViewById(R.id.playlists);
        Bundle b = homin.getExtras();
        //Playlist Information
        final String cplayname = homin.getStringExtra("playname");
        final String cplaydesc = homin.getStringExtra("playdesc");
        final String ctimehr = homin.getStringExtra("timehr");
        final String ctimemin = homin.getStringExtra("timemin");
        newplaylistboo = false;
        //Catches when the boolean newplayboo is empty
        try {
            newplaylistboo = b.getBoolean("newplayboo");
        }
        catch (NullPointerException e){System.out.println("Boolean newplayboo is empty");}
        //Creates playlist when newplaylistboo is true
        if(newplaylistboo == true) {
            Button playopenbt = new Button(this);
            playopenbt.setLayoutParams(new LinearLayout.LayoutParams(1350, 400));
            LinearLayout.LayoutParams playbt = (LinearLayout.LayoutParams)playopenbt.getLayoutParams();
            playbt.gravity = Gravity.CENTER;
            playopenbt.setLayoutParams(playbt);
            playopenbt.setBackground(getDrawable(R.drawable.plledit));
            playlists.addView(playopenbt);
        }
        else{
            System.out.println("No playlist");
        }
        //Search View on activity_home_page.xml
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clicked) {
                    searchView.setVisibility(View.GONE);
                    clicked = false;
                }
                else{
                    searchView.setVisibility(View.VISIBLE);
                    clicked = true;
                }
            }
        });
        //Create playlist button in acitivity_home_page.xml
        createbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomePage.this, "Clicked", Toast.LENGTH_SHORT).show();
                Intent createin = new Intent(HomePage.this, CreatePlayList.class);
                startActivity(createin);
            }
        });
        //Create custom playlist button in activity_home_page.xml
        createcusworkbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cusin = new Intent(HomePage.this, CreateCustWork.class);
                startActivity(cusin);
            }
        });

    }
}
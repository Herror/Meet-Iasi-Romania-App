package com.example.android.meetiasiromania;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout museum = (LinearLayout) findViewById(R.id.museum_tab);
        LinearLayout park = (LinearLayout) findViewById(R.id.park_tab);
        LinearLayout restaurant = (LinearLayout) findViewById(R.id.restaurant_tab);
        LinearLayout hotel = (LinearLayout) findViewById(R.id.hotel_tab);
        LinearLayout mainAttraction = (LinearLayout) findViewById(R.id.main_attraction_tab);

        museum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent museumIntent = new Intent(MainActivity.this, MuseumActivity.class);
                startActivity(museumIntent);
            }
        });

        park.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent parkIntent = new Intent(MainActivity.this, ParkActivity.class);
                startActivity(parkIntent);
            }
        });

        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent restaurantIntent = new Intent(MainActivity.this, RestaurantActivity.class);
                startActivity(restaurantIntent);
            }
        });

        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hotelIntent = new Intent(MainActivity.this, HotelActivity.class);
                startActivity(hotelIntent);
            }
        });

        mainAttraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainAttractionIntent = new Intent(MainActivity.this, MainAttractionActivity.class);
                startActivity(mainAttractionIntent);
            }
        });
    }
}

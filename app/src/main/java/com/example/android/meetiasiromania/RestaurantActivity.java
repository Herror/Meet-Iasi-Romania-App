package com.example.android.meetiasiromania;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity {

    private Uri mAttractionLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> restaurants = new ArrayList<Word>();

        restaurants.add(new Word(R.drawable.boltarece,"Bolta Rece","Phone: 0232 212 255","Hours: 08:00 - 00:00", "700115, Cold Street 10", "Bolta Rece Restaurant Iasi"));
        restaurants.add(new Word(R.drawable.salsa,"Salsa Mexican","Phone: 0760 013 014","Hours: 08:00 - 23:00", "Saint Lazar Street 27", "Salsa Mexican Restaurant Iasi"));
        restaurants.add(new Word(R.drawable.mammamia,"Mamma Mia","Phone: 0762 662 642","Open 24h", "Stefan the Great boulevard 4", "Mamma Mia Restaurant Iasi"));
        restaurants.add(new Word(R.drawable.vivo,"Vivo","Phone: 0332 417 727","Hours: 12:00 - 22:00", "Zimbru Street 5", "Vivo Restaurant Iasi"));
        restaurants.add(new Word(R.drawable.lacupola,"La Cupola","Phone: 0332 730 933","Hours: 10:00 - 22:00", "Inside Palas Mall, Level 0", "La Cupola Restaurant Iasi"));
        restaurants.add(new Word(R.drawable.restaurant,"Oscar","Phone: 0332 441 419","Hours: 10:30 - 00:00", "Lascar Catargi Street 16", "Oscar Restaurant Iasi"));
        restaurants.add(new Word(R.drawable.restaurant,"Medieval Knight","Phone: 0771 413 238","Hours: 11:00 - 00:00", "Iasi - Ciurea Street", "Medieval Knight Restaurant Iasi"));
        restaurants.add(new Word(R.drawable.fenice,"Fenice Palas","Phone: 0332 730 889","Hours: 09:00 - 02:00", "Palas Street 3F", "Fenice Palas Restaurant Iasi"));
        restaurants.add(new Word(R.drawable.restaurant,"Tirol","Phone: 0733 044 876","Hours: 12:00 - 23:00", "Palat Street no. 5A", "Tirol Restaurant Iasi"));

        //Match the color of the Activity with the color of the TextView displayed on the main Activity
        WordAdapter adapter = new WordAdapter(this, restaurants, R.color.category_restaurant);

        //Create a GridView
        GridView listView = (GridView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        //Create an onClickListener so it can open the location of each item when clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = restaurants.get(position);

                mAttractionLocation = Uri.parse("geo:0,0?q=" + word.getLocation());
                Intent intent = new Intent(Intent.ACTION_VIEW, mAttractionLocation);

                //Check to see if there is an app that can handle this intent
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
}

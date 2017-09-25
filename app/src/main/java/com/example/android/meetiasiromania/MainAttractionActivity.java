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

public class MainAttractionActivity extends AppCompatActivity {

    private Uri mAttractionLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> mainAttractions = new ArrayList<Word>();

        mainAttractions.add(new Word(R.drawable.main_attraction,"Palace of culture","Phone: 0232 275 979","Hours: 10:00 - 17:00", "Stefan the Great Square", "Palace of culture"));
        mainAttractions.add(new Word(R.drawable.main_attraction,"Copou Park", "Carol I Boulevard", "Copou Park", "Copou Park"));
        mainAttractions.add(new Word(R.drawable.main_attraction,"Metropolitan Cathedral","Phone: 0232 215 454","Stefan the Great Boulevard", "Motropolitan Cathedral Iasi"));
        mainAttractions.add(new Word(R.drawable.main_attraction,"Vasile Alecsandri Theater","Phone: 0232 255 999","Agatha Barsescu 18", "Vasile Alecsandri Teather Iasi"));
        mainAttractions.add(new Word(R.drawable.main_attraction,"Botanic Garden","Phone: 0232 201 373","Hours: 09:00 - 20:00", "Red Grove Street 7-9", "Botanic Garden Iasi"));
        mainAttractions.add(new Word(R.drawable.main_attraction,"Alexandru Ioan Cuza University","Phone: 0232 201 000", "Carol I Boulevard 11", "Alexandru Ioan Cuza University Iasi"));
        mainAttractions.add(new Word(R.drawable.main_attraction,"Union Museum","Phone: 0232 218 383","Hours: 10:00 - 17:00", "Alexandru Lapusneanu Street 14", "Union Museum"));
        mainAttractions.add(new Word(R.drawable.main_attraction,"Complex Palas", "Palas Street 7A", "Palas", "Palas Iasi"));
        mainAttractions.add(new Word(R.drawable.main_attraction,"Cetatuia Monastery","Phone: 0744 647 957", "Cetatuia Street 1", "Cetatuia Monastery"));

        //Match the color of the Activity with the color of the TextView displayed on the main Activity
        WordAdapter adapter = new WordAdapter(this, mainAttractions, R.color.category_main_attractions );

        //Create a GridView
        GridView listView = (GridView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        //Create an onClickListener so it can open the location of each item when clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = mainAttractions.get(position);

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

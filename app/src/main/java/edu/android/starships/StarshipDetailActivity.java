package edu.android.starships;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.TextView;

import edu.android.starships.rest.StarshipPost;
import edu.android.starships.rest.StarshipsPost;

public class StarshipDetailActivity extends AppCompatActivity {

    TextView nameTextView;
    TextView modelTextView;
    TextView classTextView;
    TextView manufacturerTextView;
    TextView lengthTextView;
    TextView crewTextView;
    TextView costTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        
        Bundle extras = getIntent().getExtras();
        //StarshipPost extras = (StarshipPost) getIntent().getSerializableExtra("starship");

        String name;
        String model;
        String starshipClass;
        String manufacturer;
        String length;
        String crew;
        String cost;

        if (extras != null) {
            name = extras.getString("name");
            model = extras.getString("model");
            starshipClass = extras.getString("starship_class");
            manufacturer = extras.getString("manufacturer");
            length = extras.getString("length");
            crew = extras.getString("crew");
            cost = extras.getString("cost_in_credits");


            nameTextView = findViewById(R.id.nameTextView);
            nameTextView.setText(name);
            modelTextView = findViewById(R.id.modelTextView);
            modelTextView.setText(model);
            classTextView = findViewById(R.id.classTextView);
            classTextView.setText(starshipClass);
            manufacturerTextView = findViewById(R.id.manufactererTextView);
            manufacturerTextView.setText(manufacturer);
            lengthTextView = findViewById(R.id.lengthTextView);
            lengthTextView.setText(length);
            crewTextView = findViewById(R.id.crewTextView);
            crewTextView.setText(crew);
            costTextView = findViewById(R.id.costTextView);
            costTextView.setText(cost);


            /*
            nameTextView = findViewById(R.id.nameTextView);
            nameTextView.setText(extras.getName());
            modelTextView = findViewById(R.id.modelTextView);
            modelTextView.setText(extras.getModel());
            classTextView = findViewById(R.id.classTextView);
            classTextView.setText(extras.getStarship_class());
            manufacturerTextView = findViewById(R.id.manufactererTextView);
            manufacturerTextView.setText(extras.getManufacturer());
            lengthTextView = findViewById(R.id.lengthTextView);
            lengthTextView.setText(extras.getLength());
            crewTextView = findViewById(R.id.crewTextView);
            crewTextView.setText(extras.getCrew());
            costTextView = findViewById(R.id.costTextView);
            costTextView.setText(extras.getCost_in_credits());
            */

        }

    }

}

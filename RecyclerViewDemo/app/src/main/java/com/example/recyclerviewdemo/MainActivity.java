package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.recyclerviewdemo.adaptors.TuneAdaptor;
import com.example.recyclerviewdemo.databinding.ActivityMainBinding;
import com.example.recyclerviewdemo.model.Tune;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> TuneNames = new ArrayList<>(Arrays.asList("Beauty and the Beast",
            "Lion King", "Mary Poppins", "Game of Thrones", "Ozark"));
    List<Integer> TunePics = new ArrayList<>(Arrays.asList(R.drawable.beauty,
            R.drawable.lionking, R.drawable.marypoppins,
            R.drawable.gameofthrones, R.drawable.ozark));

    List<Tune> TuneList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        LoadModel();

        TuneAdaptor tuneAdaptor = new TuneAdaptor(TuneList);
        LinearLayoutManager lm = new LinearLayoutManager(MainActivity.this);

        GridLayoutManager glm = new GridLayoutManager(MainActivity.this, 2);

        binding.reccyclerViewTunes.setLayoutManager(lm);
//        binding.reccyclerViewTunes.setLayoutManager(glm);
        binding.reccyclerViewTunes.setAdapter(tuneAdaptor);
    }
    private  void LoadModel(){
        for (int i =0; i< TuneNames.size(); i++){
            Tune eachTune = new Tune(TuneNames.get(i), TunePics.get(i));
            TuneList.add(eachTune);
        }

    }
}
package com.gsc.superheros.ui.superheros;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.gsc.superheros.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SuperHerosActivity extends AppCompatActivity  {

    @BindView(R.id.superheros_list)
    RecyclerView superherosList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_superheros);
        ButterKnife.bind(this);
    }
}

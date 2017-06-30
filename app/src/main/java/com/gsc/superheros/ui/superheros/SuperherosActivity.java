package com.gsc.superheros.ui.superheros;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gsc.superheros.R;
import com.gsc.superheros.model.Superhero;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SuperherosActivity extends AppCompatActivity implements SuperheroView {

    private SuperheroPresenter presenter;

    @BindView(R.id.superheros_list)
    RecyclerView recyclerSuperheros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_superheros);
        ButterKnife.bind(this);

        setupUi();

        presenter = new SuperheroPresenter();
        presenter.setView(this);
        presenter.create();
    }

    public void setupUi() {
        recyclerSuperheros.setLayoutManager(new GridLayoutManager(this, 2));
    }

    //region SuperheroView

    @Override
    public void setSuperheros(List<Superhero> superheros) {
        recyclerSuperheros.setAdapter(new SuperheroRecyclerViewAdapter(superheros));
    }

    //endregion
}

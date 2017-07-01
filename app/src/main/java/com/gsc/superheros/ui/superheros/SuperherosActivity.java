package com.gsc.superheros.ui.superheros;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gsc.superheros.R;
import com.gsc.superheros.model.Superhero;
import com.gsc.superheros.ui.base.OnBaseListListener;
import com.gsc.superheros.ui.superheros.detail.SuperheroDetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SuperherosActivity extends AppCompatActivity implements SuperheroView, OnBaseListListener {

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        recyclerSuperheros.setAdapter(null);
    }

    //region SuperheroView

    @Override
    public void setSuperheros(List<Superhero> superheros) {
        recyclerSuperheros.setAdapter(new SuperheroRecyclerViewAdapter(superheros, this));
    }

    @Override
    public void navigateToDetail(Superhero superhero) {
        SuperheroDetailActivity.open(this, superhero);
    }

    //endregion

    //region OnBaseListListener

    @Override
    public void onItemClick(int position) {
        presenter.onSuperheroSelected(position);
    }

    //endregion
}

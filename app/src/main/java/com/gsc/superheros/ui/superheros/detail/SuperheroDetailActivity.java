package com.gsc.superheros.ui.superheros.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.gsc.superheros.R;
import com.gsc.superheros.model.Superhero;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SuperheroDetailActivity extends AppCompatActivity implements SuperheroDetailView {

    private static final String ARG_SUPERHERO = "arg_superhero";

    private SuperheroDetailPresenter presenter;

    @BindView(R.id.superhero_detail_appbar)
    AppBarLayout appbar;
    @BindView(R.id.superhero_detail_collapsing)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.superhero_detail_toolbar)
    Toolbar toolbar;
    @BindView(R.id.superhero_detail_image)
    ImageView image;
    @BindView(R.id.superhero_detail_real_name)
    TextView realName;
    @BindView(R.id.superhero_detail_height)
    TextView height;
    @BindView(R.id.superhero_detail_power)
    TextView power;
    @BindView(R.id.superhero_detail_abilities)
    TextView abilities;
    @BindView(R.id.superhero_detail_groups)
    TextView groups;

    public static void open(Context context, Superhero superhero) {
        Intent intent = new Intent(context, SuperheroDetailActivity.class);
        intent.putExtra(ARG_SUPERHERO, superhero);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_superhero_detail);
        ButterKnife.bind(this);

        setupActionBar();

        presenter = new SuperheroDetailPresenter();
        presenter.setView(this);
        presenter.create(getIntent().getParcelableExtra(ARG_SUPERHERO));
    }

    private void setupActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(view -> onBackPressed());
    }

    //region SuperheroDetailView

    @Override
    public void setToolbarTitle(String title) {
        toolbar.setTitle(title);
        collapsingToolbar.setTitle(title);
    }

    @Override
    public void setSuperheroInfo(Superhero superhero) {
        Picasso.with(this).load(superhero.getPhoto()).into(image);
        realName.setText(superhero.getRealName());
        height.setText(superhero.getHeight());
        power.setText(superhero.getPower());
        abilities.setText(superhero.getAbilities());
        groups.setText(superhero.getGroups());
    }

    //endregion
}

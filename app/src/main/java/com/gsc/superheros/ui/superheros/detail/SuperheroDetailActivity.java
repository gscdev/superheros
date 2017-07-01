package com.gsc.superheros.ui.superheros.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        setupActionBar(((Superhero) getIntent().getParcelableExtra(ARG_SUPERHERO)).getName());
        setupUi(getIntent().getParcelableExtra(ARG_SUPERHERO));

        presenter = new SuperheroDetailPresenter();
        presenter.setView(this);
        presenter.create();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void setupActionBar(String title) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title);
    }

    private void setupUi(Superhero superhero) {
        Picasso.with(this).load(superhero.getPhoto()).into(image);
        realName.setText(superhero.getRealName());
        height.setText(superhero.getHeight());
        power.setText(superhero.getPower());
        abilities.setText(superhero.getAbilities());
        groups.setText(superhero.getGroups());
    }
}

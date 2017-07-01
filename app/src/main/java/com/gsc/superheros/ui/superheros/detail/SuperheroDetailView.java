package com.gsc.superheros.ui.superheros.detail;

import com.gsc.superheros.model.Superhero;

interface SuperheroDetailView {

    void setToolbarTitle(String title);

    void setSuperheroInfo(Superhero superhero);
}

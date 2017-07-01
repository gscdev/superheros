package com.gsc.superheros.ui.superheros.detail;

import com.gsc.superheros.model.Superhero;
import com.gsc.superheros.ui.base.BasePresenter;

class SuperheroDetailPresenter extends BasePresenter<SuperheroDetailView> {

    public void create(Superhero superhero) {
        getView().setToolbarTitle(superhero.getName());
        getView().setSuperheroInfo(superhero);
    }
}

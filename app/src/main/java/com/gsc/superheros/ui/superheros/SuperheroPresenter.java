package com.gsc.superheros.ui.superheros;

import com.gsc.superheros.model.Superhero;
import com.gsc.superheros.ui.base.BasePresenter;
import com.gsc.superheros.usecase.GetSuperherosUseCase;

import java.util.List;

class SuperheroPresenter extends BasePresenter<SuperheroView> implements GetSuperherosUseCase.Callback {

    private GetSuperherosUseCase getSuperherosUseCase;

    public SuperheroPresenter() {
        getSuperherosUseCase = new GetSuperherosUseCase();
    }

    public void create() {
        getSuperherosUseCase.getSuperheros(this);
    }

    //region GetSuperherosUseCase.Callback

    @Override
    public void onSuccessGetSuperheros(List<Superhero> superheros) {
        if (getView() != null) {
            getView().setSuperheros(superheros);
        }
    }

    @Override
    public void onErrorGetSuperheros() {
        // TODO: 30/06/2017  onErrorGetSuperheros
    }

    //endregion
}

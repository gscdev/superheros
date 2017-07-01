package com.gsc.superheros.ui.superheros;

import com.gsc.superheros.model.Superhero;
import com.gsc.superheros.ui.base.BasePresenter;
import com.gsc.superheros.usecase.GetSuperherosUseCase;

import java.util.List;

class SuperheroPresenter extends BasePresenter<SuperheroView> implements GetSuperherosUseCase.Callback {

    private GetSuperherosUseCase getSuperherosUseCase;

    private List<Superhero> superheros;


    public SuperheroPresenter() {
        getSuperherosUseCase = new GetSuperherosUseCase();
    }

    public void create() {
        getView().showProgress();
        getSuperherosUseCase.getSuperheros(this);
    }

    public void onSuperheroSelected(int position) {
        getView().navigateToDetail(superheros.get(position));
    }

    //region GetSuperherosUseCase.Callback

    @Override
    public void onSuccessGetSuperheros(List<Superhero> superheros) {
        this.superheros = superheros;

        if (getView() != null) {
            getView().hideProgress();
            getView().setSuperheros(superheros);
        }
    }

    @Override
    public void onErrorGetSuperheros() {
        if (getView() != null) {
            getView().hideProgress();
        }
    }

    //endregion
}

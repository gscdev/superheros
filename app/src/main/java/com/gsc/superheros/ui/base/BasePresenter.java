package com.gsc.superheros.ui.base;

public abstract class BasePresenter<T> {

    private T mView;

    public void setView(T view) {
        mView = view;
    }

    public T getView() {
        return mView;
    }
}

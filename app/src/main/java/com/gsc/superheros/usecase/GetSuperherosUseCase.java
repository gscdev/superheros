package com.gsc.superheros.usecase;


import android.os.Handler;
import android.os.Looper;

import com.gsc.superheros.data.DataRepository;
import com.gsc.superheros.model.Superhero;

import java.util.List;

public class GetSuperherosUseCase {

    private DataRepository dataRepository;

    public GetSuperherosUseCase() {
        dataRepository = new DataRepository();
    }

    public void getSuperheros(Callback callback) {
        new Thread(() -> loadSuperheros(callback)).start();
    }

    private void loadSuperheros(Callback callback) {
        List<Superhero> superheros = dataRepository.getSuperheros();

        new Handler(Looper.getMainLooper()).post(() -> {
            if (superheros == null) {
                callback.onErrorGetSuperheros();
            } else {
                callback.onSuccessGetSuperheros(superheros);
            }
        });
    }

    public interface Callback {
        void onSuccessGetSuperheros(List<Superhero> superheros);

        void onErrorGetSuperheros();
    }
}

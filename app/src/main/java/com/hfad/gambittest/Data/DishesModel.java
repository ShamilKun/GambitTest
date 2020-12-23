package com.hfad.gambittest.Data;

import android.content.Context;
import android.preference.PreferenceManager;
import android.util.Log;

import com.hfad.gambittest.Data.ApiInterface;
import com.hfad.gambittest.Data.DataOfDishes;
import com.hfad.gambittest.Data.ServiceGenerator;

import android.content.SharedPreferences;

import com.hfad.gambittest.MVP.MainActivityPresenter;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class DishesModel {

    public List<DataOfDishes> dataOfDishes = new ArrayList<>();
    public ArrayList<String> tx = new ArrayList<>();
    public MainActivityPresenter presenter;
    SharedPreferences sPref;

    public DishesModel (MainActivityPresenter presenter,Context context) {

        this.presenter = presenter;
         this.sPref = PreferenceManager.getDefaultSharedPreferences(context);

    }





    public String xx = "2";


    // метод установки данных API в List

    public void getClothing() {
        final List<DataOfDishes> dataOfDishes = new ArrayList<>();
        ApiInterface apiInterface = ServiceGenerator.createService(ApiInterface.class);
        Call<List<DataOfDishes>> call = apiInterface.getDishes();

        call.enqueue(new Callback<List<DataOfDishes>>() {
            @Override
            public void onResponse(Call<List<DataOfDishes>> call, Response<List<DataOfDishes>> response) {
                if (response.isSuccessful()) {
                    for (DataOfDishes dod : response.body()) {

                    dataOfDishes.add(dod);
                    presenter.SetData(dataOfDishes);



                    }
                    //Получения локальных данных
                   presenter.getLocalData();

              }


                  }

                  @Override
          public void onFailure(Call<List<DataOfDishes>> call, Throwable t){
                //Вывод картинки на экран при отсутствии интернета
                presenter.noInternet();
                  }
              });
    }





}
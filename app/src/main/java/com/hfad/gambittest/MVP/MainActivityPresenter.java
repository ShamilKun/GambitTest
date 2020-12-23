package com.hfad.gambittest.MVP;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

import androidx.recyclerview.widget.RecyclerView;

import com.hfad.gambittest.Data.DataOfDishes;
import com.hfad.gambittest.Data.DishesModel;
import com.hfad.gambittest.R;
import com.hfad.gambittest.View.MainActivity;

import java.util.List;



public class MainActivityPresenter implements PresenterInterface {
    public MainActivity mainActivity;
    RecyclerView.Adapter adapter;

    public MainActivityPresenter (MainActivity mainActivity, RecyclerView.Adapter adapter, MainActivity activity){
        DishesModel dishesModel = new DishesModel(this, mainActivity.getApplicationContext());
        dishesModel.getClothing();
        this.mainActivity = mainActivity;
        this.adapter = adapter;
    }


    public void SetData(List<DataOfDishes> dataOfDishes) {
        mainActivity.setDishes(dataOfDishes);
    }


    @Override
    public void clicks(View v, int position) {
        switch (v.getId()) {
            case R.id.AddToCart:
                mainActivity.addFavorite(position);
                break;
            case R.id.ButtonPlus:
                mainActivity.plusFavorite(position);
                break;
            case R.id.ButtonMinus:
                mainActivity.minusFavorite(position);
                break;
                case R.id.Favorites:
                    mainActivity.fav(position);
                    break; }

    }

    public void getLocalData (){
        mainActivity.getLocalData();
    }
 public void noInternet() {
mainActivity.noInternet();
 }

    @Override
    public void clicks(View v) {

    }
}

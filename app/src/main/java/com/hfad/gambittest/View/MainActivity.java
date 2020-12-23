package com.hfad.gambittest.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.hfad.gambittest.Data.DataOfDishes;
import com.hfad.gambittest.MVP.MainActivityPresenter;
import com.hfad.gambittest.R;

import java.util.List;

public class MainActivity extends AppCompatActivity   {


    RecyclerView recyclerView;
    Adapter adapter;
    List<DataOfDishes> dataOfDishes;
    MainActivityPresenter presenter;
    SharedPreferences sPref;
    ImageView nonInet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recyclerView = findViewById(R.id.listOfDishes);


         presenter = new MainActivityPresenter(this,adapter,this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);




    }

    @Override
    protected void onStop() {
        super.onStop();
//Локальное сохранения данных
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        for (int i =0; i <dataOfDishes.size();i++ )
        {
            ed.putInt("Quantity" + i, dataOfDishes.get(i).getQuantity());
            ed.putBoolean("FavoritesBool" + i, dataOfDishes.get(i).isFavorites());
            ed.commit();
        }

    }

    public void getLocalData (){
        //Получения локальных данных
        for (int i =0; i <dataOfDishes.size();i++ )
        {
            sPref = getPreferences(MODE_PRIVATE);
            dataOfDishes.get(i).setQuantity(sPref.getInt("Quantity" + i,0));
            dataOfDishes.get(i).setFavorites(sPref.getBoolean("FavoritesBool" + i,false));
        }
    }

    public void setDishes(List<DataOfDishes> dataOfDishes) {
        this.dataOfDishes = dataOfDishes;
        adapter = new Adapter(this,dataOfDishes,presenter);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
    //Событие при нажании на кнопку "В корзину"
    public void addFavorite (int position) {
        dataOfDishes.get(position).setQuantity(dataOfDishes.get(position).getQuantity()+1);
        adapter.notifyDataSetChanged();
    }
    //Событие при нажании на кнопку "+"
    public void plusFavorite(int position){
        dataOfDishes.get(position).setQuantity(dataOfDishes.get(position).getQuantity()+1);
        adapter.notifyDataSetChanged();
    }
    //Событие при нажании на кнопку "-"
    public void minusFavorite(int position){
        dataOfDishes.get(position).setQuantity(dataOfDishes.get(position).getQuantity()-1);
        adapter.notifyDataSetChanged();
    }
    //Событие при нажании на кнопку "Сердечко"
    public void fav (int position) {
        if ( dataOfDishes.get(position).isFavorites())
        dataOfDishes.get(position).setFavorites(false);
        else dataOfDishes.get(position).setFavorites(true);
}
public void noInternet() {
        nonInet = findViewById(R.id.nonInet);
        nonInet.setVisibility(View.VISIBLE);
}
}
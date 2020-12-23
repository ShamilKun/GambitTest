package com.hfad.gambittest.View;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.gambittest.Data.DataOfDishes;
import com.hfad.gambittest.MVP.MainActivityPresenter;
import com.hfad.gambittest.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    List<DataOfDishes> dataOfDishes;
    MainActivityPresenter presenter;

    public Adapter(Context context, List<DataOfDishes> dataOfDishes, MainActivityPresenter presenter) {
        this.context = context;
        this.dataOfDishes = dataOfDishes;
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent,final int viewType) {
        int lay = R.layout.dishes_item;

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(lay, parent, false);


        Adapter.ViewHolder vwHolder = new Adapter.ViewHolder(view);


        return vwHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        Picasso.with(context)
                .load(dataOfDishes.get(position).getImage_app())
                .into(holder.image);
        holder.name.setText(dataOfDishes.get(position).getName() + "");
        holder.price.setText(dataOfDishes.get(position).getPrice()+ " ₽") ;
        holder.quan.setText(dataOfDishes.get(position).getQuantity() + "");
        if(dataOfDishes.get(position).getQuantity() != 0){
            holder.inCart.setVisibility(View.INVISIBLE);
            holder.inCartText.setVisibility(View.INVISIBLE);
            }
        else {
            holder.inCart.setVisibility(View.VISIBLE);
            holder.inCartText.setVisibility(View.VISIBLE);
        }
        if (dataOfDishes.get(position).isFavorites())
           holder.favoritesBitton.setImageResource(R.drawable.ic_baseline_favorite_24);
        else {
            holder.favoritesBitton.setImageResource(R.drawable.ic_baseline_favorite_border_24);
        }



        holder.inCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clicks(v,position);
            }
        });
        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clicks(v,position);
            }
        });
        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clicks(v,position);
            }
        });
        holder.favoritesBitton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              presenter.clicks(v,position);
              //Пришлось написать код смены значка тут потому что когда писал в MainActivity
                //Приходилось использовать  adapter.notifyDataSetChanged() все свайпы возвращались
                //Исходную позицию
            if (dataOfDishes.get(position).isFavorites())
            holder.favoritesBitton.setImageResource(R.drawable.ic_baseline_favorite_24);
            else
                holder.favoritesBitton.setImageResource(R.drawable.ic_baseline_favorite_border_24);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataOfDishes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageButton favoritesBitton;
        ImageView image;
        TextView name;
        TextView price;
        TextView quan;
        ImageButton inCart;
        ImageButton plus;
        ImageButton minus;
        TextView inCartText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image =itemView.findViewById(R.id.DishesImage);
            name = itemView.findViewById(R.id.DishesName);
            price = itemView.findViewById(R.id.DishesPrice);
            inCart = itemView.findViewById(R.id.AddToCart);
            inCartText = itemView.findViewById(R.id.InCartTxt);
            plus = itemView.findViewById(R.id.ButtonPlus);
            minus = itemView.findViewById(R.id.ButtonMinus);
            quan = itemView.findViewById(R.id.quantity);
            favoritesBitton = itemView.findViewById(R.id.Favorites);

        }
    }
}

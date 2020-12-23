package com.hfad.gambittest.Data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("category/39?page=1")
    Call<List<DataOfDishes>> getDishes();
}

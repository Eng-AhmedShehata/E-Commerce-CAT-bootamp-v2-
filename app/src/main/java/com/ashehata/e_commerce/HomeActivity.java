package com.ashehata.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        RecyclerView recyclerView = findViewById(R.id.rv);
        progressBar = findViewById(R.id.loading);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        apiInterface.getProducts().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                // get data from api
                List<Product> productList = response.body();
                // pass data to the adapter
                ProductsAdapter productsAdapter = new ProductsAdapter(productList);
                // display to rv
                recyclerView.setAdapter(productsAdapter);
                hideProgress();

            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(HomeActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                hideProgress();

            }
        });

    }


    private void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}
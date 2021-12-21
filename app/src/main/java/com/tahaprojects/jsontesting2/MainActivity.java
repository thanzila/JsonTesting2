package com.tahaprojects.jsontesting2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvcw;
    List<MyData> myDataList=new ArrayList<>();
    RVAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvcw=findViewById(R.id.rcvw);
        rvcw.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi holderApi=retrofit.create(JsonPlaceHolderApi.class);
        Call<List<MyData>> call=holderApi.getMyJson();
        call.enqueue(new Callback<List<MyData>>() {
            @Override
            public void onResponse(Call<List<MyData>> call, Response<List<MyData>> response) {
                if(!response.isSuccessful())
                {
                    System.out.println("Errobycsrgd"+response.message());
                    return;
                }
                adapter=new RVAdapter(response.body(),MainActivity.this);

                rvcw.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<MyData>> call, Throwable t) {

            }
        });

    }
}
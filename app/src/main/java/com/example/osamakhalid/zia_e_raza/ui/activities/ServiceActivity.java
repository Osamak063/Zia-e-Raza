package com.example.osamakhalid.zia_e_raza.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.osamakhalid.zia_e_raza.R;
import com.example.osamakhalid.zia_e_raza.ui.API.APIUrls;
import com.example.osamakhalid.zia_e_raza.ui.adapter.ServiceAdapter;
import com.example.osamakhalid.zia_e_raza.ui.baseconnection.RetrofitInitialize;
import com.example.osamakhalid.zia_e_raza.ui.callbacks.APICalls;
import com.example.osamakhalid.zia_e_raza.ui.callbacks.ServiceAdapterCallbacks;
import com.example.osamakhalid.zia_e_raza.ui.model.ScholarServicesList;
import com.example.osamakhalid.zia_e_raza.ui.model.ServiceModel;
import com.example.osamakhalid.zia_e_raza.ui.model.WebCommon;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ServiceActivity extends AppCompatActivity implements ServiceAdapterCallbacks {
    RecyclerView recyclerView;
    List<ServiceModel> serviceList;
    ServiceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        recyclerView = findViewById(R.id.service_recycler_view);
        serviceList = new ArrayList<>();
        getServices();
        adapter = new ServiceAdapter(this, this, serviceList);
        GridLayoutManager layoutManager = new GridLayoutManager(recyclerView.getContext(), 2);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }

    public void getServices() {
        Retrofit retrofit = RetrofitInitialize.getApiClient();
        APICalls apiCall = retrofit.create(APICalls.class);
        Call<WebCommon> call = apiCall.getServicesList("mufti-manzoor-ahmed-faizi", 4, "asdfasd");
        call.enqueue(new Callback<WebCommon>() {
            @Override
            public void onResponse(Call<WebCommon> call, Response<WebCommon> response) {
                if (response.isSuccessful()) {
                    WebCommon servicesListData = response.body();
                    if (servicesListData != null) {
                        ScholarServicesList scholarServicesList = servicesListData.getScholarServicesList();
                        serviceList.addAll(scholarServicesList.getServices());
                        adapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(ServiceActivity.this, "Data not available", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ServiceActivity.this, "Response unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<WebCommon> call, Throwable t) {
                Toast.makeText(ServiceActivity.this, "Failure!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void invoke(String parameter) {
        Intent i = new Intent(ServiceActivity.this, ProductActivity.class);
        i.putExtra("parameter", parameter);
        startActivity(i);
    }
}

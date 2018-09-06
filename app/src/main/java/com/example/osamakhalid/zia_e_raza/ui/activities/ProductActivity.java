package com.example.osamakhalid.zia_e_raza.ui.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.osamakhalid.zia_e_raza.R;
import com.example.osamakhalid.zia_e_raza.ui.Interface.NavigationManager;
import com.example.osamakhalid.zia_e_raza.ui.adapter.CustomExpandableListAdapter;
import com.example.osamakhalid.zia_e_raza.ui.baseconnection.RetrofitInitialize;
import com.example.osamakhalid.zia_e_raza.ui.callbacks.APICalls;
import com.example.osamakhalid.zia_e_raza.ui.calls.CommonCalls;
import com.example.osamakhalid.zia_e_raza.ui.fragments.FeaturedFragment;
import com.example.osamakhalid.zia_e_raza.ui.fragments.ProductFragment;
import com.example.osamakhalid.zia_e_raza.ui.helper.FragmentNavigationManager;
import com.example.osamakhalid.zia_e_raza.ui.model.FeatureProduct;
import com.example.osamakhalid.zia_e_raza.ui.model.MasterProduct;
import com.example.osamakhalid.zia_e_raza.ui.model.Scholar;
import com.example.osamakhalid.zia_e_raza.ui.model.Sidebar;
import com.example.osamakhalid.zia_e_raza.ui.model.WebServiceCommon;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProductActivity extends AppCompatActivity implements FeaturedFragment.OnFragmentInteractionListener {
    String parameter;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private TextView navHeaderText;
    ProgressDialog progressDialog;

    private ExpandableListView expandableListView;
    private ExpandableListAdapter adapter;
    private List<String> lstTitle;
    private Map<String, List<MasterProduct>> lstChild;
    private NavigationManager navigationManager;
    private List<FeatureProduct> featureProducts;
    private List<Sidebar> sidebar;
    private Scholar scholar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        parameter = getIntent().getStringExtra("parameter");
        mDrawerLayout = findViewById(R.id.drawer_layout);
        expandableListView = findViewById(R.id.nav_list);
        navigationManager = FragmentNavigationManager.getmInstance(this);
        View listHeaderView = getLayoutInflater().inflate(R.layout.nav_header, null, false);
        navHeaderText = listHeaderView.findViewById(R.id.name);
        expandableListView.addHeaderView(listHeaderView);
        lstChild = new HashMap<>();
        lstTitle = new ArrayList<>();
        getData();
        setupDrawer();
        if (savedInstanceState == null) {
            // selectFirstItemAsDefault();
        }
        listHeaderView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("name", scholar.getName());
                bundle.putString("banner", scholar.getBanner());
                ProductFragment productFragment = new ProductFragment();
                productFragment.setArguments(bundle);
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, productFragment)
                        .commit();
                mDrawerLayout.closeDrawers();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.hamburger_icon);

    }


    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    public void selectFirstItemAsDefault() {

        if (navigationManager != null) {

            String firstItem = lstTitle.get(0);
            navigationManager.showFragment(firstItem);
        }
    }

    public void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    public void addDrawersItem() {
        adapter = new CustomExpandableListAdapter(this, lstTitle, lstChild);
        expandableListView.setAdapter(adapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {
                if (lstTitle.get(i).equals("Featured")) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("featured_list", (Serializable) featureProducts);
                    FeaturedFragment featuredFragment = new FeaturedFragment();
                    featuredFragment.setArguments(bundle);
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container, featuredFragment)
                            .commit();
                    mDrawerLayout.closeDrawers();
                }
                getSupportActionBar().setTitle(lstTitle.get(i));
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                return false;
            }
        });
    }

    public void getData() {
        progressDialog = CommonCalls.createDialouge(ProductActivity.this, "", "Please Wait");
        Retrofit retrofit = RetrofitInitialize.getApiClient();
        APICalls apiCall = retrofit.create(APICalls.class);
        Call<WebServiceCommon> call = apiCall.getService(parameter, "mufti-manzoor-ahmed-faizi", 4, "asdfasd");
        call.enqueue(new Callback<WebServiceCommon>() {
            @Override
            public void onResponse(Call<WebServiceCommon> call, Response<WebServiceCommon> response) {
                if (response.isSuccessful()) {
                    WebServiceCommon serviceData = response.body();
                    if (serviceData != null) {
                        scholar = serviceData.getScholar();
                        sidebar = scholar.getSidebar();
                        featureProducts = scholar.getFeatureProducts();

                        addDataToList();
                        callDefaultFragment();
                    }
                }
            }

            @Override
            public void onFailure(Call<WebServiceCommon> call, Throwable t) {

            }
        });
    }

    public void callDefaultFragment() {
        navHeaderText.setText(scholar.getName());
        progressDialog.dismiss();
        Bundle bundle = new Bundle();
        bundle.putString("name", scholar.getName());
        bundle.putString("banner", scholar.getBanner());
        ProductFragment productFragment = new ProductFragment();
        productFragment.setArguments(bundle);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, productFragment)
                .commit();
        mDrawerLayout.closeDrawers();
    }

    public void addDataToList() {
        for (Sidebar sidebar : sidebar) {
            lstTitle.add(sidebar.getName());
            lstChild.put(sidebar.getName(), sidebar.getMasterProducts());
        }
        List<MasterProduct> emptyList = new ArrayList<>();
        lstTitle.add("Featured");
        lstChild.put("Featured", emptyList);
        addDrawersItem();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

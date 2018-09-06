package com.example.osamakhalid.zia_e_raza.ui.helper;


import android.support.v4.app.FragmentManager;

import com.example.osamakhalid.zia_e_raza.ui.Interface.NavigationManager;
import com.example.osamakhalid.zia_e_raza.ui.activities.ProductActivity;

/**
 * Created by Osama Khalid on 8/29/2018.
 */

public class FragmentNavigationManager implements NavigationManager {
    public static FragmentNavigationManager mInstance;
    private FragmentManager mFragmentManager;
    private ProductActivity productActivity;

    public static FragmentNavigationManager getmInstance(ProductActivity productActivity) {
        if (mInstance == null)
            mInstance = new FragmentNavigationManager();
        mInstance.configure(productActivity);
        return mInstance;
    }

    public void configure(ProductActivity productActivity) {
        productActivity = productActivity;
        mFragmentManager = productActivity.getSupportFragmentManager();
    }

    @Override
    public void showFragment(String title) {

    }
}

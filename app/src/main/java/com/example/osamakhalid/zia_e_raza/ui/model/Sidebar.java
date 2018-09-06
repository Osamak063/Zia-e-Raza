package com.example.osamakhalid.zia_e_raza.ui.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Osama Khalid on 8/27/2018.
 */

public class Sidebar {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("masterProducts")
    @Expose
    private List<MasterProduct> masterProducts = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MasterProduct> getMasterProducts() {
        return masterProducts;
    }

    public void setMasterProducts(List<MasterProduct> masterProducts) {
        this.masterProducts = masterProducts;
    }
}

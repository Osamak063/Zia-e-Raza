package com.example.osamakhalid.zia_e_raza.ui.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Osama Khalid on 8/30/2018.
 */

public class ScholarServicesList {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("created_date")
    @Expose
    private String createdDate;
    @SerializedName("most_view")
    @Expose
    private Integer mostView;
    @SerializedName("services")
    @Expose
    private List<ServiceModel> services = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getMostView() {
        return mostView;
    }

    public void setMostView(Integer mostView) {
        this.mostView = mostView;
    }

    public List<ServiceModel> getServices() {
        return services;
    }

    public void setServices(List<ServiceModel> services) {
        this.services = services;
    }
}

package com.example.osamakhalid.zia_e_raza.ui.model;

/**
 * Created by Osama Khalid on 8/21/2018.
 */

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Scholar {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("created_date")
    @Expose
    private String createdDate;
    @SerializedName("most_view")
    @Expose
    private Integer mostView;
    @SerializedName("banner")
    @Expose
    private String banner;
    @SerializedName("layout_home")
    @Expose
    private String layoutHome;
    @SerializedName("layout_list")
    @Expose
    private String layoutList;
    @SerializedName("layout_detail")
    @Expose
    private String layoutDetail;
    @SerializedName("feature_products")
    @Expose
    private List<FeatureProduct> featureProducts = null;
    @SerializedName("sidebar")
    @Expose
    private List<Sidebar> sidebar = null;

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

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getLayoutHome() {
        return layoutHome;
    }

    public void setLayoutHome(String layoutHome) {
        this.layoutHome = layoutHome;
    }

    public String getLayoutList() {
        return layoutList;
    }

    public void setLayoutList(String layoutList) {
        this.layoutList = layoutList;
    }

    public String getLayoutDetail() {
        return layoutDetail;
    }

    public void setLayoutDetail(String layoutDetail) {
        this.layoutDetail = layoutDetail;
    }

    public List<FeatureProduct> getFeatureProducts() {
        return featureProducts;
    }

    public void setFeatureProducts(List<FeatureProduct> featureProducts) {
        this.featureProducts = featureProducts;
    }

    public List<Sidebar> getSidebar() {
        return sidebar;
    }

    public void setSidebar(List<Sidebar> sidebar) {
        this.sidebar = sidebar;
    }

}

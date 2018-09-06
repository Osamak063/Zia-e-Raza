package com.example.osamakhalid.zia_e_raza.ui.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Osama Khalid on 8/27/2018.
 */

public class FeatureProduct implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("most_view")
    @Expose
    private Integer mostView;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("date_birthday")
    @Expose
    private String dateBirthday;
    @SerializedName("date_death")
    @Expose
    private String dateDeath;
    @SerializedName("created_date")
    @Expose
    private String createdDate;
    @SerializedName("featured")
    @Expose
    private Integer featured;
    @SerializedName("masters")
    @Expose
    private List<Master> masters = null;
    @SerializedName("thumb")
    @Expose
    private String thumb;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMostView() {
        return mostView;
    }

    public void setMostView(Integer mostView) {
        this.mostView = mostView;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDateBirthday() {
        return dateBirthday;
    }

    public void setDateBirthday(String dateBirthday) {
        this.dateBirthday = dateBirthday;
    }

    public String getDateDeath() {
        return dateDeath;
    }

    public void setDateDeath(String dateDeath) {
        this.dateDeath = dateDeath;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getFeatured() {
        return featured;
    }

    public void setFeatured(Integer featured) {
        this.featured = featured;
    }

    public List<Master> getMasters() {
        return masters;
    }

    public void setMasters(List<Master> masters) {
        this.masters = masters;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

}

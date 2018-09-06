package com.example.osamakhalid.zia_e_raza.ui.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Osama Khalid on 8/30/2018.
 */

public class WebCommon {
    @SerializedName("scholar")
    @Expose
    private ScholarServicesList scholar;

    public ScholarServicesList getScholarServicesList() {
        return scholar;
    }

    public void setScholarServicesList(ScholarServicesList scholar) {
        this.scholar = scholar;
    }
}

package com.example.osamakhalid.zia_e_raza.ui.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Osama Khalid on 8/27/2018.
 */

public class WebServiceCommon {

    @SerializedName("scholar")
    @Expose
    private Scholar scholar;

    public Scholar getScholar() {
        return scholar;
    }

    public void setScholar(Scholar scholar) {
        this.scholar = scholar;
    }
}

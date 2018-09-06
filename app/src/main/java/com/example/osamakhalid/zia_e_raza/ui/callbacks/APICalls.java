package com.example.osamakhalid.zia_e_raza.ui.callbacks;

import com.example.osamakhalid.zia_e_raza.ui.API.APIUrls;
import com.example.osamakhalid.zia_e_raza.ui.model.WebCommon;
import com.example.osamakhalid.zia_e_raza.ui.model.WebServiceCommon;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Osama Khalid on 8/28/2018.
 */

public interface APICalls {
    @GET(APIUrls.PACKAGES + APIUrls.WEB_SERVICE_COMMON)
    Call<WebServiceCommon> getService(@Query("service") String service, @Query("slug") String slug
            , @Query("featured_limit") int featuredLimit,@Query("api_key") String apiKey);

    @GET(APIUrls.PACKAGES + APIUrls.WEB_COMMON)
    Call<WebCommon> getServicesList(@Query("slug") String slug,@Query("featured_limit") int featuredLimit
            ,@Query("api_key") String apiKey);
}

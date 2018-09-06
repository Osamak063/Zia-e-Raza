package com.example.osamakhalid.zia_e_raza.ui.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.osamakhalid.zia_e_raza.R;
import com.example.osamakhalid.zia_e_raza.ui.callbacks.ServiceAdapterCallbacks;
import com.example.osamakhalid.zia_e_raza.ui.model.ServiceModel;

import java.util.List;

/**
 * Created by Osama Khalid on 8/28/2018.
 */

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ViewHolder> {

    public ServiceAdapterCallbacks mCallbacks;
    private Context mContext;
    private List<ServiceModel> mValues;


    public ServiceAdapter(Context context, ServiceAdapterCallbacks callbacks, List<ServiceModel> items) {

        mCallbacks = callbacks;
        mContext = context;
        mValues = items;

//        this.arabicFont = Typeface.createFromAsset(mContext.getAssets(), "Trad_Arabic_Bold.ttf");
//        this.urduFont = Typeface.createFromAsset(mContext.getAssets(), "Jameel_Noori_Nastaleeq.ttf");
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public ServiceModel getValueAt(int position) {
        return mValues.get(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final ServiceModel serviceModel = mValues.get(position);
        holder.serviceName.setText(serviceModel.getName());
        holder.loader.setVisibility(View.GONE);
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView serviceName;
        ImageView serviceThumbnail;
        LinearLayout mClickView;
        ProgressBar loader;

        public ViewHolder(View view) {
            super(view);
            serviceName = view.findViewById(R.id.service_name);
            serviceThumbnail = view.findViewById(R.id.service_thumbnail);
            loader = view.findViewById(R.id.loader);
            mClickView = view.findViewById(R.id.click_view);
            mClickView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            mCallbacks.invoke(mValues.get(getAdapterPosition()).getSlug());
        }
    }
}

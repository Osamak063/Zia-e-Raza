package com.example.osamakhalid.zia_e_raza.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.osamakhalid.zia_e_raza.R;
import com.example.osamakhalid.zia_e_raza.ui.callbacks.ServiceAdapterCallbacks;
import com.example.osamakhalid.zia_e_raza.ui.model.FeatureProduct;
import com.example.osamakhalid.zia_e_raza.ui.model.ServiceModel;

import java.util.List;

/**
 * Created by Osama Khalid on 8/31/2018.
 */

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.MyViewHolder> {
    public ServiceAdapterCallbacks mCallbacks;
    private Context mContext;
    private List<FeatureProduct> mValues;


    public FeaturedAdapter(Context context, ServiceAdapterCallbacks callbacks, List<FeatureProduct> items) {
        mCallbacks = callbacks;
        mContext = context;
        mValues = items;
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public FeatureProduct getValueAt(int position) {
        return mValues.get(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final FeaturedAdapter.MyViewHolder holder, final int position) {
        final FeatureProduct featureProduct = mValues.get(position);
        holder.featuredProductName.setText(featureProduct.getName());
        Glide.with(mContext).load(featureProduct.getThumb()).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                holder.loader.setVisibility(View.VISIBLE);
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                holder.loader.setVisibility(View.GONE);
                return false;
            }
        }).into(holder.featuredThumbnail);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView featuredProductName;
        ImageView featuredThumbnail;
        LinearLayout mClickView;
        ProgressBar loader;

        public MyViewHolder(View view) {
            super(view);
            featuredProductName = view.findViewById(R.id.service_name);
            featuredThumbnail = view.findViewById(R.id.service_thumbnail);
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

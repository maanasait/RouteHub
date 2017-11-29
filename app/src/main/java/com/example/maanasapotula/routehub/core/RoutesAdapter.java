package com.example.maanasapotula.routehub.core;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.maanasapotula.routehub.R;
import com.example.maanasapotula.routehub.model.Route;
import java.util.List;

/**
 * Created by maanasa.potula on 11/27/17.
 */

public class RoutesAdapter extends RecyclerView.Adapter<RoutesAdapter.ViewHolder> {

  private Context mContext;
  private List<Route> mRoutesList;
  private RouteListener mRouteListener;

  public RoutesAdapter(RouteListener routeListener) {
    mRouteListener = routeListener;
  }

  public void setRoutesList(List<Route> routesList) {
    this.mRoutesList = routesList;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    mContext = parent.getContext();
    View v =
        LayoutInflater.from(parent.getContext())
            .inflate(R.layout.route_list_item, parent, false);
    return new ViewHolder(v);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final Route route = mRoutesList.get(position);
    //holder.mRouteImg.setImageResource();
    Glide.with(mContext).load(route.getImage()).placeholder(R.mipmap.ic_launcher).into(holder.mRouteImg);
    holder.mRouteName.setText(route.getName());
    holder.mRouteName.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        mRouteListener.routeInfo(route);
      }
    });
  }

  @Override
  public int getItemCount() {
    return mRoutesList != null ? mRoutesList.size() : 0;
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {

    ImageView mRouteImg;
    TextView mRouteName;

    public ViewHolder(View itemView) {
      super(itemView);
      mRouteImg = (ImageView) itemView.findViewById(R.id.img_route);
      mRouteName = (TextView) itemView.findViewById(R.id.txt_routeName);
    }
  }

  public interface RouteListener {

    void routeInfo(Route route);
  }
}

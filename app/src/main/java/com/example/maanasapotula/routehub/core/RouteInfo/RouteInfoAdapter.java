package com.example.maanasapotula.routehub.core.RouteInfo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.maanasapotula.routehub.R;
import com.example.maanasapotula.routehub.core.RouteInfo.RouteInfoAdapter.ViewHolder;
import com.example.maanasapotula.routehub.model.Stop;
import java.util.List;

/**
 * Created by maanasa.potula on 11/28/17.
 */

public class RouteInfoAdapter extends RecyclerView.Adapter<ViewHolder> {

  private Context mContext;
  private List<Stop> mStopsList;

  RouteInfoAdapter(List<Stop> stopsList) {
    mStopsList = stopsList;
  }

  @Override
  public RouteInfoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    mContext = parent.getContext();
    View v =
        LayoutInflater.from(parent.getContext())
            .inflate(R.layout.stop_item, parent, false);
    return new RouteInfoAdapter.ViewHolder(v);
  }

  @Override
  public void onBindViewHolder(RouteInfoAdapter.ViewHolder holder, int position) {

    holder.mStopName.setText(mStopsList.get(position).getName());
    if (position == mStopsList.size() - 1) {
      holder.mStopLine.setVisibility(View.GONE);
    }
  }

  @Override
  public int getItemCount() {
    return mStopsList.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {

    ImageView mStopLine;
    TextView mStopName;

    public ViewHolder(View itemView) {
      super(itemView);
      mStopLine = (ImageView) itemView.findViewById(R.id.line);
      mStopName = (TextView) itemView.findViewById(R.id.txt_stopName);
    }
  }
}

package com.example.maanasapotula.routehub.core.RouteInfo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.maanasapotula.routehub.R;
import com.example.maanasapotula.routehub.model.Route;

/**
 * Created by maanasa.potula on 11/28/17.
 */

public class RouteInfoFragment extends Fragment {

  private static Route mRoute;

  private ImageView mRouteImage, mAccessibility;
  private TextView mRoutename, mRouteDesc;
  private RecyclerView mRouteInfoView;

  public RouteInfoFragment() {

  }

  public static RouteInfoFragment getInstance(Route route) {
    mRoute = route;
    return new RouteInfoFragment();
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.route_info, container, false);
    return view;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    init(view);
  }

  private void init(View v) {
    Glide.with(getActivity()).load(mRoute.getImage()).placeholder(R.mipmap.ic_launcher)
        .into((ImageView) v.findViewById(R.id.img_routeinfo));
    mAccessibility = (ImageView) v.findViewById(R.id.img_accesibility);
    if (Boolean.parseBoolean(mRoute.getAccessible())) {
      mAccessibility.setVisibility(View.VISIBLE);
    } else {
      mAccessibility.setVisibility(View.GONE);
    }

    ((TextView) v.findViewById(R.id.txt_routeInfoNameDes)).setText(mRoute.getDescription());
    mRouteInfoView = (RecyclerView) v.findViewById(R.id.rlv_routesDirection);
    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    mRouteInfoView.setLayoutManager(layoutManager);
    RouteInfoAdapter adapter = new RouteInfoAdapter(mRoute.getStops());
    mRouteInfoView.setAdapter(adapter);
  }
}

package com.example.maanasapotula.routehub.core;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import com.example.maanasapotula.routehub.R;
import com.example.maanasapotula.routehub.app.RouteApp;
import com.example.maanasapotula.routehub.core.RouteInfo.RouteInfoFragment;
import com.example.maanasapotula.routehub.core.RoutesAdapter.RouteListener;
import com.example.maanasapotula.routehub.model.Route;
import com.example.maanasapotula.routehub.model.Routes;
import java.util.List;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.View, RouteListener {

  RecyclerView mRoutesListView;
  RoutesAdapter adapter;

  @Inject
  MainPresenter mMainPresenter;
  private FrameLayout layout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mRoutesListView = (RecyclerView) findViewById(R.id.rlv_routes);
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    mRoutesListView.setLayoutManager(layoutManager);

    DaggerMainComponent.builder()
        .netComponent(((RouteApp) getApplicationContext()).getNetComponent())
        .mainModule(new MainModule(this))
        .build().inject(this);

    mMainPresenter.loadRoutes();
  }

  @Override
  public void showRoutes(Routes routes) {
    adapter = new RoutesAdapter(this);
    adapter.setRoutesList(routes.getRoutes());
    mRoutesListView.setAdapter(adapter);
    //adapter.notifyDataSetChanged();
  }

  @Override
  public void routeInfo(Route route) {
    /*FrameLayout layout = (FrameLayout) findViewById(R.id.list_container);
    layout.removeAllViews();*/
    getFragmentManager().beginTransaction()
        .add(R.id.list_container, RouteInfoFragment.getInstance(route), "RouteInfoFragment").addToBackStack("RouteInfoFragment").commit();
  }

  @Override
  public void onBackPressed() {
    Fragment fragment = getFragmentManager().findFragmentById(R.id.list_container);
    if (fragment != null && fragment instanceof RouteInfoFragment) {
      getFragmentManager().popBackStack("RouteInfoFragment", FragmentManager.POP_BACK_STACK_INCLUSIVE);
      return;
    } else {
      super.onBackPressed();
    }
    mMainPresenter.onBackPressed();
  }
}

package com.example.maanasapotula.routehub.core;

import android.util.Log;
import com.example.maanasapotula.routehub.app.ApiService;
import com.example.maanasapotula.routehub.core.MainContract.Presenter;
import com.example.maanasapotula.routehub.model.Route;
import com.example.maanasapotula.routehub.model.Routes;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Retrofit;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by maanasa.potula on 11/27/17.
 */

public class MainPresenter implements Presenter {

  public Retrofit retrofit;
  MainContract.View mView;

  @Inject
  public MainPresenter(Retrofit retrofit, MainContract.View mView) {
    this.retrofit = retrofit;
    this.mView = mView;
  }

  @Override
  public void loadRoutes() {
    retrofit.create(ApiService.class).loadRoutesList().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .unsubscribeOn(Schedulers.io())
        .subscribe(new Observer<Routes>() {
          @Override
          public void onCompleted() {
            Log.d("Routes App", "** onCompleted");
          }

          @Override
          public void onError(Throwable e) {
            Log.d("Routes App", "** onError-" + e.getMessage());
          }

          @Override
          public void onNext(Routes routes) {
            Log.d("Routes App", "** onNext");
            mView.showRoutes(routes);
          }

        });
  }

  @Override
  public void onBackPressed() {

  }
}

package com.example.maanasapotula.routehub.app;

import android.app.Application;
import com.example.maanasapotula.routehub.data.DaggerNetComponent;
import com.example.maanasapotula.routehub.data.NetComponent;
import com.example.maanasapotula.routehub.data.NetModule;

/**
 * Created by maanasa.potula on 11/27/17.
 */

public class RouteApp extends Application {

  private NetComponent mNetComponent;

  @Override
  public void onCreate() {
    super.onCreate();

    mNetComponent = DaggerNetComponent.builder()
        .appModule(new AppModule(this))
        .netModule(new NetModule("http://www.mocky.io/"))
        .build();

  }

  public NetComponent getNetComponent() {
    return mNetComponent;
  }
}

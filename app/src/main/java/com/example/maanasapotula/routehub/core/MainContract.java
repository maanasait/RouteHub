package com.example.maanasapotula.routehub.core;

import com.example.maanasapotula.routehub.model.Routes;

/**
 * Created by maanasa.potula on 11/27/17.
 */

public interface MainContract {

  interface View {

    void showRoutes(Routes routes);

  }

  interface Presenter {

    void loadRoutes();
    void onBackPressed();
  }

}

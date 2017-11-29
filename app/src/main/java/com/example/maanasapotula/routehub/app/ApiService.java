package com.example.maanasapotula.routehub.app;

import com.example.maanasapotula.routehub.model.Routes;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by maanasa.potula on 11/27/17.
 */

public interface ApiService {

  @GET("v2/5808f00d10000005074c6340/")
  Observable<Routes> loadRoutesList();
}

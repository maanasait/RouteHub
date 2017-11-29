package com.example.maanasapotula.routehub.data;

import com.example.maanasapotula.routehub.app.AppModule;
import com.example.maanasapotula.routehub.util.NetScope;
import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by maanasa.potula on 11/27/17.
 */
@NetScope
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {

  Retrofit retrofit();
}

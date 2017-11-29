package com.example.maanasapotula.routehub.core;

import com.example.maanasapotula.routehub.util.MainScope;
import dagger.Module;
import dagger.Provides;

/**
 * Created by maanasa.potula on 11/27/17.
 */

@Module
public class MainModule {

  private final MainContract.View mView;


  public MainModule(MainContract.View mView) {
    this.mView = mView;
  }

  @Provides
  @MainScope
  public MainContract.View providesMainView() {
    return mView;
  }

}

package com.example.maanasapotula.routehub.app;

import android.app.Application;
import com.example.maanasapotula.routehub.util.NetScope;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by maanasa.potula on 11/27/17.
 */

@Module
public class AppModule {
  Application mApplication;

  public AppModule(Application mApplication) {
    this.mApplication = mApplication;
  }

  @Provides
  @NetScope
  Application provideApplication() {
    return mApplication;
  }
}

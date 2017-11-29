package com.example.maanasapotula.routehub.core;

import com.example.maanasapotula.routehub.data.NetComponent;
import com.example.maanasapotula.routehub.util.MainScope;
import dagger.Component;
import dagger.Module;

/**
 * Created by maanasa.potula on 11/27/17.
 */

@MainScope
@Component(modules = {MainModule.class}, dependencies = {NetComponent.class})
public interface MainComponent {

  void inject(MainActivity activity);
}

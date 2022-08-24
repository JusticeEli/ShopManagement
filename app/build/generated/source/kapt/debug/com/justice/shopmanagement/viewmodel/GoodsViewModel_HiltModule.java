package com.justice.shopmanagement.viewmodel;

import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.codegen.OriginatingElement;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import javax.annotation.Generated;

@Generated("androidx.hilt.AndroidXHiltProcessor")
@Module
@InstallIn(ActivityRetainedComponent.class)
@OriginatingElement(
    topLevelClass = GoodsViewModel.class
)
public interface GoodsViewModel_HiltModule {
  @Binds
  @IntoMap
  @StringKey("com.justice.shopmanagement.viewmodel.GoodsViewModel")
  ViewModelAssistedFactory<? extends ViewModel> bind(GoodsViewModel_AssistedFactory factory);
}

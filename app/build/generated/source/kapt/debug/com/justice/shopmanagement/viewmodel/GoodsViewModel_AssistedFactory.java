package com.justice.shopmanagement.viewmodel;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.SavedStateHandle;
import com.justice.shopmanagement.repository.ShopRepository;
import java.lang.Override;
import javax.annotation.Generated;
import javax.inject.Inject;
import javax.inject.Provider;

@Generated("androidx.hilt.AndroidXHiltProcessor")
public final class GoodsViewModel_AssistedFactory implements ViewModelAssistedFactory<GoodsViewModel> {
  private final Provider<ShopRepository> repository;

  @Inject
  GoodsViewModel_AssistedFactory(Provider<ShopRepository> repository) {
    this.repository = repository;
  }

  @Override
  @NonNull
  public GoodsViewModel create(SavedStateHandle arg0) {
    return new GoodsViewModel(repository.get());
  }
}

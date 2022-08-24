package com.justice.shopmanagement.viewmodel;

import com.justice.shopmanagement.repository.ShopRepository;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class GoodsViewModel_AssistedFactory_Factory implements Factory<GoodsViewModel_AssistedFactory> {
  private final Provider<ShopRepository> repositoryProvider;

  public GoodsViewModel_AssistedFactory_Factory(Provider<ShopRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GoodsViewModel_AssistedFactory get() {
    return newInstance(repositoryProvider);
  }

  public static GoodsViewModel_AssistedFactory_Factory create(
      Provider<ShopRepository> repositoryProvider) {
    return new GoodsViewModel_AssistedFactory_Factory(repositoryProvider);
  }

  public static GoodsViewModel_AssistedFactory newInstance(Provider<ShopRepository> repository) {
    return new GoodsViewModel_AssistedFactory(repository);
  }
}

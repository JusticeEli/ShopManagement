package com.justice.shopmanagement.di;

import com.justice.shopmanagement.data.remote.ShopManagerService;
import com.justice.shopmanagement.repository.ShopRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AppModule_ProvideShopRepositoryFactory implements Factory<ShopRepository> {
  private final Provider<ShopManagerService> serviceProvider;

  public AppModule_ProvideShopRepositoryFactory(Provider<ShopManagerService> serviceProvider) {
    this.serviceProvider = serviceProvider;
  }

  @Override
  public ShopRepository get() {
    return provideShopRepository(serviceProvider.get());
  }

  public static AppModule_ProvideShopRepositoryFactory create(
      Provider<ShopManagerService> serviceProvider) {
    return new AppModule_ProvideShopRepositoryFactory(serviceProvider);
  }

  public static ShopRepository provideShopRepository(ShopManagerService service) {
    return Preconditions.checkNotNull(AppModule.INSTANCE.provideShopRepository(service), "Cannot return null from a non-@Nullable @Provides method");
  }
}

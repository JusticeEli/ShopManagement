package com.justice.shopmanagement.di;

import com.justice.shopmanagement.data.remote.ShopManagerService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvideRetrofitServiceFactory implements Factory<ShopManagerService> {
  @Override
  public ShopManagerService get() {
    return provideRetrofitService();
  }

  public static AppModule_ProvideRetrofitServiceFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ShopManagerService provideRetrofitService() {
    return Preconditions.checkNotNull(AppModule.INSTANCE.provideRetrofitService(), "Cannot return null from a non-@Nullable @Provides method");
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideRetrofitServiceFactory INSTANCE = new AppModule_ProvideRetrofitServiceFactory();
  }
}

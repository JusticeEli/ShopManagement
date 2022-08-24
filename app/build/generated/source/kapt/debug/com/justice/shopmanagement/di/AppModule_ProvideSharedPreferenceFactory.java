package com.justice.shopmanagement.di;

import android.content.Context;
import android.content.SharedPreferences;
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
public final class AppModule_ProvideSharedPreferenceFactory implements Factory<SharedPreferences> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideSharedPreferenceFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public SharedPreferences get() {
    return provideSharedPreference(contextProvider.get());
  }

  public static AppModule_ProvideSharedPreferenceFactory create(Provider<Context> contextProvider) {
    return new AppModule_ProvideSharedPreferenceFactory(contextProvider);
  }

  public static SharedPreferences provideSharedPreference(Context context) {
    return Preconditions.checkNotNull(AppModule.INSTANCE.provideSharedPreference(context), "Cannot return null from a non-@Nullable @Provides method");
  }
}

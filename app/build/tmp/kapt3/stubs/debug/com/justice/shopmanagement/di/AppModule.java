package com.justice.shopmanagement.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.android.components.ApplicationComponent.class})
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u001a\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007\u00a8\u0006\r"}, d2 = {"Lcom/justice/shopmanagement/di/AppModule;", "", "()V", "provideRetrofitService", "Lcom/justice/shopmanagement/data/remote/ShopManagerService;", "provideSharedPreference", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "provideShopRepository", "Lcom/justice/shopmanagement/repository/ShopRepository;", "service", "app_debug"})
@dagger.Module()
public final class AppModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.justice.shopmanagement.di.AppModule INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.justice.shopmanagement.data.remote.ShopManagerService provideRetrofitService() {
        return null;
    }
    
    @javax.inject.Singleton()
    @dagger.Provides()
    public final android.content.SharedPreferences provideSharedPreference(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.justice.shopmanagement.repository.ShopRepository provideShopRepository(@org.jetbrains.annotations.NotNull()
    com.justice.shopmanagement.data.remote.ShopManagerService service) {
        return null;
    }
    
    private AppModule() {
        super();
    }
}
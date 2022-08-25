package com.justice.shopmanagement.alldata;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.hilt.lifecycle.ViewModelFactoryModules_ActivityModule_ProvideFactoryFactory;
import androidx.hilt.lifecycle.ViewModelFactoryModules_FragmentModule_ProvideFactoryFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.justice.shopmanagement.HiltTestActivity;
import com.justice.shopmanagement.data.remote.ShopManagerService;
import com.justice.shopmanagement.di.AppModule;
import com.justice.shopmanagement.di.AppModule_ProvideRetrofitServiceFactory;
import com.justice.shopmanagement.di.AppModule_ProvideShopRepositoryFactory;
import com.justice.shopmanagement.repository.ShopRepository;
import com.justice.shopmanagement.ui.FirstPageActivity;
import com.justice.shopmanagement.ui.MainActivity;
import com.justice.shopmanagement.ui.goods.AddGoodsFragment;
import com.justice.shopmanagement.ui.goods.EditGoodsActivity;
import com.justice.shopmanagement.ui.goods.GoodsFragment;
import com.justice.shopmanagement.viewmodel.GoodsViewModel_AssistedFactory;
import com.justice.shopmanagement.viewmodel.GoodsViewModel_AssistedFactory_Factory;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideApplicationFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.MemoizedSentinel;
import dagger.internal.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
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
public final class DaggerApplicationClass_HiltComponents_SingletonC extends ApplicationClass_HiltComponents.SingletonC {
  private final ApplicationContextModule applicationContextModule;

  private volatile Object shopManagerService = new MemoizedSentinel();

  private volatile Object shopRepository = new MemoizedSentinel();

  private volatile Provider<ShopRepository> provideShopRepositoryProvider;

  private DaggerApplicationClass_HiltComponents_SingletonC(
      ApplicationContextModule applicationContextModuleParam) {
    this.applicationContextModule = applicationContextModuleParam;
  }

  public static Builder builder() {
    return new Builder();
  }

  private ShopManagerService getShopManagerService() {
    Object local = shopManagerService;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = shopManagerService;
        if (local instanceof MemoizedSentinel) {
          local = AppModule_ProvideRetrofitServiceFactory.provideRetrofitService();
          shopManagerService = DoubleCheck.reentrantCheck(shopManagerService, local);
        }
      }
    }
    return (ShopManagerService) local;
  }

  private ShopRepository getShopRepository() {
    Object local = shopRepository;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = shopRepository;
        if (local instanceof MemoizedSentinel) {
          local = AppModule_ProvideShopRepositoryFactory.provideShopRepository(getShopManagerService());
          shopRepository = DoubleCheck.reentrantCheck(shopRepository, local);
        }
      }
    }
    return (ShopRepository) local;
  }

  private Provider<ShopRepository> getShopRepositoryProvider() {
    Object local = provideShopRepositoryProvider;
    if (local == null) {
      local = new SwitchingProvider<>(0);
      provideShopRepositoryProvider = (Provider<ShopRepository>) local;
    }
    return (Provider<ShopRepository>) local;
  }

  @Override
  public void injectApplicationClass(ApplicationClass applicationClass) {
  }

  @Override
  public ActivityRetainedComponentBuilder retainedComponentBuilder() {
    return new ActivityRetainedCBuilder();
  }

  @Override
  public ServiceComponentBuilder serviceComponentBuilder() {
    return new ServiceCBuilder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder appModule(AppModule appModule) {
      Preconditions.checkNotNull(appModule);
      return this;
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public ApplicationClass_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new DaggerApplicationClass_HiltComponents_SingletonC(applicationContextModule);
    }
  }

  private final class ActivityRetainedCBuilder implements ApplicationClass_HiltComponents.ActivityRetainedC.Builder {
    @Override
    public ApplicationClass_HiltComponents.ActivityRetainedC build() {
      return new ActivityRetainedCImpl();
    }
  }

  private final class ActivityRetainedCImpl extends ApplicationClass_HiltComponents.ActivityRetainedC {
    private ActivityRetainedCImpl() {

    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder();
    }

    private final class ActivityCBuilder implements ApplicationClass_HiltComponents.ActivityC.Builder {
      private Activity activity;

      @Override
      public ActivityCBuilder activity(Activity activity) {
        this.activity = Preconditions.checkNotNull(activity);
        return this;
      }

      @Override
      public ApplicationClass_HiltComponents.ActivityC build() {
        Preconditions.checkBuilderRequirement(activity, Activity.class);
        return new ActivityCImpl(activity);
      }
    }

    private final class ActivityCImpl extends ApplicationClass_HiltComponents.ActivityC {
      private final Activity activity;

      private volatile Provider<GoodsViewModel_AssistedFactory> goodsViewModel_AssistedFactoryProvider;

      private ActivityCImpl(Activity activityParam) {
        this.activity = activityParam;
      }

      private GoodsViewModel_AssistedFactory getGoodsViewModel_AssistedFactory() {
        return GoodsViewModel_AssistedFactory_Factory.newInstance(DaggerApplicationClass_HiltComponents_SingletonC.this.getShopRepositoryProvider());
      }

      private Provider<GoodsViewModel_AssistedFactory> getGoodsViewModel_AssistedFactoryProvider() {
        Object local = goodsViewModel_AssistedFactoryProvider;
        if (local == null) {
          local = new SwitchingProvider<>(0);
          goodsViewModel_AssistedFactoryProvider = (Provider<GoodsViewModel_AssistedFactory>) local;
        }
        return (Provider<GoodsViewModel_AssistedFactory>) local;
      }

      private Map<String, Provider<ViewModelAssistedFactory<? extends ViewModel>>> getMapOfStringAndProviderOfViewModelAssistedFactoryOf(
          ) {
        return Collections.<String, Provider<ViewModelAssistedFactory<? extends ViewModel>>>singletonMap("com.justice.shopmanagement.viewmodel.GoodsViewModel", (Provider) getGoodsViewModel_AssistedFactoryProvider());
      }

      private ViewModelProvider.Factory getProvideFactory() {
        return ViewModelFactoryModules_ActivityModule_ProvideFactoryFactory.provideFactory(activity, ApplicationContextModule_ProvideApplicationFactory.provideApplication(DaggerApplicationClass_HiltComponents_SingletonC.this.applicationContextModule), getMapOfStringAndProviderOfViewModelAssistedFactoryOf());
      }

      @Override
      public void injectHiltTestActivity(HiltTestActivity arg0) {
      }

      @Override
      public void injectMainActivity(MainActivity arg0) {
      }

      @Override
      public Set<ViewModelProvider.Factory> getActivityViewModelFactory() {
        return Collections.<ViewModelProvider.Factory>singleton(getProvideFactory());
      }

      @Override
      public FragmentComponentBuilder fragmentComponentBuilder() {
        return new FragmentCBuilder();
      }

      @Override
      public ViewComponentBuilder viewComponentBuilder() {
        return new ViewCBuilder();
      }

      private final class FragmentCBuilder implements ApplicationClass_HiltComponents.FragmentC.Builder {
        private Fragment fragment;

        @Override
        public FragmentCBuilder fragment(Fragment fragment) {
          this.fragment = Preconditions.checkNotNull(fragment);
          return this;
        }

        @Override
        public ApplicationClass_HiltComponents.FragmentC build() {
          Preconditions.checkBuilderRequirement(fragment, Fragment.class);
          return new FragmentCImpl(fragment);
        }
      }

      private final class FragmentCImpl extends ApplicationClass_HiltComponents.FragmentC {
        private final Fragment fragment;

        private FragmentCImpl(Fragment fragmentParam) {
          this.fragment = fragmentParam;
        }

        private ViewModelProvider.Factory getProvideFactory() {
          return ViewModelFactoryModules_FragmentModule_ProvideFactoryFactory.provideFactory(fragment, ApplicationContextModule_ProvideApplicationFactory.provideApplication(DaggerApplicationClass_HiltComponents_SingletonC.this.applicationContextModule), ActivityCImpl.this.getMapOfStringAndProviderOfViewModelAssistedFactoryOf());
        }

        @Override
        public void injectFirstPageActivity(FirstPageActivity arg0) {
        }

        @Override
        public void injectAddGoodsFragment(AddGoodsFragment addGoodsFragment) {
        }

        @Override
        public void injectEditGoodsActivity(EditGoodsActivity arg0) {
        }

        @Override
        public void injectGoodsFragment(GoodsFragment arg0) {
        }

        @Override
        public Set<ViewModelProvider.Factory> getFragmentViewModelFactory() {
          return Collections.<ViewModelProvider.Factory>singleton(getProvideFactory());
        }

        @Override
        public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
          return new ViewWithFragmentCBuilder();
        }

        private final class ViewWithFragmentCBuilder implements ApplicationClass_HiltComponents.ViewWithFragmentC.Builder {
          private View view;

          @Override
          public ViewWithFragmentCBuilder view(View view) {
            this.view = Preconditions.checkNotNull(view);
            return this;
          }

          @Override
          public ApplicationClass_HiltComponents.ViewWithFragmentC build() {
            Preconditions.checkBuilderRequirement(view, View.class);
            return new ViewWithFragmentCImpl(view);
          }
        }

        private final class ViewWithFragmentCImpl extends ApplicationClass_HiltComponents.ViewWithFragmentC {
          private ViewWithFragmentCImpl(View view) {

          }
        }
      }

      private final class ViewCBuilder implements ApplicationClass_HiltComponents.ViewC.Builder {
        private View view;

        @Override
        public ViewCBuilder view(View view) {
          this.view = Preconditions.checkNotNull(view);
          return this;
        }

        @Override
        public ApplicationClass_HiltComponents.ViewC build() {
          Preconditions.checkBuilderRequirement(view, View.class);
          return new ViewCImpl(view);
        }
      }

      private final class ViewCImpl extends ApplicationClass_HiltComponents.ViewC {
        private ViewCImpl(View view) {

        }
      }

      private final class SwitchingProvider<T> implements Provider<T> {
        private final int id;

        SwitchingProvider(int id) {
          this.id = id;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T get() {
          switch (id) {
            case 0: // com.justice.shopmanagement.viewmodel.GoodsViewModel_AssistedFactory 
            return (T) ActivityCImpl.this.getGoodsViewModel_AssistedFactory();

            default: throw new AssertionError(id);
          }
        }
      }
    }
  }

  private final class ServiceCBuilder implements ApplicationClass_HiltComponents.ServiceC.Builder {
    private Service service;

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public ApplicationClass_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(service);
    }
  }

  private final class ServiceCImpl extends ApplicationClass_HiltComponents.ServiceC {
    private ServiceCImpl(Service service) {

    }
  }

  private final class SwitchingProvider<T> implements Provider<T> {
    private final int id;

    SwitchingProvider(int id) {
      this.id = id;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get() {
      switch (id) {
        case 0: // com.justice.shopmanagement.repository.ShopRepository 
        return (T) DaggerApplicationClass_HiltComponents_SingletonC.this.getShopRepository();

        default: throw new AssertionError(id);
      }
    }
  }
}

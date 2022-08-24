package com.justice.shopmanagement.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0010\u0010\u0011\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0012\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/justice/shopmanagement/viewmodel/GoodsViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/justice/shopmanagement/repository/ShopRepository;", "(Lcom/justice/shopmanagement/repository/ShopRepository;)V", "TAG", "", "allGoods", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/justice/shopmanagement/model/Goods;", "getAllGoods", "()Landroidx/lifecycle/MutableLiveData;", "delete", "", "goods", "deleteAllGoods", "insert", "update", "app_debug"})
public final class GoodsViewModel extends androidx.lifecycle.ViewModel {
    private final java.lang.String TAG = "GoodsViewModel";
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.justice.shopmanagement.model.Goods>> allGoods = null;
    private final com.justice.shopmanagement.repository.ShopRepository repository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.justice.shopmanagement.model.Goods>> getAllGoods() {
        return null;
    }
    
    public final void insert(@org.jetbrains.annotations.Nullable()
    com.justice.shopmanagement.model.Goods goods) {
    }
    
    public final void update(@org.jetbrains.annotations.Nullable()
    com.justice.shopmanagement.model.Goods goods) {
    }
    
    public final void delete(@org.jetbrains.annotations.Nullable()
    com.justice.shopmanagement.model.Goods goods) {
    }
    
    public final void deleteAllGoods() {
    }
    
    @androidx.hilt.lifecycle.ViewModelInject()
    public GoodsViewModel(@org.jetbrains.annotations.NotNull()
    com.justice.shopmanagement.repository.ShopRepository repository) {
        super();
    }
}
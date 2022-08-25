package com.justice.shopmanagement.data.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\'\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\'\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\'\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/justice/shopmanagement/data/remote/ShopManagerService;", "", "delete", "Lretrofit2/Response;", "", "Lcom/justice/shopmanagement/model/Goods;", "goods", "(Lcom/justice/shopmanagement/model/Goods;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "initialize", "insertGoods", "update", "app_debug"})
public abstract interface ShopManagerService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "initialize")
    public abstract java.lang.Object initialize(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.justice.shopmanagement.model.Goods>>> p0);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "insert_goods")
    public abstract java.lang.Object insertGoods(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.justice.shopmanagement.model.Goods goods, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.justice.shopmanagement.model.Goods>>> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "update")
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.justice.shopmanagement.model.Goods goods, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.justice.shopmanagement.model.Goods>>> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "delete")
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.justice.shopmanagement.model.Goods goods, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.justice.shopmanagement.model.Goods>>> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "get_all")
    public abstract java.lang.Object getAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.justice.shopmanagement.model.Goods>>> p0);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "delete_all")
    public abstract java.lang.Object deleteAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.justice.shopmanagement.model.Goods>>> p0);
}
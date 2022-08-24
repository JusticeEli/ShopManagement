package com.justice.shopmanagement.data.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\'\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00032\b\b\u0001\u0010\u000b\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/justice/shopmanagement/data/remote/ShopManagerService;", "", "initialize", "Lretrofit2/Response;", "", "jsonObject", "Lcom/google/gson/JsonObject;", "(Lcom/google/gson/JsonObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertGoods", "", "Lcom/justice/shopmanagement/model/Goods;", "goods", "(Lcom/justice/shopmanagement/model/Goods;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ShopManagerService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "initialize")
    public abstract java.lang.Object initialize(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.google.gson.JsonObject jsonObject, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.lang.String>> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "insert_goods")
    public abstract java.lang.Object insertGoods(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.justice.shopmanagement.model.Goods goods, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.justice.shopmanagement.model.Goods>>> p1);
}
package com.justice.shopmanagement.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\'\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/justice/shopmanagement/repository/SolanaRepository;", "Lcom/justice/shopmanagement/repository/ShopRepository;", "service", "Lcom/justice/shopmanagement/data/remote/ShopManagerService;", "(Lcom/justice/shopmanagement/data/remote/ShopManagerService;)V", "initialize", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "Lretrofit2/Response;", "", "Lcom/justice/shopmanagement/model/Goods;", "goods", "(Lcom/justice/shopmanagement/model/Goods;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class SolanaRepository implements com.justice.shopmanagement.repository.ShopRepository {
    private final com.justice.shopmanagement.data.remote.ShopManagerService service = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object initialize(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object insert(@org.jetbrains.annotations.Nullable()
    com.justice.shopmanagement.model.Goods goods, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.justice.shopmanagement.model.Goods>>> p1) {
        return null;
    }
    
    public SolanaRepository(@org.jetbrains.annotations.NotNull()
    com.justice.shopmanagement.data.remote.ShopManagerService service) {
        super();
    }
}
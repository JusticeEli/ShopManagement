package com.justice.shopmanagement.ui.goods;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\u001a\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u0018H\u0002J\b\u0010*\u001a\u00020\u0018H\u0002J\b\u0010+\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006,"}, d2 = {"Lcom/justice/shopmanagement/ui/goods/GoodsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "TAG", "", "binding", "Lcom/justice/shopmanagement/databinding/FragmentGoodsBinding;", "getBinding", "()Lcom/justice/shopmanagement/databinding/FragmentGoodsBinding;", "setBinding", "(Lcom/justice/shopmanagement/databinding/FragmentGoodsBinding;)V", "goodsAdapter", "Lcom/justice/shopmanagement/goods/GoodsFragmentRecyclerAdapter;", "getGoodsAdapter", "()Lcom/justice/shopmanagement/goods/GoodsFragmentRecyclerAdapter;", "setGoodsAdapter", "(Lcom/justice/shopmanagement/goods/GoodsFragmentRecyclerAdapter;)V", "viewModel", "Lcom/justice/shopmanagement/ui/goods/GoodsViewModel;", "getViewModel", "()Lcom/justice/shopmanagement/ui/goods/GoodsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onEdit", "good", "Lcom/justice/shopmanagement/model/Goods;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setOnClickListeners", "setUpRecyclerView", "subScribeToObservers", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class GoodsFragment extends androidx.fragment.app.Fragment {
    public com.justice.shopmanagement.databinding.FragmentGoodsBinding binding;
    public com.justice.shopmanagement.goods.GoodsFragmentRecyclerAdapter goodsAdapter;
    private final kotlin.Lazy viewModel$delegate = null;
    private final java.lang.String TAG = "GoodsFragment";
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.justice.shopmanagement.databinding.FragmentGoodsBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.justice.shopmanagement.databinding.FragmentGoodsBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.justice.shopmanagement.goods.GoodsFragmentRecyclerAdapter getGoodsAdapter() {
        return null;
    }
    
    public final void setGoodsAdapter(@org.jetbrains.annotations.NotNull()
    com.justice.shopmanagement.goods.GoodsFragmentRecyclerAdapter p0) {
    }
    
    private final com.justice.shopmanagement.ui.goods.GoodsViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void subScribeToObservers() {
    }
    
    private final void setUpRecyclerView() {
    }
    
    private final void onEdit(com.justice.shopmanagement.model.Goods good) {
    }
    
    private final void setOnClickListeners() {
    }
    
    @java.lang.Override()
    public void onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu, @org.jetbrains.annotations.NotNull()
    android.view.MenuInflater inflater) {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    public GoodsFragment() {
        super();
    }
}
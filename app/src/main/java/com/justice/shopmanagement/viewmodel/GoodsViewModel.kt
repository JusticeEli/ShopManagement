package com.justice.shopmanagement.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import com.justice.shopmanagement.repository.ShopRepository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.justice.shopmanagement.model.Goods
import kotlinx.coroutines.launch

class GoodsViewModel @ViewModelInject constructor(private val repository: ShopRepository) :
    ViewModel() {
    private val TAG = "GoodsViewModel"

    val allGoods: MutableLiveData<List<Goods>> = MutableLiveData()

    fun insert(goods: Goods?) {
        try {
            viewModelScope.launch {
                Log.d(TAG, "insert: insert in progress...")

                val resp = repository.insert(goods)
                if (resp.isSuccessful) {
                    allGoods.value = resp.body()
                    Log.d(TAG, "insert: resp:${resp.body()}")

                } else {
                    Log.e(TAG, "insert: ${resp.errorBody()}")
                }
                Log.d(TAG, "insert: insert finished")
            }
        } catch (e: Exception) {
            Log.e(TAG, "insert: ", e)
        }

    }

    fun update(goods: Goods?) {

        //repository.update(goods);
    }

    fun delete(goods: Goods?) {

        // repository.delete(goods);
    }

    fun deleteAllGoods() {

        //repository.deleteAllGoods();
    }


}
package com.justice.shopmanagement.repository

import com.justice.shopmanagement.model.Goods
import retrofit2.Response


interface ShopRepository {

    suspend fun initialize(): Response<List<Goods>>
    suspend fun insert(goods: Goods): Response<List<Goods>>
    suspend fun update(goods: Goods): Response<List<Goods>>
    suspend fun delete(goods: Goods): Response<List<Goods>>
    suspend fun deleteAll(): Response<List<Goods>>
    suspend fun getAll(): Response<List<Goods>>


}
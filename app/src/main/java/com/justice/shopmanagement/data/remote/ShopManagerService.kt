package com.justice.shopmanagement.data.remote

import com.google.gson.JsonObject
import com.justice.shopmanagement.model.Goods
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ShopManagerService {

    @POST("initialize")
    suspend fun initialize(): Response<List<Goods>>

    @POST("insert_goods")
    suspend fun insertGoods(@Body goods: Goods): Response<List<Goods>>

    @POST("update")
    suspend fun update(@Body goods: Goods): Response<List<Goods>>

    @POST("delete")
    suspend fun delete(@Body goods: Goods): Response<List<Goods>>

    @POST("get_all")
    suspend fun getAll(): Response<List<Goods>>
    @POST("delete_all")
    suspend fun deleteAll(): Response<List<Goods>>

}
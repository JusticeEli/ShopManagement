package com.justice.shopmanagement.data.remote

import com.google.gson.JsonObject
import com.justice.shopmanagement.model.Goods
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ShopManagerService {

    @POST("initialize")
    suspend fun initialize(@Body jsonObject: JsonObject): Response<String>

    @POST("insert_goods")
    suspend fun insertGoods(@Body goods: Goods): Response<List<Goods>>

}
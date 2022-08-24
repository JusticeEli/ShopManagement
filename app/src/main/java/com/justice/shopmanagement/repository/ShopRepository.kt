package com.justice.shopmanagement.repository

import com.justice.shopmanagement.model.Goods
import retrofit2.Response


interface ShopRepository {

   suspend fun initialize()
   suspend fun insert(goods: Goods?): Response<List<Goods>>


}
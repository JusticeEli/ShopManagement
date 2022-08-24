package com.justice.shopmanagement.repository

import com.justice.shopmanagement.data.remote.ShopManagerService
import com.justice.shopmanagement.model.Goods
import retrofit2.Response
import javax.inject.Inject

class SolanaRepository constructor( private val service: ShopManagerService):ShopRepository {





    override suspend fun initialize() {
        TODO("Not yet implemented")
    }

    override suspend fun insert(goods: Goods?): Response<List<Goods>> =
      service.insertGoods(goods!!)


}
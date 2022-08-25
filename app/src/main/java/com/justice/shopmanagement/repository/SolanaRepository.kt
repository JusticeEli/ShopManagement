package com.justice.shopmanagement.repository

import com.justice.shopmanagement.data.remote.ShopManagerService
import com.justice.shopmanagement.model.Goods
import retrofit2.Response
import javax.inject.Inject

class SolanaRepository constructor( private val service: ShopManagerService):ShopRepository {





    override suspend fun initialize() =service.initialize()


    override suspend fun update(goods: Goods): Response<List<Goods>> =service.update(goods)

    override suspend fun delete(goods: Goods): Response<List<Goods>> =service.delete(goods)

    override suspend fun deleteAll(): Response<List<Goods>> =service.deleteAll()

    override suspend fun getAll(): Response<List<Goods>> =service.getAll()

    override suspend fun insert(goods: Goods): Response<List<Goods>> = service.insertGoods(goods!!)


}
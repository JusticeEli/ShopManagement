package com.justice.shopmanagement.ui.goods

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.justice.shopmanagement.model.Goods
import com.justice.shopmanagement.repository.ShopRepository
import com.justice.shopmanagement.utils.Resource
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class GoodsViewModel @ViewModelInject constructor(private val repository: ShopRepository) :
    ViewModel() {
    private val TAG = "GoodsViewModel"

    private val _allGoods: MutableLiveData<List<Goods>> = MutableLiveData()
    val allGoods = _allGoods as LiveData<List<Goods>>
    private val _insertGoodsStatus = Channel<Resource<String>>()
    val insertGoodsStatus = _insertGoodsStatus.receiveAsFlow()
    private val _getAllGoodsStatus = Channel<Resource<List<Goods>>>()
    val getAllGoodsStatus = _getAllGoodsStatus.receiveAsFlow()

    fun setEvent(event: Event) {
        viewModelScope.launch {
            when (event) {
                is Event.Initialize -> {
                    try {
                        _initializeGoodsStatus.send(Resource.loading(""))
                        initialize()
                    } catch (e: Exception) {
                        Log.e(TAG, "setEvent: ", e)
                        _initializeGoodsStatus.send(Resource.error(e))
                    }
                }
                is Event.Insert -> {
                    try {
                        _insertGoodsStatus.send(Resource.loading(""))
                        insert(event.good)
                    } catch (e: Exception) {
                        Log.e(TAG, "setEvent: ", e)
                        _insertGoodsStatus.send(Resource.error(e))
                    }
                }
                is Event.Update -> {
                    try {
                        _updateGoodsStatus.send(Resource.loading(""))
                        update(event.good)
                    } catch (e: Exception) {
                        Log.e(TAG, "setEvent: ", e)
                        _updateGoodsStatus.send(Resource.error(e))
                    }
                }
                is Event.Delete -> {
                    try {
                        _deleteGoodsStatus.send(Resource.loading(""))
                        delete(event.good)
                    } catch (e: Exception) {
                        Log.e(TAG, "setEvent: ", e)
                        _deleteGoodsStatus.send(Resource.error(e))
                    }
                }
                is Event.DeleteAll -> {
                    try {
                        _deleteAllGoodsStatus.send(Resource.loading(""))
                        deleteAll()
                    } catch (e: Exception) {
                        Log.e(TAG, "setEvent: ", e)
                        _deleteAllGoodsStatus.send(Resource.error(e))
                    }
                }
                is Event.GetAll -> {
                    try {
                        _getAllGoodsStatus.send(Resource.loading(""))
                        getAll()
                    } catch (e: Exception) {
                        Log.e(TAG, "setEvent: ", e)
                        _getAllGoodsStatus.send(Resource.error(e))
                    }
                }
            }
        }
    }


    private val _initializeGoodsStatus = Channel<Resource<String>>()
    val initializeGoodsStatus = _initializeGoodsStatus.receiveAsFlow()

    private suspend fun initialize() {
        Log.d(TAG, "initialize: initialize in progress...")

        val resp = repository.initialize()
        if (resp.isSuccessful) {
            Log.d(TAG, "initialize: resp:${resp.body()}")
            _initializeGoodsStatus.send(Resource.success(""))
        } else {
            val error = resp.errorBody();
            Log.e(TAG, "initialize: $error")
            _initializeGoodsStatus.send(Resource.error(Exception(error.toString())))
        }
    }

    private suspend fun insert(goods: Goods) {
        Log.d(TAG, "insert: insert in progress...")
        if (fieldsAreEmpty(goods)) {
            _insertGoodsStatus.send(Resource.error(Exception("Please Fill All Fields..!!")))
            return
        }
        val resp = repository.insert(goods)
        if (resp.isSuccessful) {
            Log.d(TAG, "insert: resp:${resp.body()}")
            _insertGoodsStatus.send(Resource.success(""))
        } else {
            val error = resp.errorBody();
            Log.e(TAG, "insert: ${error}")
            _insertGoodsStatus.send(Resource.error(Exception(error.toString())))
        }
    }
    private val _updateGoodsStatus = Channel<Resource<String>>()
    val updateGoodsStatus = _updateGoodsStatus.receiveAsFlow()

    private suspend fun update(goods: Goods) {
        Log.d(TAG, "update: update in progress...")
        if (fieldsAreEmpty(goods)) {
            _updateGoodsStatus.send(Resource.error(Exception("Please Fill All Fields..!!")))
            return
        }
        val resp = repository.update(goods)
        if (resp.isSuccessful) {
            Log.d(TAG, "update: resp:${resp.body()}")
            _updateGoodsStatus.send(Resource.success(""))
        } else {
            val error = resp.errorBody();
            Log.e(TAG, "update: ${error}")
            _updateGoodsStatus.send(Resource.error(Exception(error.toString())))
        }
    }

    private val _deleteGoodsStatus = Channel<Resource<String>>()
    val deleteGoodsStatus = _deleteGoodsStatus.receiveAsFlow()
    private suspend fun delete(goods: Goods) {
        Log.d(TAG, "delete: delete in progress...")
        if (fieldsAreEmpty(goods)) {
            _deleteGoodsStatus.send(Resource.error(Exception("Please Fill All Fields..!!")))
            return
        }
        val resp = repository.delete(goods)
        if (resp.isSuccessful) {
            Log.d(TAG, "delete: resp:${resp.body()}")
            _deleteGoodsStatus.send(Resource.success(""))
        } else {
            val error = resp.errorBody();
            Log.e(TAG, "delete: ${error}")
            _deleteGoodsStatus.send(Resource.error(Exception(error.toString())))
        }
    }

    private val _deleteAllGoodsStatus = Channel<Resource<String>>()
    val deleteAllGoodsStatus = _deleteAllGoodsStatus.receiveAsFlow()
    private suspend fun deleteAll() {
        Log.d(TAG, "deleteAll: deleteAll in progress...")

        val resp = repository.deleteAll()
        if (resp.isSuccessful) {
            Log.d(TAG, "deleteAll: resp:${resp.body()}")
            _deleteAllGoodsStatus.send(Resource.success(""))
        } else {
            val error = resp.errorBody();
            Log.e(TAG, "deleteAll: ${error}")
            _deleteAllGoodsStatus.send(Resource.error(Exception(error.toString())))
        }
    }

    private suspend fun getAll() {
        Log.d(TAG, "getAll: in progress")
        val resp = repository.getAll()
        if (resp.isSuccessful) {
            Log.d(TAG, "getAll: resp:${resp.body()}")
            val goods = resp.body()!!
            _allGoods.value = goods
            _getAllGoodsStatus.send(Resource.success(goods))
        } else {
            val error = resp.errorBody();
            Log.e(TAG, "getAll: ${error}")
            _getAllGoodsStatus.send(Resource.error(Exception(error.toString())))
        }
    }

    private fun fieldsAreEmpty(good: Goods): Boolean {
        return good.name.isBlank() || good.price.toString().isBlank()
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

    sealed class Event {
        object Initialize : Event()
        data class Insert(val good: Goods) : Event()
        data class Update(val good: Goods) : Event()
        data class Delete(val good: Goods) : Event()
        object DeleteAll : Event()
        object GetAll : Event()
    }

}
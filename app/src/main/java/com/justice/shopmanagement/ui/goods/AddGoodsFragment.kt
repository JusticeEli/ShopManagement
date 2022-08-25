package com.justice.shopmanagement.ui.goods

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.justice.shopmanagement.R
import com.justice.shopmanagement.databinding.FragmentAddGoodsBinding
import com.justice.shopmanagement.model.Goods
import com.justice.shopmanagement.utils.Resource
import com.justice.shopmanagement.utils.hide
import com.justice.shopmanagement.utils.show
import com.justice.shopmanagement.utils.toIntOrEmptyString
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddGoodsFragment : Fragment(R.layout.fragment_add_goods) {

    lateinit var binding: FragmentAddGoodsBinding
    val viewModel: GoodsViewModel by viewModels()
    private val TAG = "AddGoodsFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAddGoodsBinding.bind(view)

        setOnClickListeners()
        subScribeToObservers()

    }

    private fun subScribeToObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {


            launch {
                viewModel.insertGoodsStatus.collect {
                    Log.d(TAG, "subscribeToObservers: getCarTypesStatus:${it.status.name}")
                    when (it.status) {
                        Resource.Status.LOADING -> {
                            binding.progressBar.show()
                        }
                        Resource.Status.SUCCESS -> {
                            binding.progressBar.hide()
                            Log.d(TAG, "subscribeToObservers: Success:${it.data}")
                            showToastMessage("Added")
                            resetEdtTxt()
                        }
                        Resource.Status.ERROR -> {
                            binding.progressBar.hide()
                            it.exception?.message?.let {
                                showToastMessage(it)
                            }
                            Log.e(TAG, "subscribeToObservers: Error:${it.exception?.message}")


                        }
                    }
                }
            }
        }

    }

    private fun setOnClickListeners() {
        binding.submitBtn.setOnClickListener {
            try {
                val goods = Goods("", "", 0)
                goods.name = binding.nameEdtTxt!!.text.toString()
                goods.price = binding.priceEdtTxt!!.text.toString().toInt()
                viewModel.setEvent(GoodsViewModel.Event.Insert(goods))
            } catch (e: Exception) {
                showToastMessage("Price cannot be empty !")
            }
        }
    }


    private fun resetEdtTxt() {
        binding.nameEdtTxt!!.setText("")
        binding.priceEdtTxt!!.setText("")
    }

    private fun showToastMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }
}



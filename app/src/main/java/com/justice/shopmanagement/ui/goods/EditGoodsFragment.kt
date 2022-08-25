package com.justice.shopmanagement.ui.goods


import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.justice.shopmanagement.R
import com.justice.shopmanagement.databinding.FragmentEditGoodsBinding
import com.justice.shopmanagement.model.Goods
import com.justice.shopmanagement.utils.Resource
import com.justice.shopmanagement.utils.hide
import com.justice.shopmanagement.utils.show
import com.justice.shopmanagement.utils.showToastMessage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EditGoodsActivity : Fragment(R.layout.fragment_edit_goods) {
    private val TAG = "EditGoodsFragment"
    lateinit var binding: FragmentEditGoodsBinding

    private val viewModel: GoodsViewModel by viewModels()
    private val navArgs: EditGoodsActivityArgs by navArgs<EditGoodsActivityArgs>()

   private lateinit var goods: Goods

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEditGoodsBinding.bind(view)
        goods = navArgs.good
        initValues()
        setOnClickListeners()
        subScribeToObservers()

    }

    private fun subScribeToObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {


            launch {
                viewModel.updateGoodsStatus.collect {
                    Log.d(TAG, "subscribeToObservers: updateGoodsStatus:${it.status.name}")
                    when (it.status) {
                        Resource.Status.LOADING -> {
                            binding.progressBar.show()
                        }
                        Resource.Status.SUCCESS -> {
                            binding.progressBar.hide()
                            Log.d(TAG, "subscribeToObservers: Success:${it.data}")
                            showToastMessage("Added")
                           findNavController().popBackStack()
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

    private fun initValues() {
        binding.nameEdtTxt!!.setText(goods!!.name)
        binding.priceEdtTxt!!.setText(goods!!.price)
    }

    private fun setOnClickListeners() {


        binding.submitBtn.setOnClickListener {
            try {
                val goods = Goods("", "", 0)
                goods.name = binding.nameEdtTxt!!.text.toString()
                goods.price = binding.priceEdtTxt!!.text.toString().toInt()
                viewModel.setEvent(GoodsViewModel.Event.Update(goods))
            } catch (e: Exception) {
                showToastMessage("Price cannot be empty !")
            }
        }









        ////////////////////////
        binding.submitBtn!!.setOnClickListener(View.OnClickListener {
            if (binding.nameEdtTxt!!.text.toString()
                    .isEmpty() || binding.priceEdtTxt!!.text.toString().isEmpty()
            ) {
                Toast.makeText(
                    requireContext(),
                    "Please Fill All Fields..!!",
                    Toast.LENGTH_SHORT
                ).show()
                return@OnClickListener
            }
            goods!!.name = binding.nameEdtTxt!!.text.toString()
            goods!!.price = Integer.parseInt(binding.priceEdtTxt!!.text.toString())
            val goodsViewModel = ViewModelProviders.of(this@EditGoodsActivity).get(
                GoodsViewModel::class.java
            )
            goodsViewModel.update(goods)
            Toast.makeText(requireContext(), "Edit Success", Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()
        })
    }


}

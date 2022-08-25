package com.justice.shopmanagement.ui.goods

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.justice.shopmanagement.R
import com.justice.shopmanagement.databinding.FragmentAddGoodsBinding
import com.justice.shopmanagement.model.Goods
import com.justice.shopmanagement.viewmodel.GoodsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddGoodsFragment : Fragment(R.layout.fragment_add_goods) {

    lateinit var binding: FragmentAddGoodsBinding
    val viewModel: GoodsViewModel by viewModels()
    private val TAG = "AddGoodsFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAddGoodsBinding.bind(view)

        setOnClickListeners()

    }

    private fun setOnClickListeners() {
        binding.submitBtn!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                if (binding.nameEdtTxt!!.text.toString()
                        .isEmpty() || binding.priceEdtTxt!!.text.toString()
                        .isEmpty()
                ) {
                    Toast.makeText(
                        requireContext(),
                        "Please Fill All Fields..!!",
                        Toast.LENGTH_SHORT
                    ).show()
                    return
                }
                val goods = Goods("", "", 0)
                goods.name = binding.nameEdtTxt!!.text.toString()
                goods.price = binding.priceEdtTxt!!.text.toString().toInt()
                binding.progressBar.isVisible = true
                viewModel.insert(goods)
                binding.progressBar.isVisible = false
                Toast.makeText(requireContext(), "Added", Toast.LENGTH_SHORT).show()
                resetEdtTxt()
            }

            private fun resetEdtTxt() {
                binding.nameEdtTxt!!.setText("")
                binding.priceEdtTxt!!.setText("")
            }
        })
    }


}
package com.justice.shopmanagement.ui.goods


import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.justice.shopmanagement.R
import com.justice.shopmanagement.databinding.FragmentEditGoodsBinding
import com.justice.shopmanagement.model.Goods
import com.justice.shopmanagement.viewmodel.GoodsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditGoodsActivity : Fragment(R.layout.fragment_edit_goods) {
    lateinit var binding: FragmentEditGoodsBinding

    private val viewModel: GoodsViewModel by viewModels()
    private val navArgs: EditGoodsActivityArgs by navArgs<EditGoodsActivityArgs>()

lateinit var goods: Goods

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEditGoodsBinding.bind(view)
        goods=navArgs.good
        initValues()
        setOnClickListeners()

    }
    private fun initValues() {
        binding.nameEdtTxt!!.setText(goods!!.name)
        binding.priceEdtTxt!!.setText(goods!!.price)
    }

    private fun setOnClickListeners() {
        binding.submitBtn!!.setOnClickListener(View.OnClickListener {
            if (binding.nameEdtTxt!!.text.toString().isEmpty() || binding.priceEdtTxt!!.text.toString().isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Please Fill All Fields..!!",
                    Toast.LENGTH_SHORT
                ).show()
                return@OnClickListener
            }
            goods!!.name = binding.nameEdtTxt!!.text.toString()
            goods!!.price=Integer.parseInt(binding.priceEdtTxt!!.text.toString())
            val goodsViewModel = ViewModelProviders.of(this@EditGoodsActivity).get(
                GoodsViewModel::class.java
            )
            goodsViewModel.update(goods)
            Toast.makeText(requireContext(), "Edit Success", Toast.LENGTH_SHORT).show()
         findNavController().popBackStack()
        })
    }




}

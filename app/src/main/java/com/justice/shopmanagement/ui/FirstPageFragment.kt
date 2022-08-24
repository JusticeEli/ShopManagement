package com.justice.shopmanagement.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.justice.shopmanagement.R
import com.justice.shopmanagement.databinding.FragmentFirstPageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstPageActivity : Fragment(R.layout.fragment_first_page), View.OnClickListener {
    lateinit var binding: FragmentFirstPageBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFirstPageBinding.bind(view)
        setOnClickListeners()

    }
    private fun setOnClickListeners() {
        binding.goodsBtn!!.setOnClickListener(this)
        binding.chargesBtn!!.setOnClickListener(this)
        binding.outOfStockBtn!!.setOnClickListener(this)
        binding.addGoodsBtn!!.setOnClickListener(this)
    }



    override fun onClick(v: View) {
        when (v.id) {
            R.id.goodsBtn -> {
               findNavController().navigate(FirstPageActivityDirections.actionFirstPageActivityToGoodsFragment())
            }
       /*     R.id.chargesBtn -> {
                val intent2 = Intent(this, ChargesActivity::class.java)
                startActivity(intent2)
            }
            R.id.outOfStockBtn -> {
                val intent3 = Intent(this, OutOfStockActivity::class.java)
                startActivity(intent3)
            }*/
            R.id.addGoodsBtn -> {
                findNavController().navigate(FirstPageActivityDirections.actionFirstPageActivityToAddGoodsFragment())

            }
            else -> {}
        }
    }


}

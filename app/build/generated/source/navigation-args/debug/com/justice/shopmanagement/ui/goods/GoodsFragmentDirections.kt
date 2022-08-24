package com.justice.shopmanagement.ui.goods

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.justice.shopmanagement.R

class GoodsFragmentDirections private constructor() {
  companion object {
    fun actionGoodsFragmentToAddGoodsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_goodsFragment_to_addGoodsFragment)
  }
}

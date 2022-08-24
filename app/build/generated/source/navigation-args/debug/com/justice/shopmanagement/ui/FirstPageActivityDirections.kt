package com.justice.shopmanagement.ui

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.justice.shopmanagement.R

class FirstPageActivityDirections private constructor() {
  companion object {
    fun actionFirstPageActivityToGoodsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_firstPageActivity_to_goodsFragment)

    fun actionFirstPageActivityToAddGoodsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_firstPageActivity_to_addGoodsFragment)
  }
}

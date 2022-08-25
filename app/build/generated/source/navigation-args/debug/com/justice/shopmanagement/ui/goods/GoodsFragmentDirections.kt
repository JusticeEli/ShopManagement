package com.justice.shopmanagement.ui.goods

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.justice.shopmanagement.R
import com.justice.shopmanagement.model.Goods
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

class GoodsFragmentDirections private constructor() {
  private data class ActionGoodsFragmentToEditGoodsActivity(
    val good: Goods
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_goodsFragment_to_editGoodsActivity

    @Suppress("CAST_NEVER_SUCCEEDS")
    override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(Goods::class.java)) {
        result.putParcelable("good", this.good as Parcelable)
      } else if (Serializable::class.java.isAssignableFrom(Goods::class.java)) {
        result.putSerializable("good", this.good as Serializable)
      } else {
        throw UnsupportedOperationException(Goods::class.java.name +
            " must implement Parcelable or Serializable or must be an Enum.")
      }
      return result
    }
  }

  companion object {
    fun actionGoodsFragmentToAddGoodsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_goodsFragment_to_addGoodsFragment)

    fun actionGoodsFragmentToEditGoodsActivity(good: Goods): NavDirections =
        ActionGoodsFragmentToEditGoodsActivity(good)
  }
}

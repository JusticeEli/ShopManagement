package com.justice.shopmanagement.ui.goods

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.justice.shopmanagement.model.Goods
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

data class EditGoodsActivityArgs(
  val good: Goods
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  fun toBundle(): Bundle {
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

  companion object {
    @JvmStatic
    fun fromBundle(bundle: Bundle): EditGoodsActivityArgs {
      bundle.setClassLoader(EditGoodsActivityArgs::class.java.classLoader)
      val __good : Goods?
      if (bundle.containsKey("good")) {
        if (Parcelable::class.java.isAssignableFrom(Goods::class.java) ||
            Serializable::class.java.isAssignableFrom(Goods::class.java)) {
          __good = bundle.get("good") as Goods?
        } else {
          throw UnsupportedOperationException(Goods::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__good == null) {
          throw IllegalArgumentException("Argument \"good\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"good\" is missing and does not have an android:defaultValue")
      }
      return EditGoodsActivityArgs(__good)
    }
  }
}

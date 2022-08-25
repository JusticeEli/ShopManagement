package com.justice.shopmanagement

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.SmallTest
import com.justice.shopmanagement.model.Goods
import com.justice.shopmanagement.ui.goods.AddGoodsFragment
import com.justice.shopmanagement.ui.goods.GoodsViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
@SmallTest
@HiltAndroidTest
class StarActorsFragmentTest {

    private val TAG = "AddGoodsFragmentTest"

    @Test
    fun test_isAddGoodsViewsDisplayed() {


        launchFragmentInHiltContainer<AddGoodsFragment> {

        }

        // VERIFY
        onView(withId(R.id.nameEdtTxt))
            .check(matches(isDisplayed()))

        onView(withId(R.id.priceEdtTxt))
            .check(matches(isDisplayed()))
        onView(withId(R.id.submitBtn))
            .check(matches(isDisplayed()))
    }

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Before
    fun setup() {
        hiltRule.inject()
        //   dao = database.shoppingDao()
    }

    @After
    fun teardown() {
    }

    @Test
    fun test_insertGoodsToSolanaNetwork() = runBlockingTest {
        lateinit var viewModel: GoodsViewModel
        launchFragmentInHiltContainer<AddGoodsFragment> {
            viewModel = this.viewModel
        }


        ///GIVEN
        val goodsList = mutableListOf<Goods>()
        (0..3).forEach { index ->

            val good = Goods(
                name = "name $index",
                image = "",
                price = index + 23
            )
            goodsList.add(
                good
            )

            onView(withId(R.id.nameEdtTxt)).perform(typeText(good.name))
            onView(withId(R.id.priceEdtTxt)).perform(typeText(good.price.toString()))

            onView(withId(R.id.submitBtn))
                .perform(click())


        }
        Log.d(TAG, "test_insertGoodsToSolanaNetwork: ${goodsList}")
        delay(500)
        val allGoods = viewModel!!.allGoods.getOrAwaitValue()
        assertThat(allGoods).isEqualTo(goodsList)


    }

}





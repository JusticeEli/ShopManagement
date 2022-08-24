package com.justice.shopmanagement.ui.goods


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.justice.shopmanagement.R
import com.justice.shopmanagement.charges.ChargesActivity
import com.justice.shopmanagement.databinding.FragmentEditGoodsBinding
import com.justice.shopmanagement.databinding.FragmentGoodsBinding
import com.justice.shopmanagement.goods.GoodsActivityRecyclerAdapter
import com.justice.shopmanagement.out_of_stock.OutOfStockActivity
import com.justice.shopmanagement.ui.FirstPageActivity
import com.justice.shopmanagement.viewmodel.GoodsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GoodsFragment : Fragment(R.layout.fragment_goods) {
    lateinit var binding: FragmentGoodsBinding
lateinit var goodsAdapter:GoodsActivityRecyclerAdapter
    private val viewModel: GoodsViewModel by viewModels()
    // private val navArgs: AddMoreRequestFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGoodsBinding.bind(view)


        setOnClickListeners()

        setUpRecyclerView()


    }

    private fun setUpRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.setHasFixedSize(true)
        goodsAdapter = GoodsActivityRecyclerAdapter(requireContext())
        binding.recyclerView.adapter = goodsAdapter
         viewModel!!.allGoods!!.observe(
            viewLifecycleOwner
        ) { notes -> goodsAdapter!!.submitList(notes) }
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                viewModel!!.delete(goodsAdapter!!.getNoteAt(viewHolder.adapterPosition))
                Toast.makeText(requireContext(), "Good deleted", Toast.LENGTH_SHORT).show()
            }
        }).attachToRecyclerView(binding.recyclerView)
    }


    private fun setOnClickListeners() {
        val buttonAddNote = binding.fob
        buttonAddNote.setOnClickListener {
            findNavController().navigate(GoodsFragmentDirections.actionGoodsFragmentToAddGoodsFragment())
        }
    }


}

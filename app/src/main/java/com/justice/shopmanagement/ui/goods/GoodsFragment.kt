package com.justice.shopmanagement.ui.goods


import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.justice.shopmanagement.R
import com.justice.shopmanagement.databinding.FragmentGoodsBinding
import com.justice.shopmanagement.goods.GoodsFragmentRecyclerAdapter
import com.justice.shopmanagement.model.Goods
import com.justice.shopmanagement.utils.Resource
import com.justice.shopmanagement.utils.hide
import com.justice.shopmanagement.utils.show
import com.justice.shopmanagement.utils.showToastMessage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class GoodsFragment : Fragment(R.layout.fragment_goods) {
    lateinit var binding: FragmentGoodsBinding
    lateinit var goodsAdapter: GoodsFragmentRecyclerAdapter
    private val viewModel: GoodsViewModel by viewModels()
    private val TAG = "GoodsFragment"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGoodsBinding.bind(view)
        setHasOptionsMenu(true)
        setOnClickListeners()
        setUpRecyclerView()
        subScribeToObservers()
        viewModel.setEvent(GoodsViewModel.Event.GetAll)


    }

    private fun subScribeToObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            launch {
                viewModel.getAllGoodsStatus.collect {
                    Log.d(TAG, "subscribeToObservers: getAllGoodsStatus:${it.status.name}")
                    when (it.status) {
                        Resource.Status.LOADING -> {
                            binding.progressBar.show()
                        }
                        Resource.Status.SUCCESS -> {
                            binding.progressBar.hide()
                            Log.d(TAG, "subscribeToObservers: Success:${it.data}")
                            goodsAdapter.submitList(it.data)
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
            launch {
                viewModel.deleteGoodsStatus.collect {
                    Log.d(TAG, "subscribeToObservers: getAllGoodsStatus:${it.status.name}")
                    when (it.status) {
                        Resource.Status.LOADING -> {
                            binding.progressBar.show()
                        }
                        Resource.Status.SUCCESS -> {
                            binding.progressBar.hide()
                            Log.d(TAG, "subscribeToObservers: Success:${it.data}")
                            viewModel.setEvent(GoodsViewModel.Event.GetAll)
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

            launch {
                viewModel.initializeGoodsStatus.collect {
                    Log.d(TAG, "subscribeToObservers: getAllGoodsStatus:${it.status.name}")
                    when (it.status) {
                        Resource.Status.LOADING -> {
                            binding.progressBar.show()
                        }
                        Resource.Status.SUCCESS -> {
                            binding.progressBar.hide()
                            Log.d(TAG, "subscribeToObservers: Success:${it.data}")
                            viewModel.setEvent(GoodsViewModel.Event.GetAll)
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
            launch {
                viewModel.deleteAllGoodsStatus.collect {
                    Log.d(TAG, "subscribeToObservers: getAllGoodsStatus:${it.status.name}")
                    when (it.status) {
                        Resource.Status.LOADING -> {
                            binding.progressBar.show()
                        }
                        Resource.Status.SUCCESS -> {
                            binding.progressBar.hide()
                            Log.d(TAG, "subscribeToObservers: Success:${it.data}")
                            viewModel.setEvent(GoodsViewModel.Event.GetAll)
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

    private fun setUpRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            goodsAdapter = GoodsFragmentRecyclerAdapter(requireContext()) {
                onEdit(it)
            }
            adapter = goodsAdapter

        }

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
                val good = goodsAdapter!!.getGoodAt(viewHolder.adapterPosition)!!
                Log.d(TAG, "onSwiped: good:$good")
                viewModel!!.setEvent(GoodsViewModel.Event.Delete(good))

            }
        }).attachToRecyclerView(binding.recyclerView)
    }

    private fun onEdit(good: Goods) {
        Log.d(TAG, "onEdit: good:$good")
        findNavController().navigate(
            GoodsFragmentDirections.actionGoodsFragmentToEditGoodsActivity(
                good
            )
        )
    }


    private fun setOnClickListeners() {
        binding.fob.setOnClickListener {
            findNavController().navigate(GoodsFragmentDirections.actionGoodsFragmentToAddGoodsFragment())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_goods_2, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.initializeMenu -> {
                viewModel.setEvent(GoodsViewModel.Event.Initialize)
            }
            R.id.deleteAllMenu -> {
                viewModel.setEvent(GoodsViewModel.Event.DeleteAll)
            }
        }
        return super.onOptionsItemSelected(item)
    }


}

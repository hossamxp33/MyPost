package com.tarweej.mypost.presentation.famous_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.tarweej.mypost.R
import com.tarweej.mypost.databinding.SearchFragmentBinding
import com.tarweej.mypost.helper.BaseApplication
import com.tarweej.mypost.presentation.homefragment.mvi.UserError

import com.tarweej.mypost.presentation.famous_fragment.adapter.FamousAdapter
import com.tarweej.mypost.presentation.famous_fragment.mvi.FamousViewModel
import com.tarweej.mypost.presentation.famous_fragment.mvi.MainIntent
import kotlinx.coroutines.flow.collect
import javax.inject.Inject


class FamousFragment @Inject constructor() : Fragment() {
    lateinit var famousAdapter: FamousAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val viewModel by viewModels<FamousViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            BaseApplication.appComponent.inject(this)
        }
    }

    lateinit var view: SearchFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = DataBindingUtil.inflate(
            inflater,
            R.layout.search_fragment, container, false
        )

        getAllData()
        famousRecycleView()

        //  view.searchBar.setError("assad")
        view.searchBar.doOnTextChanged { text, start, before, count ->
            viewModel.intents.trySend(MainIntent.SearchByName(viewModel.state.value!!,text.toString()))
        }

        return view.root
    }

    private fun getAllData() {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect { it ->
                view.progress.isVisible = it!!.progress!!
                if (it != null) {
                    if (it.error != null) {
                        it.error?.let {
                            when (it) {
                                
                                is UserError.InvalidId -> "Invalid id"
                                is UserError.NetworkError -> it.throwable.message
                                UserError.ServerError -> "Server error"
                                UserError.Unexpected -> "Unexpected error"
                                is UserError.UserNotFound -> "User not found"
                                UserError.ValidationFailed -> "Validation failed"
                       
                            }
                        }
                        
                        viewModel.intents.send(MainIntent.ErrorDisplayed(it))
                 
                    } else {
                        
                        if (it.progress == true) {
                            viewModel.intents.send(MainIntent.Initialize(it,0))
                        } else {
                            famousAdapter.submitList(it.filteredData)
                        }
                    }
                }
            }
        }
    }


    fun famousRecycleView() {
        famousAdapter = FamousAdapter(requireContext())
        view.bestFamousRecycleView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = famousAdapter;
            isNestedScrollingEnabled = false
            setHasFixedSize(true)
        }
    }


}
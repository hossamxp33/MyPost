package com.tarweej.mypost.presentation.homefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.tarweej.mypost.R
import com.tarweej.mypost.databinding.HomeFragmentBinding
import com.tarweej.mypost.helper.BaseApplication
import com.tarweej.mypost.helper.ClickHandler
import com.tarweej.mypost.helper.Permissions
import com.tarweej.mypost.mainactivity.MainActivity
import com.tarweej.mypost.presentation.homefragment.adapter.*
import com.tarweej.mypost.presentation.homefragment.mvi.MainIntent
import com.tarweej.mypost.presentation.homefragment.mvi.MainViewModel
import com.tarweej.mypost.presentation.homefragment.mvi.UserError
import com.tarweej.mypost.presentation.request.RequestActivity
import com.tarweej.mypost.presentation.settings_activity.SettingsActivity
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.coroutines.flow.collect
import javax.inject.Inject


class HomeFragment @Inject constructor(

) : Fragment() {
    lateinit var topProductsAdapter: TopProductsAdapter
    lateinit var bestFamousAdapter: BestFamousAdapter
    lateinit var specialFamousAdapter: SpecialFamousAdapter
    lateinit var certifiedFamousAdapter: CertifiedFamousAdapter
    lateinit var specialCustomerAdapter: SpecialCustomerAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val viewModel by viewModels<MainViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            BaseApplication.appComponent.inject(this)
        }
    }

    lateinit var view: HomeFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = DataBindingUtil.inflate(
            inflater,
            R.layout.home_fragment, container, false
        )

//        view.context = context as MainActivity
//        view.listener = ClickHandler()

        getAllData()
        topProductsRecycleView()
        bestFamousRecycleView()
        specialFamousRecycleView()
        certifiedFamousRecycleView()
        specialCustomerRecycleView()




        return view.root
    }

    private fun getAllData() {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect {
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
                        viewModel?.intents.send(MainIntent.ErrorDisplayed(it))
                    } else {
                        if (it.progress == true) {
                            shimmer_view_container.startShimmerAnimation()
                            shimmer_product_view.startShimmerAnimation()
                            shimmer_round_view.startShimmerAnimation()
                            viewModel.intents.send(MainIntent.Initialize(it))
                        } else {
                            //// topProductsRecycleViewData
                            topProductsAdapter.submitList(it.homepagedata?.products?.subList(0, 2))

                            /// specialFamousAdapter
                            specialFamousAdapter.submitList(it.homepagedata?.specialFamouse)

                            ///  bestFamousAdapter
                            bestFamousAdapter.submitList(it.homepagedata?.bestFamouse)

                            ///  certifiedFamousAdapter
                            certifiedFamousAdapter.submitList(it.homepagedata?.certifiedFamouse)
                            ///  certifiedFamousAdapter
                            specialCustomerAdapter.submitList(it.homepagedata?.CustomerFamouse)

                            //////// Slider viewPager
                            view.pager.adapter = it.homepagedata?.sliders.let { it ->
                                SliderAdapter(requireContext(), it!!)
                            }

                            it.homepagedata?.sliders.let { itS ->
                                Permissions().init(itS?.size, context as MainActivity, view)
                            }
                            view.indicator.setViewPager(view.pager)
                             stopLoadingShimmer()
                        }

                    }
                }
            }

        }
    }

    fun topProductsRecycleView() {
        topProductsAdapter = TopProductsAdapter(requireContext())
        view.topProductsRecycleView.apply {
            layoutManager = GridLayoutManager(context, 2) // default orientation is vertical
            adapter = topProductsAdapter;
            isNestedScrollingEnabled = false
            setHasFixedSize(true)
        }
    }

    fun bestFamousRecycleView() {
        bestFamousAdapter = BestFamousAdapter(requireContext())
        view.bestFamousRecycleView.apply {
            adapter = bestFamousAdapter;
            isNestedScrollingEnabled = false
            setHasFixedSize(true)
        }
    }

    fun specialFamousRecycleView() {
        specialFamousAdapter = SpecialFamousAdapter(requireContext())
        view.specialFamousRecycleView.apply {
            adapter = specialFamousAdapter;
            isNestedScrollingEnabled = false
            setHasFixedSize(true)
        }
    }

    fun certifiedFamousRecycleView() {
        certifiedFamousAdapter = CertifiedFamousAdapter(requireContext())
        view.certifiedFamousRecycleView.apply {
            adapter = certifiedFamousAdapter;
            isNestedScrollingEnabled = false
            setHasFixedSize(true)
        }
    }
    fun  specialCustomerRecycleView() {
        specialCustomerAdapter = SpecialCustomerAdapter(requireContext())
        view.specialCustomerRecycleView.apply {
            adapter = specialCustomerAdapter;
            isNestedScrollingEnabled = false
            setHasFixedSize(true)
        }
    }

    fun stopLoadingShimmer() {
        shimmer_view_container?.visibility = View.GONE
        shimmer_view_container?.stopShimmerAnimation()


        shimmer_round_view.visibility = View.GONE
        shimmer_round_view.stopShimmerAnimation()

        shimmer_product_view.visibility = View.GONE
        shimmer_round_view.stopShimmerAnimation()

    }
}
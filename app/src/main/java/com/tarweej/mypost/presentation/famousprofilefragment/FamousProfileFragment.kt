package com.tarweej.mypost.presentation.famousprofilefragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.tarweej.mypost.R
import com.tarweej.mypost.databinding.FamousProfileFragmentBinding
import com.tarweej.mypost.helper.BaseApplication
import com.tarweej.mypost.helper.ClickHandler
import com.tarweej.mypost.presentation.famous_fragment.mvi.FamousViewModel
import com.tarweej.mypost.presentation.famous_fragment.mvi.MainIntent
import com.tarweej.mypost.presentation.homefragment.mvi.UserError
import com.tarweej.mypost.presentation.request.FirstRequestFragment
import com.tarweej.mypost.presentation.request.RequestActivity
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class FamousProfileFragment : BottomSheetDialogFragment() {
    lateinit var view: FamousProfileFragmentBinding
    companion object { const val TAG = "BottomSheetDialogFragment" }
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
       var famousId  = 0
    val viewModel by viewModels<FamousViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BaseApplication.appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = DataBindingUtil.inflate(
            inflater,
            R.layout.famous_profile_fragment, container, false
        )

        view.listener = ClickHandler()

         view.context = context as RequestActivity
        getAllData()
        setTransparentBackground()

         view.requestButton.setOnClickListener {
          ClickHandler().switchToRequestFragment(context as RequestActivity, FirstRequestFragment())
           this.dismiss()
         }

        famousId = arguments?.getInt("famousId")!!
        return view.root
    }

    private fun getAllData() {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect { it ->

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
                            viewModel.intents.send(MainIntent.Initialize(it,famousId))
                        } else {
                               view.data = it.famousInfo
                        }
                    }
                }
            }
        }
    }


    fun BottomSheetDialogFragment.setTransparentBackground() {
        dialog?.apply {
            setOnShowListener {
                val bottomSheet = findViewById<View?>(R.id.design_bottom_sheet)
                bottomSheet?.setBackgroundResource(android.R.color.transparent)
            }
        }
    }
}
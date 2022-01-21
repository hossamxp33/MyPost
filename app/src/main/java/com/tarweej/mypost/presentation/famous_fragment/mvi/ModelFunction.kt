package com.tarweej.mypost.presentation.famous_fragment.mvi


import com.tarweej.mypost.entites.famousinfo.FamousInfo
import com.tarweej.mypost.entites.famousinfo.FamousInfoModel
import com.tarweej.mypost.presentation.homefragment.mvi.UserError
import com.tarweej.mypost.repo.homepage.DataRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first


/**
 * this is the model function in MVI, it's responsibility is to convert intents into views states
 */
suspend fun mapIntentToViewState(
    intent: MainIntent,
    Datarepo: DataRepo,
    loadMainData: suspend () -> Flow<Result<FamousInfoModel>> = { Datarepo.getFamousData(intent.famousId!!) },
) = when (intent) {
    is MainIntent.Initialize -> proceedWithInitialize(loadMainData,intent)
    is MainIntent.ErrorDisplayed -> intent.viewState.copy(error = null)
    is MainIntent.SearchByName -> searchByName(intent,intent.Name!!)
}


private suspend fun proceedWithInitialize(loadCart: suspend () -> Flow<Result<FamousInfoModel>>, intent:MainIntent): MainViewState {
    var response =   loadCart()
    var data = response.first()
    return runCatching {
        intent.viewState!!.copy(famousData = (data.getOrThrow()),
            filteredData = data.map { it.famousInfo }.getOrThrow(),
            famousInfo = data.getOrThrow().famousInfo.first(),
           error = null, progress = false)
    }

        .getOrElse {
            intent.viewState!!.copy(error = UserError.NetworkError(it))
        }


}



private  fun searchByName(intent: MainIntent, Name:String): MainViewState
{

    val filterData = SearchFamousBynamee(Name,intent.viewState?.famousData!!.famousInfo)

    return intent.viewState!!.copy(filteredData = filterData as ArrayList)
}


fun SearchFamousBynamee(Name: String, famousarray: ArrayList<FamousInfo>?) =
    famousarray?.filter { data ->
        data.first_name.contains(Name) }





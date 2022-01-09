package com.tarweej.mypost.repo.homepage



import com.tarweej.mypost.datalayer.APIServices
import com.tarweej.mypost.entites.home.MainDataModel
import javax.inject.Inject


class RemoteDataSource @Inject constructor(private val ApiService: APIServices)
    : DataSource {

    override suspend fun getMainResponse(): MainDataModel =
        runCatching { ApiService.getMainData() }
        .getOrElse { throw it }


}
package com.tarweej.mypost.repo.authenticate


import com.tarweej.mypost.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject


class DataRepo @Inject constructor(
    private val Datasources: DataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {

    // // انا كنت ناسي اعمل emit في الcatch عشان كدا كان بيرجع هنا نفس الrespone في الحالتين
    // استخدمت Result في ال follow عشان بترجع الobject , error في نفس الclass وده مش بيحصل في ال sealed

}
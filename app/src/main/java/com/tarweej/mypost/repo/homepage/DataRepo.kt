package com.tarweej.mypost.repo.homepage



import com.tarweej.mypost.di.IoDispatcher
import com.tarweej.mypost.entites.famousinfo.FamousInfoModel
import com.tarweej.mypost.entites.home.MainDataModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import java.io.IOException
import javax.inject.Inject


class DataRepo @Inject constructor(
    private val Datasources: DataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
)  {

    // // انا كنت ناسي اعمل emit في الcatch عشان كدا كان بيرجع هنا نفس الrespone في الحالتين
    // استخدمت Result في ال follow عشان بترجع الobject , error في نفس الclass وده مش بيحصل في ال sealed
     val getMainData:Flow<Result<MainDataModel>> =
        flow {
            emit(Datasources.getMainResponse())
             }
            .map { Result.success(it) }
            .retry(retries = 4) { t -> (t is IOException).also { if (it) {


                delay(1000 )

            }}}
            .catch {

                     throwable ->  emit(Result.failure(throwable)) }
            .flowOn(ioDispatcher)



    suspend fun getFamousData(famous_id: Int): Flow<Result<FamousInfoModel>> =
        flow {
            emit(Datasources.getFamousInfoResponse(famous_id))
        }
            .map { Result.success(it) }
            .retry(4){ t -> (t is IOException).also { if (it) {
                delay(1000)
            }}}
            .catch { throwable -> emit(Result.failure(throwable)) }
            .flowOn(ioDispatcher)


}


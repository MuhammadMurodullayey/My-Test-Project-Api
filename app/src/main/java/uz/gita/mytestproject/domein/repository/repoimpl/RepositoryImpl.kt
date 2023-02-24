package uz.gita.mytestproject.domein.repository.repoimpl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.mytestproject.data.remote.api.ProductApi
import uz.gita.mytestproject.data.response.Offer
import uz.gita.mytestproject.domein.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: ProductApi
) : Repository {
    override fun getData() = flow<Result<List<Offer>>> {
        val response = api.getData()
        if (response.isSuccessful) response.body()?.let {
            emit(Result.success(it.offers))
        } else {
            emit(Result.failure(Exception("error")))
        }
    }.catch {
        emit(Result.failure(Exception(it)))

    }
        .flowOn(Dispatchers.IO)
}
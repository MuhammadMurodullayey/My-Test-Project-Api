package uz.gita.mytestproject.domein.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.mytestproject.data.response.Offer

interface Repository {
    fun getData(): Flow<Result<List<Offer>>>
}
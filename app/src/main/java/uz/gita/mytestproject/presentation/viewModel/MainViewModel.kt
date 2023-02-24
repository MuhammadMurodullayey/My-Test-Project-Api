package uz.gita.mytestproject.presentation.viewModel

import androidx.lifecycle.LiveData
import uz.gita.mytestproject.data.response.Offer

interface MainViewModel {
    val errorLiveData : LiveData<String>
    val progressLiveData : LiveData<Boolean>
    val newsLiveData : LiveData<List<Offer>>
    fun getData()
}
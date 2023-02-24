package uz.gita.mytestproject.presentation.viewModel.viewmodelImpl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.mytestproject.data.response.Offer
import uz.gita.mytestproject.domein.repository.Repository
import uz.gita.mytestproject.presentation.viewModel.MainViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModelImpl @Inject constructor(
    private val repository: Repository
) : ViewModel(), MainViewModel {

    override val errorLiveData: MutableLiveData<String> = MutableLiveData()
    override val progressLiveData: MutableLiveData<Boolean> = MutableLiveData()
    override val newsLiveData: MutableLiveData<List<Offer>> = MutableLiveData()

    override fun getData() {
        repository.getData().onEach {
            it.onSuccess { data ->
                newsLiveData.value = data
            }
            it.onFailure { error ->
                errorLiveData.value = error.message
            }
        }.launchIn(viewModelScope)
    }
}
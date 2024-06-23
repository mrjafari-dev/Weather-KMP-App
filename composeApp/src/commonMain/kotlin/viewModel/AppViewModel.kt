package viewModel

import MainViewState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.ktor.client.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import model.RequestModel
import model.WeatherResponse
import remote.PostServiceImp

class AppViewModel : ViewModel() {
    private val postServiceImp = PostServiceImp(HttpClient())
    private val _weatherViewState = MutableStateFlow<MainViewState<WeatherResponse>?>(null)
    val weatherViewState: StateFlow<MainViewState<WeatherResponse>?> = _weatherViewState.asStateFlow() // Use StateFlow for read-only access

    suspend fun getWeather(requestModel: RequestModel) {
        _weatherViewState.value = MainViewState.LoadingState() // Update flow with state change
         postServiceImp.getPosts(requestModel, onSuccess = {
             _weatherViewState.value = MainViewState.DataLoadedState(it)
         }, onFail = {
             _weatherViewState.value = MainViewState.ErrorState(it)
         })
         // Update flow with data
    }
    fun fetchData(requestModel: RequestModel) {
        viewModelScope.launch {
            getWeather(requestModel)
        }
    }
}
import androidx.lifecycle.ViewModel
import io.ktor.client.*
import io.ktor.client.call.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import model.RequestModel
import model.ResponseModel
import remote.PostServiceImp

class AppViewModel : ViewModel() {
    private val postServiceImp = PostServiceImp(HttpClient())
    private val _weatherViewState = MutableStateFlow<MainViewState<ResponseModel>?>(null)
    val weatherViewState: StateFlow<MainViewState<ResponseModel>?> = _weatherViewState.asStateFlow() // Use StateFlow for read-only access

    suspend fun getWeather(requestModel: RequestModel) {
        _weatherViewState.value = MainViewState.LoadingState() // Update flow with state change
         postServiceImp.getPosts(requestModel, onSuccess = {
             _weatherViewState.value =  MainViewState.DataLoadedState(it)
         }, onFail = {
             _weatherViewState.value =  MainViewState.ErrorState(it)
         })
         // Update flow with data
    }
}
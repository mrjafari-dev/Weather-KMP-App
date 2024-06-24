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
    fun getWeatherMessage(temperature: Double): String {
        return when {
            temperature < 0 -> "❄️ Brrr! It's so cold, even the polar bears are shivering!"
            temperature < 10 -> "🧥 Chilly vibes today! Time to break out those cozy sweaters!"
            temperature < 20 -> "🧣 Perfect weather for a light jacket and a warm smile!"
            temperature < 25 -> "☀️ Absolutely perfect! Enjoy the Goldilocks weather: not too hot, not too cold!"
            temperature < 30 -> "😎 Warm and wonderful! Don’t forget your sunglasses!"
            temperature < 35 -> "🌴 Hot stuff coming through! Time to hit the beach!"
            else -> "🔥 Heat wave alert! Ice cream is officially a food group today!"
        }
    }
}
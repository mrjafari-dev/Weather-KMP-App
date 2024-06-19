sealed class MainViewState<T> {
    class LoadingState<T> : MainViewState<T>()
    class DataLoadedState<T>(val data: T) : MainViewState<T>()
    class ErrorState<T>(val error: String) : MainViewState<T>()
}
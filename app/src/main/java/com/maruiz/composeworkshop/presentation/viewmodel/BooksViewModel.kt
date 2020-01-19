import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.maruiz.books.presentation.utils.Event
import com.maruiz.composeworkshop.domain.model.BookModelDomainModel
import com.maruiz.composeworkshop.domain.usecases.GetBooks
import com.maruiz.composeworkshop.presentation.presentationmodel.BookPresentationModel
import com.maruiz.composeworkshop.presentation.viewmodel.BaseViewModel

class BooksViewModel(private val getBooks: GetBooks) : BaseViewModel() {

    private val books = MutableLiveData<List<BookPresentationModel>>()
    fun observeBooks(): LiveData<List<BookPresentationModel>> = books

    private val navigateToDetail = MutableLiveData<Event<BookPresentationModel>>()
    fun navigateToDetail(): LiveData<Event<BookPresentationModel>> = navigateToDetail

    fun requestBooks() =
        getBooks { it.fold(::handleFailure, ::handleSuccess) }

    fun bookSelected(book: BookPresentationModel) {
        navigateToDetail.value = Event(book)
    }

    private fun handleSuccess(books: List<BookModelDomainModel>) {
        this.books.value =
            books.map {
                BookPresentationModel(
                    it.title,
                    it.author,
                    it.shortSynopsis,
                    it.synopsis,
                    it.image
                )
            }
    }
}
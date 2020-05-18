import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.maruiz.composeworkshop.domain.model.BookDomainModel
import com.maruiz.composeworkshop.domain.usecases.GetBooks
import com.maruiz.composeworkshop.presentation.presentationmodel.BookPresentationModel
import com.maruiz.composeworkshop.presentation.viewmodel.BaseViewModel

class BooksViewModel(private val getBooks: GetBooks) : BaseViewModel() {

    private val _books = MutableLiveData<List<BookPresentationModel>>()
    val books: LiveData<List<BookPresentationModel>> = _books

    fun requestBooks() =
        getBooks(Unit, viewModelScope) { it.fold(::handleFailure, ::handleSuccess) }

    private fun handleSuccess(books: List<BookDomainModel>) {
        _books.value =
            books.map {
                BookPresentationModel(
                    it.title,
                    it.author,
                    it.date,
                    it.shortSynopsis,
                    it.synopsis,
                    it.image,
                    it.score,
                    it.genres
                )
            }
    }
}
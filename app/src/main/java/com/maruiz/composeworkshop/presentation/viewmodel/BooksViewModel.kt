import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.maruiz.composeworkshop.domain.model.BookDomainModel
import com.maruiz.composeworkshop.domain.usecases.GetBooks
import com.maruiz.composeworkshop.presentation.presentationmodel.BookPresentationModel
import com.maruiz.composeworkshop.presentation.viewmodel.BaseViewModel

class BooksViewModel(private val getBooks: GetBooks) : BaseViewModel() {

    private val books = MutableLiveData<List<BookPresentationModel>>()
    fun observeBooks(): LiveData<List<BookPresentationModel>> = books

    fun requestBooks() =
        getBooks { it.fold(::handleFailure, ::handleSuccess) }

    private fun handleSuccess(books: List<BookDomainModel>) {
        this.books.value =
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
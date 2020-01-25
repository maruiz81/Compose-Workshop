package com.maruiz.composeworkshop.data.repository

import arrow.core.Either
import arrow.core.Right
import com.maruiz.composeworkshop.data.error.Failure
import com.maruiz.composeworkshop.data.model.BookDataModel

class BookRepository {
    fun getBooks(): Either<Failure, List<BookDataModel>> =
        Right(
            listOf(
                BookDataModel(
                    1,
                    "Anna Karenina",
                    "Leo Tolstoy",
                    "Anna Karenina is a novel by the Russian author Leo Tolstoy, first " +
                            "published in book form in 1878. Many authors consider Anna Karenina the " +
                            "greatest work of literature ever written, and Tolstoy himself called it " +
                            "his first true novel.",
                    "https://raw.githubusercontent.com/maruiz81/service-example/develop/BooksApp/books_images/anna_karenina.jpeg",
                    "1877",
                    4.04f
                ),
                BookDataModel(
                    2,
                    "To Kill a Mockingbird",
                    "Harper Lee",
                    "To Kill a Mockingbird is a novel by Harper Lee published in 1960. " +
                            "It was immediately successful, winning the Pulitzer Prize, and has become a " +
                            "classic of modern American literature.",
                    "https://raw.githubusercontent.com/maruiz81/service-example/develop/BooksApp/books_images/To_Kill_a_Mockingbird.jpeg",
                    "1960",
                    4.27f
                ),
                BookDataModel(
                    3,
                    "The Great Gatsby",
                    "F. Scott Fitzgerald",
                    "The Great Gatsby is a 1925 novel written by American author F. Scott Fitzgerald that follows a cast of characters living in the fictional towns of West Egg and East Egg on prosperous Long Island in the summer of 1922.",
                    "https://raw.githubusercontent.com/maruiz81/service-example/develop/BooksApp/books_images/the_great_gatsby.jpeg",
                    "1925",
                    3.91f
                ),
                BookDataModel(
                    4,
                    "In Search of Lost Time",
                    "Marcel Proust",
                    "In Search of Lost Time —previously also translated as Remembrance of Things Past—is a novel in seven volumes, written by Marcel Proust.",
                    "https://raw.githubusercontent.com/maruiz81/service-example/develop/BooksApp/books_images/in_search_of_lost_time.jpg",
                    "1913",
                    4.14f
                ),
                BookDataModel(
                    5,
                    "Don Quixote",
                    "Miguel de Cervantes",
                    "The story follows the adventures of a noble (hidalgo) named Alonso Quixano who reads so many chivalric romances that he loses his sanity and decides to become a knight-errant (caballero andante), reviving chivalry and serving his country, under the name Don Quixote de la Mancha.",
                    "https://raw.githubusercontent.com/maruiz81/service-example/develop/BooksApp/books_images/don_quixote.jpeg",
                    "1615",
                    3.87f
                ),
                BookDataModel(
                    6,
                    "Ulysses",
                    "James Joyce",
                    "Ulysses is a modernist novel by Irish writer James Joyce. It was first serialised in parts in the American journal The Little Review from March 1918 to December 1920 and then published in its entirety in Paris by Sylvia Beach on 2 February 1922, Joyce's 40th birthday.",
                    "https://raw.githubusercontent.com/maruiz81/service-example/develop/BooksApp/books_images/ulysses.jpg",
                    "1922",
                    3.73f
                ),
                BookDataModel(
                    7,
                    "Moby Dick",
                    "Herman Melville",
                    "Moby-Dick; or, The Whale is an 1851 novel by American writer Herman Melville. The book is sailor Ishmael's narrative of the obsessive quest of Ahab, captain of the whaling ship Pequod, for revenge on Moby Dick, the white whale that on the ship's previous voyage bit off Ahab's leg at the knee",
                    "https://raw.githubusercontent.com/maruiz81/service-example/develop/BooksApp/books_images/moby_dick.jpg",
                    "1851",
                    3.49f
                ),
                BookDataModel(
                    8,
                    "Hamlet",
                    "Shakespeare",
                    "The Tragedy of Hamlet, Prince of Denmark, often shortened to Hamlet, is a tragedy written by William Shakespeare at an uncertain date between 1599 and 1602. Set in Denmark, the play dramatises the revenge Prince Hamlet is called to wreak upon his uncle, Claudius, by the ghost of Hamlet's father, King Hamlet.",
                    "https://raw.githubusercontent.com/maruiz81/service-example/develop/BooksApp/books_images/hamlet.jpg",
                    "1603",
                    4.02f
                ),
                BookDataModel(
                    9,
                    "War and Peace",
                    "Leo Tolstoy",
                    "War and Peace is a novel by the Russian author Leo Tolstoy. It is regarded as a central work of world literature and one of Tolstoy's finest literary achievements.",
                    "https://raw.githubusercontent.com/maruiz81/service-example/develop/BooksApp/books_images/war_and_peace.jpeg",
                    "1867",
                    4.11f
                ),
                BookDataModel(
                    10,
                    "The Odyssey",
                    "Homer",
                    "The Odyssey is one of two major ancient Greek epic poems attributed to Homer. It is, in part, a sequel to the Iliad, the other Homeric epic. The Odyssey is fundamental to the modern Western canon; it is the second-oldest extant work of Western literature, while the Iliad is the oldest.",
                    "https://raw.githubusercontent.com/maruiz81/service-example/develop/BooksApp/books_images/the_odyssey.jpg",
                    "-700",
                    3.76f
                )
            )
        )
}
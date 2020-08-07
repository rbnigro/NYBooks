package com.ronney.nybooks.presentation.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ronney.nybooks.data.ApiService
import com.ronney.nybooks.data.model.Book
import com.ronney.nybooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel() {

    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks() {
    //    booksLiveData.value = createFakeBooks()
        ApiService.service.getBooks().enqueue(object: Callback<BookBodyResponse> { // parâmetros hard coded no getBooks()

            override fun onResponse(call: Call<BookBodyResponse>, response: Response<BookBodyResponse>) {
                if (response.isSuccessful) {
                    val books: MutableList<Book> = mutableListOf()
                    
                    response.body()?.let {bookBodyResponse ->
                        https://youtu.be/hgfJ56W-G_U?t=334
                    }
                }
            }

            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {

            }

        })
    }

    fun createFakeBooks(): List<Book> {
        return listOf(
                Book("Title 2", "Author 1"),
                Book("Title 2", "Author 2"),
                Book("Title 3", "Author 3"),
                Book("Title 4", "Author 4")
        )
    }
}
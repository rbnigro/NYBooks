package com.ronney.nybooks.presentation.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ronney.nybooks.R
import com.ronney.nybooks.data.model.Book

class BooksAdapter(
    private val books: List<Book>,
    val onItemClickListener: ((book: Book) -> Unit)
) : RecyclerView.Adapter<BooksAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        // exemplo de inflate, sem contexto
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view, onItemClickListener)
    }

    override fun getItemCount() = books.count()

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bindView(books[position])
    }

    class BookViewHolder(
        itemView: View,
        private val onItemClickListener: ((book: Book) -> Unit)
    ) : RecyclerView.ViewHolder(itemView) {

        private val title = itemView.textTitle
        private val author = itemView.textAuthor

        fun bindView(book: Book) {
            title.text = book.title
            author.text = book.author

            itemView.setOnClickListener {
                onItemClickListener.invoke(book)
            }
        }
    }
}
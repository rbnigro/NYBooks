package com.ronney.nybooks.presentation.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ronney.nybooks.R
import com.ronney.nybooks.data.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MoviesAdapter(
    private val movies: List<Movie>,
    val onItemClickListener: ((movie: Movie) -> Unit)
) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view, onItemClickListener)
    }

    override fun getItemCount() = movies.count()

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindView(movies[position])
    }

    class MovieViewHolder(
        itemView: View,
        private val onItemClickListener: ((movie: Movie) -> Unit)
    ) : RecyclerView.ViewHolder(itemView) {

        private val displayTitle = itemView.textTitle
        private val mpaaRating = itemView.textMpaa

        fun bindView(movie: Movie) {
            displayTitle.text = movie.displayTitle
            mpaaRating.text = movie.mpaaRating

            itemView.setOnClickListener {
                onItemClickListener.invoke(movie)
            }
        }
    }
}
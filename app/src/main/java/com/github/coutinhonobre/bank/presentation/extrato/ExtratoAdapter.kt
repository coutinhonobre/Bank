package com.github.coutinhonobre.bank.presentation.extrato

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.coutinhonobre.bank.R
import com.github.coutinhonobre.bank.data.model.Statement
import kotlinx.android.synthetic.main.card_recentes.view.*

class ExtratoAdapter(var extratoList: MutableList<Statement>): RecyclerView.Adapter<ExtratoAdapter.ExtratoViewHolder>() {
    class ExtratoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(statement: Statement){
            statement.let {
                itemView.apply {
                    textViewRecentesTitle.text = it.title
                    textViewRecentesDate.text = it.date
                    textViewRecentesDesc.text = it.desc
                    textViewRecentesValue.text = "R$ ${String.format("%.2f", it.value)}"
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ExtratoViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.card_recentes, parent, false))

    override fun getItemCount() = extratoList.size

    override fun onBindViewHolder(holder: ExtratoViewHolder, position: Int) {
        holder.bindView(extratoList[position])
    }
}
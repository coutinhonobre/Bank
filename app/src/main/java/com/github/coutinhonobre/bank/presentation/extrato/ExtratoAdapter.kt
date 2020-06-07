package com.github.coutinhonobre.bank.presentation.extrato

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.coutinhonobre.bank.R
import com.github.coutinhonobre.bank.data.model.Statement
import kotlinx.android.synthetic.main.card_recentes.view.*
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class ExtratoAdapter(var extratoList: MutableList<Statement>): RecyclerView.Adapter<ExtratoAdapter.ExtratoViewHolder>() {
    class ExtratoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(statement: Statement){
            statement.let {
                itemView.apply {
                    textViewRecentesTitle.text = it.title
                    textViewRecentesDate.text = converDataFormat(it)
                    textViewRecentesDesc.text = it.desc
                    textViewRecentesValue.text = "R$ ${String.format("%.2f", it.value)}"
                }
            }
        }

        private fun converDataFormat(it: Statement): String {
            val fmt: DateFormat = SimpleDateFormat("yyyy-MM-dd")
            return try {
                SimpleDateFormat("dd/MM/yyyy").format(fmt.parse(it.date))
            } catch (e: ParseException) {
                ""
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
package com.example.myconsultamedica.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myconsultamedica.R

class AdapterPacientesCadastrados (private val mList: List<ViewModelPacientesCadastrados>) : RecyclerView.Adapter<AdapterPacientesCadastrados.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_pacientes_cadastrados, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the text to the textview from our itemHolder class
        holder.nomePacienteView.text = ItemsViewModel.nome
        holder.dataNascimento.text = ItemsViewModel.dataNascimento
        holder.telefone.text = ItemsViewModel.telefone
        // sets the image to the imageview from our itemHolder class
        holder.imgEdit.setImageResource(ItemsViewModel.edit)
        holder.imgDelete.setImageResource(ItemsViewModel.delete)
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val nomePacienteView: TextView = itemView.findViewById(R.id.tv_nome_paciente)
        val dataNascimento: TextView = itemView.findViewById(R.id.tv_data_nascimento)
        val telefone: TextView = itemView.findViewById(R.id.tv_telefone_paciente)
        val imgEdit: ImageButton = itemView.findViewById(R.id.btn_edit)
        val imgDelete: ImageButton = itemView.findViewById(R.id.btn_delete)
    }
}
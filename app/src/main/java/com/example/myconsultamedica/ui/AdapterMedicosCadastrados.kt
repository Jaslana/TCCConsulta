package com.example.myconsultamedica.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myconsultamedica.R

class AdapterMedicosCadastrados (private val mList: List<ViewModelMedicosCadastrados>) : RecyclerView.Adapter<AdapterMedicosCadastrados.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_medicos_cadastrados, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the text to the textview from our itemHolder class
        holder.nomeMedicoView.text = ItemsViewModel.nome
        holder.crmView.text = ItemsViewModel.crm
        holder.statusView.text = ItemsViewModel.status
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
        val nomeMedicoView: TextView = itemView.findViewById(R.id.tv_nome_medico)
        val crmView: TextView = itemView.findViewById(R.id.tv_crm)
        val statusView: TextView = itemView.findViewById(R.id.tv_status_medico)
        val imgEdit: ImageButton = itemView.findViewById(R.id.btn_edit)
        val imgDelete: ImageButton = itemView.findViewById(R.id.btn_delete)
    }
}
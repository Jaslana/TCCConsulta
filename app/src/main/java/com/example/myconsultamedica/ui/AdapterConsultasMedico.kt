package com.example.myconsultamedica.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myconsultamedica.R
import com.example.myconsultamedica.ui.model.ConsultaMedicasModel

class AdapterConsultasMedico (private var c:Context, private val mList: ArrayList<ConsultaMedicasModel>) : RecyclerView.Adapter<AdapterConsultasMedico.ViewHolder>() {


    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_consultas_medico, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the text to the textview from our itemHolder class
//        holder.consulta.text = ItemsViewModel.consulta
        holder.dataConsulta.text = ItemsViewModel.consMedData
        holder.horaConsulta.text = ItemsViewModel.consMedHora
        // sets the image to the imageview from our itemHolder class
//        holder.imgDelete.setImageResource(ItemsViewModel.delete)

        holder.itemView.setOnClickListener {
            Toast.makeText(c,"${holder.consulta.text} é o numero da consulta", Toast.LENGTH_SHORT).show()
        }
        holder.imgDelete.setOnClickListener {
            Toast.makeText(c,"${holder.consulta.text} será deletada", Toast.LENGTH_SHORT).show()
        }
        /**
        holder.imgEdit.setOnClickListener {
            var editConsMedIntent = Intent(c,CadastroConsultaMedico::class.java)
            c.startActivity(editConsMedIntent)}
        */
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val consulta: TextView = itemView.findViewById(R.id.tv_consulta)
        val dataConsulta: TextView = itemView.findViewById(R.id.tv_data_consulta)
        val horaConsulta: TextView = itemView.findViewById(R.id.tv_hora_consulta)
        val imgDelete: ImageButton = itemView.findViewById(R.id.btn_delete)
    }



}
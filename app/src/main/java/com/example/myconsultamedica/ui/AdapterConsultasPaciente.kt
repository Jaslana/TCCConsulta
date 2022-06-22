package com.example.myconsultamedica.ui

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myconsultamedica.R
import com.example.myconsultamedica.ui.model.ConsultaMedicasModel
import com.google.android.material.tabs.TabLayout

class AdapterConsultasPaciente (private val mList: ArrayList<ConsultaMedicasModel>) : RecyclerView.Adapter<AdapterConsultasPaciente.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_consultas_paciente, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = mList[position]

        // sets the text to the textview from our itemHolder class
//        holder.consulta.text = ItemsViewModel.consulta
        holder.medico.text = itemsViewModel.medNome
        holder.especialidade.text = itemsViewModel.consMedConvenio
        holder.dataConsulta.text = itemsViewModel.consMedData
        holder.horaConsulta.text = itemsViewModel.consMedHora
        // sets the image to the imageview from our itemHolder class
        holder.imgAgendar.setImageResource(itemsViewModel.botaoAgend)

        holder.imgAgendar.setOnClickListener(){
           Log.e(TAG, "Deu certo")
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val consulta: TextView = itemView.findViewById(R.id.tv_consulta)
        val medico: TextView = itemView.findViewById(R.id.tv_medico)
        val especialidade: TextView = itemView.findViewById(R.id.tv_especialidade)
        val dataConsulta: TextView = itemView.findViewById(R.id.tv_data_consulta)
        val horaConsulta: TextView = itemView.findViewById(R.id.tv_hora_consulta)
        val imgAgendar: ImageButton = itemView.findViewById(R.id.btn_agendar)
    }
}
package com.example.myconsultamedica.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myconsultamedica.R

class AdapterAgendamentosPaciente (private var c: Context, private val mList: List<ViewModelAgendamentosPaciente>) : RecyclerView.Adapter<AdapterAgendamentosPaciente.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.card_view_agendamentos_paciente, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the text to the textview from our itemHolder class
        holder.consulta.text = ItemsViewModel.consulta
        holder.medico.text = ItemsViewModel.medico
        holder.especialidade.text = ItemsViewModel.especialidade
        holder.dataConsulta.text = ItemsViewModel.dataConsulta
        holder.horaConsulta.text = ItemsViewModel.horaConsulta
        // sets the image to the imageview from our itemHolder class
        holder.imgEdit.setImageResource(ItemsViewModel.edit)

        holder.imgEdit.setOnClickListener {
            var editAgendMedIntent = Intent(c,EditarAgendamentoMedico::class.java)
            editAgendMedIntent.putExtra("nomeMedico", ItemsViewModel.medico)
            c.startActivity(editAgendMedIntent)}

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val consulta: TextView = itemView.findViewById(R.id.tv_consulta)
        val medico: TextView = itemView.findViewById(R.id.tv_medico)
        val especialidade: TextView = itemView.findViewById(R.id.tv_especialidade)
        val dataConsulta: TextView = itemView.findViewById(R.id.tv_data_consulta)
        val horaConsulta: TextView = itemView.findViewById(R.id.tv_hora_consulta)
        val imgEdit: ImageButton = itemView.findViewById(R.id.btn_edit)
    }
}
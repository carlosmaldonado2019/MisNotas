package com.mgtic.dapm.misnotas

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import com.mgtic.dapm.misnotas.database.TaskEntity

class TasksAdapter(
    val tasks: List<TaskEntity>,
    val checkTask: (TaskEntity) -> Unit,
    val deleTask: (TaskEntity)-> Unit)
    :RecyclerView.Adapter<TasksAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_task,parent,false))
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item =  tasks[position]
        holder.bind(item,checkTask,deleTask)

    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTask = view.findViewById<TextView>(R.id.tvTask)
        val cbIsDone = view.findViewById<CheckBox>(R.id.cbIsDone)
        fun bind(task:TaskEntity, checkTask: (TaskEntity) -> Unit, deleTask: (TaskEntity) -> Unit){

            tvTask.text = task.name
            cbIsDone.isChecked = task.isDone
            cbIsDone.setOnClickListener{
                checkTask(task)
            }
            itemView.setOnClickListener{
                deleTask(task)
            }
        }
    }

}
package com.example.myclass

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myclass.databinding.ItemStudentsBinding


typealias OnClickStudent = (Student) -> Unit
class StudentAdapter (private val listStudent: List<Student>,
    private val onClickStudent: OnClickStudent):
    RecyclerView.Adapter<StudentAdapter.ItemStudentViewHolder>() {

        inner class ItemStudentViewHolder (private val binding: ItemStudentsBinding):
                RecyclerView.ViewHolder(binding.root) {

                    @SuppressLint("DiscouragedApi")
                    fun bind(data: Student) {
                        with(binding) {

                            studentPfp.setImageResource(data.resID)
                            studentNameTxt.text = data.name
                            studentGpaTxt.text = data.gpa.toString()

                            if (data.gpa == 4.0) {
                                studentGpaTxt.setTextColor(Color.GREEN)
                            }
                            else if (data.gpa >= 3.5 && data.gpa < 4.0) {
                                studentGpaTxt.setTextColor(Color.MAGENTA)
                            }
                            else if (data.gpa >= 3.0 && data.gpa < 3.5 ) {
                                studentGpaTxt.setTextColor(Color.BLUE)
                            }
                            else {
                                studentGpaTxt.setTextColor(Color.RED)
                            }

                            itemView.setOnClickListener {
                                onClickStudent(data)
                                val intentToDetailActivity = Intent(itemView.context, DetailActivity::class.java)
                                intentToDetailActivity.putExtra("student_name", data.name)
                                intentToDetailActivity.putExtra("student_gpa", data.gpa.toString())
                                intentToDetailActivity.putExtra("student_img", data.resID.toString())
                                itemView.context.startActivity(intentToDetailActivity)
                            }
                        }
                    }
                }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemStudentViewHolder {
        val binding = ItemStudentsBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ItemStudentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listStudent.size
    }

    override fun onBindViewHolder(holder: ItemStudentViewHolder, position: Int) {
        holder.bind(listStudent[position])
    }
}
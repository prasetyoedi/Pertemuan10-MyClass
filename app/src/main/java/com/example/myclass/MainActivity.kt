package com.example.myclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myclass.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapterStudent = StudentAdapter(generateStudents()) {
            student ->
            Toast.makeText(this@MainActivity, "${student.name}",
            Toast.LENGTH_SHORT).show()
        }

        with(binding) {
            rvStudent.apply {
                adapter = adapterStudent
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    fun generateStudents(): List<Student> {
        return listOf(
            Student(resID = R.drawable.ani, name = "Ani Wijaya",  gpa = 3.25),
            Student(resID = R.drawable.budi, name = "Budi Setiawan", gpa = 4.0),
            Student(resID = R.drawable.dini, name = "Dini Sari", gpa = 2.8),
            Student(resID = R.drawable.faisal, name = "Faisal Rahman",  gpa = 4.0),
            Student(resID = R.drawable.gita, name = "Gita Ayu", gpa = 2.5),
        )
    }
}
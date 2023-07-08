package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
//    private val url = "http://10.0.2.2:8000/api/v1/companies/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val but = findViewById<Button>(R.id.button)

        but.setOnClickListener {
//            getdata()
            senddata()
        }
    }

    private fun senddata() {

        val comp  = CompanyData("Game creators",true,"Korea","Krafton","IT")
        retrofirobject.apiinterface.send(comp).enqueue(object : Callback<CompanyData?> {
            override fun onResponse(call: Call<CompanyData?>, response: Response<CompanyData?>) {
                val rest = findViewById<TextView>(R.id.Result)
                rest.text  = response.code().toString()

            }

            override fun onFailure(call: Call<CompanyData?>, t: Throwable) {

            }
        })
    }

    private fun getdata() {
        retrofirobject.apiinterface.getdata().enqueue(object : Callback<CompanyData?> {
            override fun onResponse(call: Call<CompanyData?>, response: Response<CompanyData?>) {
                val rest = findViewById<TextView>(R.id.Result)
                rest.text  = response.body()?.name
                Log.d("RESP",response.toString())
            }
            override fun onFailure(call: Call<CompanyData?>, t: Throwable) {

            }
        })
    }

}
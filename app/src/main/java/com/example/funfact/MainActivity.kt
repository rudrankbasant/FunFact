package com.example.funfact

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.funfact.databinding.ActivityMainBinding
import com.example.funfact.network.FunFact
import com.example.funfact.network.RetrofitInstance
import retrofit2.*

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)


        loadData()

        binding!!.button.setOnClickListener{
            loadData()
        }


    }

    private fun loadData() {

        val dataApi = RetrofitInstance.api
        var results = dataApi.getFacts()
        if (results!=null){

            results.enqueue(object: Callback<FunFact>{
                override fun onResponse(call: Call<FunFact>, response: Response<FunFact>) {
                    if(response!=null){

                        binding!!.textView.text= response.body()?.joke.toString()
                        //this can also be written as:
                        //binding!!.textView.text= response.body()?.let { it.joke }
                    }
                }

                override fun onFailure(call: Call<FunFact>, t: Throwable) {
                    Toast.makeText(this@MainActivity,"Failure of response from API", Toast.LENGTH_SHORT)
                        .show()
                }
            })

        }



    }
}
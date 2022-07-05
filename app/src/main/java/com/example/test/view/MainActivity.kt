package com.example.test.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.newsample.viewmodel.MainActivityViewModel
import com.example.test.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val  viewModel : MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getQuotesViewModel()

         lifecycleScope.launchWhenStarted {
             viewModel.conversion.collect { value: MainActivityViewModel.QuotesEvent ->
                 when(value){
                     is MainActivityViewModel.QuotesEvent.Success ->{
                         Toast.makeText(this@MainActivity, value.resultText, Toast.LENGTH_SHORT).show()

                     }
                     is MainActivityViewModel.QuotesEvent.Failure -> {
                         Toast.makeText(this@MainActivity, value.errorText, Toast.LENGTH_SHORT).show()
                     }
                     is MainActivityViewModel.QuotesEvent.Loading -> {
                         Toast.makeText(this@MainActivity, "Loading", Toast.LENGTH_SHORT).show()
                     }
                     else -> Unit
                 }
             }
         }
    }
}
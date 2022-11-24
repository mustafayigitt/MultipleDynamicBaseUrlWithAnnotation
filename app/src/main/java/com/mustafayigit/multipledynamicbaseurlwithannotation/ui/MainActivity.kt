package com.mustafayigit.multipledynamicbaseurlwithannotation.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mustafayigit.multipledynamicbaseurlwithannotation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val mViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)


        with(mBinding) {

            btnLogin.setOnClickListener {
                mViewModel.login("mustafa", "1234")
            }

            btnGetContents.setOnClickListener {
                mViewModel.getContents()
            }

            btnPayment.setOnClickListener {
                mViewModel.pay()
            }

        }
    }
}
package com.mustafayigit.multipledynamicbaseurlwithannotation.ui

import androidx.lifecycle.viewModelScope
import com.mustafayigit.multipledynamicbaseurlwithannotation.base.BaseViewModel
import com.mustafayigit.multipledynamicbaseurlwithannotation.data.repository.AuthRepository
import com.mustafayigit.multipledynamicbaseurlwithannotation.data.repository.ContentRepository
import com.mustafayigit.multipledynamicbaseurlwithannotation.data.repository.PaymentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by Mustafa Yiğit on 24/11/2022
 * mustafa.yt65@gmail.com
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val contentRepository: ContentRepository,
    private val paymentRepository: PaymentRepository
): BaseViewModel() {

    fun login(username: String, password: String){
        viewModelScope.launch {
            authRepository.login(username, password)
        }
    }

    fun getContents(){
        viewModelScope.launch {
            contentRepository.getContents()
        }
    }

    fun pay(){
        viewModelScope.launch {
            paymentRepository.pay()
        }
    }
}
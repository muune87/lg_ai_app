package io.muracle.lgaiapp

import android.app.Application
import androidx.lifecycle.*
import io.muracle.lgaiapp.utils.PAGE

class MainViewModel(application: Application): AndroidViewModel(application) {
    private val app = application
    val currentDestination = MutableLiveData<PAGE>() //Toolbar를 위한 데이터

    var selected_choose_1 = 0
    var selected_choose_2 = 0

}



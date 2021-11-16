package io.muracle.lgaiapp

import android.app.Application
import androidx.lifecycle.*
import io.muracle.lgaiapp.utils.PAGE

class MainViewModel(application: Application): AndroidViewModel(application) {
	private val app = application
    val currentDestination = MutableLiveData<PAGE>() //Toolbar를 위한 데이터

    var selected_choose_1 = 0
    var selected_choose_2 = 0
	var selected_choose_3 = 0
	var selected_choose_4 = 0
	var selected_choose_5 = 0
	var selected_choose_6 = 0
	var selected_choose_7 = 0
	var selected_choose_8 = 0
	var selected_choose_9 = 0
	var selected_choose_10 = 0
	var selected_choose_11 = 0
	var selected_choose_12 = 0
	var selected_choose_13 = 0
	var selected_choose_14 = 0
	var selected_choose_15 = 0
	var selected_choose_16 = 0
	var selected_choose_17 = 0

}



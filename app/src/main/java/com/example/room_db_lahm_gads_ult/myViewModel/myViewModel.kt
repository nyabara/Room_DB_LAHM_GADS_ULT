package com.example.room_db_lahm_gads_ult.myViewModel

import androidx.lifecycle.*
import com.example.room_db_lahm_gads_ult.data.Person
import com.example.room_db_lahm_gads_ult.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class myViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {


    val readData = repository.readData().asLiveData()


    fun insertData(person: Person){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertData(person)
        }
    }

    fun updateData(person: Person){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateData(person)
        }
    }

    fun deleteData(person: Person){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteData(person)
        }
    }

    fun deleteAllData(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllData()
        }
    }

    fun searchDatabase(searchQuery: String): LiveData<List<Person>> {
        return repository.searchDatabase(searchQuery).asLiveData()
    }

    fun orderByAgeDesc():LiveData<List<Person>>{
        return repository.orderByAgeDesc().asLiveData()
    }
    fun sortByNames(): LiveData<List<Person>>{
        return repository.sortByNames().asLiveData()
    }

}



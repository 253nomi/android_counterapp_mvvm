package com.example.countermvvm

import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel(private  val _repository : CounterRepository) : ViewModel() {
    private  val _count = mutableIntStateOf(value = _repository.getCounter().count)

    // Expose the count as an immutable state
    val count : MutableIntState = _count

    fun increment(){
        _repository.increment()
        _count.intValue = _repository.getCounter().count
    }

    fun decrement(){
        _repository.decrement()
        _count.intValue = _repository.getCounter().count
    }
}
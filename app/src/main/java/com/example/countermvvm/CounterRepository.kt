package com.example.countermvvm

class CounterRepository (private var  _counter : CounterModel) {

    fun getCounter() =
        _counter

    fun increment() {
        _counter.count++
    }

    fun decrement() {
        _counter.count--
    }
}
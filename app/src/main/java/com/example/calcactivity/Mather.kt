package com.example.calcactivity

class Mather {

    var wasOperatorPressed: Boolean = false
    var wasEqualAlreadyPressed: Boolean = false
    var stillTyping: Boolean = false
    var numberBeingBuilt: String = ""
    var numberBeingBuiltTwo: String = ""
    var lastOperatorEntered: String = ""
    var lastNumberEntered: Int = 0
    var total: Int = 0

    fun sum(x: Int, y: Int): Int {                                          // 3
        return x + y
    }
    fun subtract(x: Int, y: Int): Int {
        return x - y
    }
    fun multiply(x: Int, y: Int): Int {
        return x * y
    }
    fun divide(x: Int, y: Int): Int {
        if (y < 0)
            println("cannot divide by zero")
        return x / y
    }


}
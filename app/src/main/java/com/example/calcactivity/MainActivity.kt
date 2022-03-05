package com.example.calcactivity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompatSideChannelService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.lang.Double.parseDouble
import java.lang.Integer.parseInt
import java.sql.Types.NULL
import java.util.*


class MainActivity : AppCompatActivity() {

    var mather = Mather()

    var stack = ArrayDeque<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberPush(view: View) {

        val numberPressed = (view as Button).text

        if (mather.wasOperatorPressed)
            mather.numberBeingBuiltTwo += numberPressed
        else
            mather.numberBeingBuilt += numberPressed

        if (numberPressed != "+" || numberPressed != "-" || numberPressed != "*" || numberPressed != "/") {
            outputView.append(numberPressed)
        }

        if (numberPressed == "+" || numberPressed == "-" || numberPressed == "*" || numberPressed == "/") {
            mather.lastOperatorEntered = numberPressed as String
        }
    }

    fun clearView(view: View) {
        outputView.text = ""
        mather.total = 0
        mather.lastNumberEntered = 0
        mather.wasEqualAlreadyPressed = false
        mather.lastOperatorEntered = ""
        mather.numberBeingBuilt = ""
        mather.numberBeingBuiltTwo = ""
    }

    fun onEqual(view: View) {
        mather.wasOperatorPressed = false

        when (mather.lastOperatorEntered) {
            "+" -> {
                if (mather.wasEqualAlreadyPressed == false) {
                    mather.wasEqualAlreadyPressed = true
                    mather.total =
                        parseInt(mather.numberBeingBuilt) + parseInt(mather.numberBeingBuiltTwo)
                    outputView.text = (mather.total).toString()
                } else if (mather.wasEqualAlreadyPressed == true) {
                    println("in else")
                    mather.total += parseInt(mather.numberBeingBuiltTwo)
                    outputView.text = (mather.total).toString()
                }
            }
            //  "+" -> outputView.text = (mather.total + mather.lastNumberEntered).toString()
            "-" -> {
                if (mather.wasEqualAlreadyPressed == false) {
                    mather.wasEqualAlreadyPressed = true
                    mather.total =
                        parseInt(mather.numberBeingBuilt) - parseInt(mather.numberBeingBuiltTwo)
                    outputView.text = (mather.total).toString()
                } else if (mather.wasEqualAlreadyPressed == true) {
                    println("in else")
                    mather.total -= parseInt(mather.numberBeingBuiltTwo)
                    outputView.text = (mather.total).toString()
                }
            }
            "*" -> {
                if (mather.wasEqualAlreadyPressed == false) {
                    mather.wasEqualAlreadyPressed = true
                    mather.total =
                        parseInt(mather.numberBeingBuilt) * parseInt(mather.numberBeingBuiltTwo)
                    outputView.text = (mather.total).toString()
                } else if (mather.wasEqualAlreadyPressed == true) {
                    println("in else")
                    mather.total *= parseInt(mather.numberBeingBuiltTwo)
                    outputView.text = (mather.total).toString()
                }
            }
            "/" -> {
                if (mather.wasEqualAlreadyPressed == false) {
                    mather.wasEqualAlreadyPressed = true
                    mather.total =
                        parseInt(mather.numberBeingBuilt) / parseInt(mather.numberBeingBuiltTwo)
                    outputView.text = (mather.total).toString()
                } else if (mather.wasEqualAlreadyPressed == true) {
                    println("in else")
                    mather.total /= parseInt(mather.numberBeingBuiltTwo)
                    outputView.text = (mather.total).toString()

                }
            }
            "sqrt" -> {
                if (mather.wasEqualAlreadyPressed == false) {
                    mather.wasEqualAlreadyPressed = true
                    mather.total =
                        parseInt(mather.numberBeingBuilt) / parseInt(mather.numberBeingBuiltTwo)
                    outputView.text = (mather.total).toString()
                } else if (mather.wasEqualAlreadyPressed == true) {
                    mather.total /= parseInt(mather.numberBeingBuiltTwo)
                    outputView.text = (mather.total).toString()

                }
            }
            "square" -> {
                if (mather.wasEqualAlreadyPressed == false) {
                    mather.wasEqualAlreadyPressed = true
                    mather.total =
                        parseInt(mather.numberBeingBuilt) * parseInt(mather.numberBeingBuilt)
                    outputView.text = (mather.total).toString()
                } else if (mather.wasEqualAlreadyPressed == true) {
                    println("in else")
                    mather.total /= parseInt(mather.numberBeingBuiltTwo)
                    outputView.text = (mather.total).toString()

                }
            }

        }
    }

    fun onMinus(view: View) {
        mather.wasOperatorPressed = true
        mather.wasEqualAlreadyPressed = false
        if (mather.lastOperatorEntered == "")
            outputView.text = ""
        mather.lastOperatorEntered = "-"
    }

    fun onPlus(view: View) {
        mather.wasOperatorPressed = true
        mather.wasEqualAlreadyPressed = false
        if (mather.lastOperatorEntered == "")
            outputView.text = ""
        mather.lastOperatorEntered = "+"
    }

    fun onSqrt(view: View) {

        mather.wasOperatorPressed = true
        mather.wasEqualAlreadyPressed = false
        if (mather.lastOperatorEntered == "")
            outputView.text = ""
        mather.lastOperatorEntered = "sqrt"

        var toBeSquared: Double = 0.0

        toBeSquared = Math.sqrt(mather.numberBeingBuilt.toDouble())
        mather.numberBeingBuilt = toBeSquared.toString()

        outputView.append(toBeSquared.toString())


    }

    fun onSquare(view: View) {
       /* if (mather.lastOperatorEntered == "square") {
            var str: String = outputView.text as String
            mather.total += parseInt(str) * parseInt(str)
            mather.numberBeingBuilt = mather.total as String
            outputView.text = mather.total as String
        } else {*/
            mather.lastOperatorEntered = "square"
            mather.total += parseInt(mather.numberBeingBuilt) * parseInt(mather.numberBeingBuilt)
            outputView.text = (mather.total).toString()
    }

    fun onCube(view: View) {
       /* if (mather.lastOperatorEntered == "cube") {
            var str: String = outputView.text as String
            mather.total += parseInt(str) * parseInt(str)
            mather.numberBeingBuilt = mather.total as String
            outputView.text = mather.total as String
        } else {
            */
            mather.lastOperatorEntered = "cube"
            mather.total += parseInt(mather.numberBeingBuilt) * parseInt(mather.numberBeingBuilt) * parseInt(mather.numberBeingBuilt)
            outputView.text = (mather.total).toString()
    }


    fun onMultiply(view: View) {
        mather.wasOperatorPressed = true
        mather.wasEqualAlreadyPressed = false
        if (mather.lastOperatorEntered == "")
            outputView.text = ""
        mather.lastOperatorEntered = "*"
    }

    fun onDivide(view: View) {
        mather.wasOperatorPressed = true
        if (mather.lastOperatorEntered == "")
            outputView.text = ""
        mather.lastOperatorEntered = "/"
    }


    fun negpos(view: View) {
        /* var txt = (outputView.text).toString()    /// crashes code, out of time to debug
        var res = parseDouble(txt)
        res = res * -1
        outputView.text = res as String */
    }

}
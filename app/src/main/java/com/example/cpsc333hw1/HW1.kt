package com.example.cpsc333hw1
import kotlin.random.Random
/*
Name: Lauren Nguyen
Date: 09//11/23
Assignment: HW1 Random Number Ranking game
Class: CPSC333

I ATTEMPTED BONUS #1
 */
fun main(){
    printInstructions()
    var input: String
    var playAgain: String
    var intInput: Int = 0
    var prevInput: Int = 0
    var postInput: Int = 0
    var strNum: String
    var checkEnterKey: String
    var checkPrevKey: String
    var checkPostKey: String
    var num: Int = 0
    var post: Int = 0
    var prev: Int = 0
    do {
        var turnsLeft: Int = 10
        var gameMap = mutableMapOf("1" to "-", "2" to "-", "3" to "-",
            "4" to "-", "5" to "-", "6" to "-",
            "7" to "-", "8" to "-", "9" to "-", "10" to "-")
        do {
            println("***************************************************************************************************")
            println("$turnsLeft turns left!")
            num = genRandNum()
            println("Here is your random number: $num")
            for ((key, value) in gameMap) {
                println("$key: $value")
            }
            println("***************************************************************************************************")
            println("enter index 1-10 or q to quit! ")
            input = readln()
            if(input == "q"){
                break
            }
            intInput = input.toInt()
            if (intInput < 0 || intInput > 10) {
                println("***************************************************************************************************")
                println("\t\t\t\t\t\t\t INPUT INVALID! NUMBER MUST BE WITHIN 1-10")
                break
            }
            checkEnterKey = gameMap.getOrElse(input) { "n/a" }
            if (checkEnterKey != "-") {
                println("***************************************************************************************************")
                println("\t\t\t INPUT INVALID! CANNOT CHANGE RANKINGS OR PLACE 2 NUMBERS IN ONE INDEX")
                break
            }

            if(intInput in 2..9) {
                postInput = intInput + 1
                prevInput = intInput - 1
                var strPost = postInput.toString()
                var strPrev = prevInput.toString()
                checkPostKey = gameMap.getOrElse(strPost) { "n/a" }
                checkPrevKey = gameMap.getOrElse(strPrev) { "n/a" }

                if (checkPostKey != "-") {
                    var intPost = checkPostKey.toInt()
                    if (intPost > intInput) {
                        println("***************************************************************************************************")
                        println("\t\t\t INPUT INVALID! POST NUM IS BIGGER")
                        break
                    }
                }
                if (checkPrevKey != "-") {
                    var intPrev = checkPrevKey.toInt()
                    if (intPrev > intInput) {
                        println("***************************************************************************************************")
                        println("\t\t\t INPUT INVALID! PREV NUM IS BIGGER")
                        break
                    }
                }
            }

            strNum = num.toString()
            gameMap.put(input, strNum)
            turnsLeft -= 1
        } while (turnsLeft > 0)

        println("Want to play again? y for yes and n for no")
        playAgain = readln()
    }while(playAgain == "y")

    println("\t\t\t\t\t\t\t\t\t\tTHANKS FOR PLAYING!")
}

fun genRandNum(): Int{
    val number = (0..999).random()
    return number
}
fun printInstructions(): Unit{
    println("\tRULES:\n\t - 10 random numbers will be generated from 0 to 999\n\t - The goal is to place these randomly placed numbers in ascending order with rank 1 being the lowest and rank 10 being the highest")
    println("\t - You are required to rank each number as it is generated, you CANNOT change the rank after placing the number")
    println("\t - Numbers are only allowed in an unranked spot and between values above/below its value in ascending order")
    println("\t - The game is over when:")
    println("\t\t a. 10 randomly generated numbers are correctly placed in ascending order")
    println("\t\t b. There are no more valid ranks to place the last randomly generated number")
    println("\t GOOD LUCK!")


}
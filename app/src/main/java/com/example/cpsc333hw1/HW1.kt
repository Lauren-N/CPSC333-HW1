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
    printInstructions() // calling printInstructions function to output instructions
    var input: String  // string variable to hold user's preferred index
    var playAgain: String // string variable to hold users choice to playing again
    var intInput: Int = 0 // integer version of users choice
    var prevInput: Int = 0 // integer version of the number above users index
    var postInput: Int = 0 // integer version of the number under the users index
    var strNum: String // string version of random gen number
    var checkEnterKey: String // string value to hold value assigned to user entered key
    var checkPrevKey: String // string value to hold value above user entered key
    var checkPostKey: String // string value to hold value below user entered key
    var num: Int = 0 // randomly generated number
    do {
        var turnsLeft: Int = 10 // int to hold turns left by user
        var gameMap = mutableMapOf("1" to "-", "2" to "-", "3" to "-",
            "4" to "-", "5" to "-", "6" to "-",
            "7" to "-", "8" to "-", "9" to "-", "10" to "-") // mutable map to hold key values(random numbers or dashes) and keys(indexes)
        do {
            println("***************************************************************************************************")
            println("$turnsLeft turns left!") // printing turns left
            num = genRandNum() // generating random number
            println("Here is your random number: $num") // outputting random number to user
            for ((key, value) in gameMap) { // printing the map vertically
                println("$key: $value")
            }
            println("***************************************************************************************************")
            println("enter index 1-10 or q to quit! ") // prompting user to enter a index or to quit
            input = readln() // reading in input
            if(input == "q"){ // if input is q -> quit game and break loop
                break
            }
            intInput = input.toInt() // turning users index into a integer
            if (intInput < 0 || intInput > 10) { //if the user entered number is above 10 or a negative -> flash error message and break loop
                println("***************************************************************************************************")
                println("\t\t\t\t\t\t\t INPUT INVALID! NUMBER MUST BE WITHIN 1-10")
                break
            }
            checkEnterKey = gameMap.getOrElse(input) { "n/a" } // getting the value at the users chosen index
            if (checkEnterKey != "-") { // if this value does not == "-", user has already selected this index so -> flash error message and break the loop
                println("***************************************************************************************************")
                println("\t\t\t INPUT INVALID! CANNOT CHANGE RANKINGS OR PLACE 2 NUMBERS IN ONE INDEX")
                break
            }

            if(intInput in 2..9) { // for indexes 2-9 check error bounds
                postInput = intInput + 1 // post = one index after user index
                prevInput = intInput - 1 // pre = one index before user index
                var strPost = postInput.toString() // converting the value to a string to grab value
                var strPrev = prevInput.toString() // convertin value to string to grab value
                checkPostKey = gameMap.getOrElse(strPost) { "n/a" } // getting value after index
                checkPrevKey = gameMap.getOrElse(strPrev) { "n/a" } // getting value before index

                if (checkPostKey != "-") { // if the value after index is not "-", user has put a number into it -> enter loop
                    var intPost = checkPostKey.toInt() // change value at index to a int
                    if (intPost > intInput) { // if the integer version of the value at index after is bigger then ranomly gen number user tried to place -> enter if and break loop
                        println("***************************************************************************************************")
                        println("\t\t\t INPUT INVALID! POST NUM IS BIGGER")
                        break
                    }
                }
                if (checkPrevKey != "-") { // if the value before index is not "-", user has put a number into it -> enter loop
                    var intPrev = checkPrevKey.toInt() // if the integer version of the value at index before is bigger then ranomly gen number user tried to place -> enter if and break loop
                    if (intPrev > intInput) {
                        println("***************************************************************************************************")
                        println("\t\t\t INPUT INVALID! PREV NUM IS BIGGER")
                        break
                    }
                }
            }
//          IF ALL CONDITIONS PASS:
            strNum = num.toString() // turn the randomly generated number to a string from an int
            gameMap.put(input, strNum) // enter the string num into map wwith user indicated index
            turnsLeft -= 1 // decrement turns left
        } while (turnsLeft > 0) // loop until turns left is at 0

        println("Want to play again? y for yes and n for no") // ask if user wants to play again
        playAgain = readln() // read user input in
    }while(playAgain == "y") // if playAgain is "y" restart the loops

    println("\t\t\t\t\t\t\t\t\t\tTHANKS FOR PLAYING!") // thank you message
}

fun genRandNum(): Int{ // function to generate one random number and returns it
    val number = (0..999).random() // using built in kotlin function, generate random number 0-999
    return number // return random number
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
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
    var strNum: String // string version of random gen number
    var checkEnterKey: String // string value to hold value assigned to user entered key
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
//          IF ALL CONDITIONS PASS:
            strNum = num.toString() // turn the randomly generated number to a string from an int
            gameMap.put(input, strNum) // enter the string num into map wwith user indicated index
            turnsLeft -= 1 // decrement turns left

            var list = mutableListOf<Int>() // list to hold all nums entered in map so far
            for ((key, value) in gameMap) { // adding all values in the map to the list
                if (value != "-"){ // grabbing only the numbers
                var intVal: Int = value.toInt() // turning the string to a int
                list.add(intVal) // adding to list
                }
            }
            if(!isSorted(list)){ // if sorted function returns false -> break loop
                println("***************************************************************************************************")
                println("\t\t\t\t\t\t\t INPUT INVALID! NUMBER MUST IN ASCENDING ORDER")
                break
            }
        } while (turnsLeft > 0) // loop until turns left is at 0

        println("Want to play again? y for yes and n for no") // ask if user wants to play again
        playAgain = readln() // read user input in
    }while(playAgain == "y") // if playAgain is "y" restart the loops

    println("\t\t\t\t\t\t\t\t\t\tTHANKS FOR PLAYING!") // thank you message
}

fun isSorted(list: MutableList<Int>): Boolean{ // takes in a list and checks if it is sorted in ascending order
    var i: Int = 0 // indexer
    var sorted: Boolean = true // boolean to return
    for(i in 0..<list.size-1){ // index from beginning of list to the second to last item
        if(list[i] > list[i+1]){ // if number at one index is greater then the number at the next index, set sorted to be false
            sorted = false
        }
    }
    return sorted // return sorted
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
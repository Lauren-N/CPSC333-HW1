package com.example.cpsc333hw1
import kotlin.random.Random
/*
Name: Lauren Nguyen
Date: 09//11/23
Assignment: HW1 Random Number Ranking game
Class: CPSC333
 */



fun main(){
    printInstructions()
    val list: MutableList<Int?> = MutableList(10) { null }

}

fun enterNum(list: MutableList<Int?>, num: Int, index: Int): MutableList<Int?>{
    list.add(index, num)
    return list
}


fun genRandNum(): Int{
    val number = (0..999).random()
    println(number)
    return number
}
fun printInstructions(): Unit{
    println("\t***************************************************************************************************")
    println("\tRULES:\n\t - 10 random numbers will be generated from 0 to 999\n\t - The goal is to place these randomly placed numbers in ascending order with rank 1 being the lowest and rank 10 being the highest")
    println("\t - You are required to rank each number as it is generated, you CANNOT change the rank after placing the number")
    println("\t - Numbers are only allowed in an unranked spot and between values above/below its value in ascending order")
    println("\t - The game is over when:")
    println("\t\t a. 10 randomly generated numbers are correctly placed in ascending order")
    println("\t\t b. There are no more valid ranks to place the last randomly generated number")
    println("\t GOOD LUCK!")
    println("\t***************************************************************************************************")


}
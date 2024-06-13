package com.example.vit.kotlinex

class Inheriteg {
    //class Customer

    class Contact(val id: Int, var email: String,val name: String)
}

fun main() {
    //val customer = Inheriteg.Customer()

    val contact = Inheriteg.Contact(1, "sanj@gmail.com","Sanjana")

    println(contact.name)
    contact.email = "kk@gmail.com"
    println(contact.email)
}

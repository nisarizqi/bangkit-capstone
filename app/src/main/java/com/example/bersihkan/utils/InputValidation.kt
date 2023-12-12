package com.example.bersihkan.utils

fun isEmailValid(email: String): Boolean{
    val emailRegex = Regex("^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})")
    return emailRegex.matches(email)
}

fun isPasswordValid(password: String): Boolean {
    return password.length >= 8
}

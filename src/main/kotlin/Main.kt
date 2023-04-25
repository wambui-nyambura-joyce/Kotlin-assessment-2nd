import java.lang.IllegalArgumentException
import javax.swing.text.PasswordView

fun main() {
    val str = "Hello, world!"
    val info = stringInfo(str)
    println("String: $str")
    println("First character: ${info.first}")
    println("Last character: ${info.second}")
    println("Length: ${info.third}")
//    println("Begins with vowel: ${if (info.fourth) "Yes" else "No"}")
    val account = CurrentAcount("270197620", "Joyce Nyambura", 2000.0)
    account.deposit(500.0)
    println(account.balance)
    account.withdraw(700.0)
    println(account.balance)
    println("${account.accountName}'s balance is ${account.balance}")

    val password = "myPassword123"
    val isValid = isValidPassword(password)

    if (isValid) {
        println("Password is valid")
    } else {
        println("Password is not valid")
    }
    printMultiples()
}
//Question1
//Write and invoke one function that takes in a random string and returns the
//following values: first character, last character, length of the string and
//whether it begins with a vowel or not.

fun stringInfo(str: String): Triple<Char, Char, Int> {
    val firstChar = str.first()
    val lastChar = str.last()
    val length = str.length
    val beginsWithVowel = when (firstChar.toLowerCase()) {
        'a', 'e', 'i', 'o', 'u' -> true
        else -> false
    }
    return Triple(firstChar, lastChar, length, )
}
//Question2
//Create a function that takes in a password as a parameter. For a password to
//be valid it must meet the following conditions:
//1. Must be at least 8 characters long
//2. Must be at most 16 characters long
//3. Must not be “password”
//4. Must contain a digit
//Your function should determine whether the password provided is valid or not.
//The function returns true/false
fun isValidPassword(password: String): Boolean {
    // check if password is at least 8 characters long and at most 16 characters long
    if (password.length < 8 || password.length > 16) {
        return false
    }

    // check if password is equal to "password"
    if (password == "password") {
        return false
    }

    // check if password contains a digit
    if (!password.any { it.isDigit() }) {
        return false
    }

    // if all conditions pass, return true
    return true
}

//Question3
//Create a function that prints out multiples of 6 and 8 between 1 and 1000. For
//multiples of both 6 and 8 it should print out “Bingo!”
fun printMultiples() {
    for (i in 1..1000) {
        if (i % 6 == 0 && i % 8 == 0) {
            println("Bingo!")
        } else if (i % 6 == 0) {
            println("$i is a multiple of 6")
        } else if (i % 8 == 0) {
            println("$i is a multiple of 8")
        }
    }
}


//Question4
//Create a class CurrentAccount with the following attributes: account number,
//account name, balance. It has the following functions:
//a. deposit(amount: Double) - Increments the balance by the amount
//deposited
//b. withdraw(amount: Double) - Decrements the balance by the amount
//withdrawn
//c. details() - Prints out the account number and balance and name in
//this format: “Account number x with balance y is operated by z”
class CurrentAcount(val accountNumber:String, val accountName:String, var balance:Double){
    fun deposit(amount:Double){
        balance += amount
    }
    fun withdraw(amount: Double){
        if (amount >  balance){
            throw IllegalArgumentException("Insufficient balance")
        }
        balance -= amount

    }

}

//Question5
//Create another class SavingsAccount. It has the same functions and
//attributes as the current account except for one attribute, withdrawals: Int.
//Withdrawals is a counter variable that is used to keep track of how many
//withdrawals have been made from the account in a year. The only other
//difference is that the savings account withdraw() method first checks if the
//number of withdrawals is less than 4 for it to allow one to withdraw money
//from the account. It also increments the withdrawals attribute after a
//successful withdrawal
class SavingsAccount(val accountNumber:String, val accountName:String, var balance: Int ){

}






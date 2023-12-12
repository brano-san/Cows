fun test(string: String): Boolean{
    return string.length == 4 && string.all { it.isDigit() }
}
// Exercise 1: Function to return "OK"
fun start(): String = "OK"

// Exercise 2: Named Arguments for joinToString
fun joinOptions(options: Collection<String>) =
    options.joinToString(separator = ", ", prefix = "[", postfix = "]")

// Exercise 3: Default arguments
fun foo(name: String, number: Int = 42, toUpperCase: Boolean = false) =
    (if (toUpperCase) name.uppercase() else name) + number

fun useFoo() = listOf(
    foo("a"),
    foo("b", number = 1),
    foo("c", toUpperCase = true),
    foo(name = "d", number = 2, toUpperCase = true)
)

// Exercise 4: Triple-quoted strings
const val question = "life, the universe, and everything"
const val answer = 42

val tripleQuotedString = """
    #question = "$question"
    #answer = $answer
""".trimMargin("#")

// Exercise 5: String templates with regex
val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"
fun getPattern(): String = """\d{2} $month \d{4}"""

// Exercise 6: Nullable types
fun sendMessageToClient(client: Client?, message: String?, mailer: Mailer) {
    val email = client?.personalInfo?.email
    if (email != null && message != null) {
        mailer.sendMessage(email, message)
    }
}

class Client(val personalInfo: PersonalInfo?)
class PersonalInfo(val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}

// Exercise 7: Nothing type
fun failWithWrongAge(age: Int?): Nothing {
    throw IllegalArgumentException("Wrong age: $age")
}

fun checkAge(age: Int?) {
    if (age == null || age !in 0..150) failWithWrongAge(age)
    println("Congrats! Next year you'll be ${age + 1}.")
}

// Exercise 8: Lambdas
fun containsEven(collection: Collection<Int>): Boolean =
    collection.any { it % 2 == 0 }

// Main function to run examples
fun main() {
    // Exercise 1: Start
    println("Exercise 1: ${start()}")

    // Exercise 2: Named Arguments
    println("Exercise 2: ${joinOptions(listOf("a", "b", "c"))}")

    // Exercise 3: Default Arguments
    println("Exercise 3: ${useFoo()}")

    // Exercise 4: Triple-quoted strings
    println("Exercise 4:\n$tripleQuotedString")

    // Exercise 5: String templates with regex
    println("Exercise 5: ${getPattern()}")

    // Exercise 6: Nullable types
    println("Exercise 6:")
    val client = Client(PersonalInfo("client@example.com"))
    sendMessageToClient(client, "Hello!", object : Mailer {
        override fun sendMessage(email: String, message: String) {
            println("Sent message to $email: $message")
        }
    })

    // Exercise 7: Nothing type
    println("Exercise 7:")
    try {
        checkAge(10)
        checkAge(200) // This will throw an exception
    } catch (e: IllegalArgumentException) {
        println("Caught exception: ${e.message}")
    }

    // Exercise 8: Lambdas
    println("Exercise 8: ${containsEven(listOf(1, 2, 3, 4))}")
}

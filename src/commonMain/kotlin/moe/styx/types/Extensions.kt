package moe.styx.types

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

fun Boolean.toInt() = if (this) 1 else 0
fun Int.toBoolean() = this > 0

fun Int.padString(length: Int = 2): String {
    return this.toString().padStart(length, '0')
}

infix fun String?.eqI(other: String?): Boolean {
    return this.equals(other, true)
}

@OptIn(ExperimentalSerializationApi::class)
val json = Json {
    ignoreUnknownKeys = true
    isLenient = true
    explicitNulls = true
}

package com.example.haha

import android.content.Context

data class GeneratedProfile(
    val nickname: String,
    val avatar: Int
)

fun generateProfile(context: Context): GeneratedProfile {

    val words = context.resources
        .openRawResource(R.raw.words)
        .bufferedReader()
        .use { it.readLines() }
        .filter { it.isNotBlank() }

    val nickname = words
        .shuffled()
        .take(3)
        .joinToString("_")

    val avatar = avatars.random()

    return GeneratedProfile(
        nickname = nickname,
        avatar = avatar
    )
}

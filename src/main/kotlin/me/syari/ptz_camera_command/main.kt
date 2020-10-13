package me.syari.ptz_camera_command

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

fun OkHttpClient.execute(action: Request.Builder.() -> Unit): Response {
    return newCall(Request.Builder().apply(action).build()).execute()
}

fun main() {
    val client = OkHttpClient()
    println(
        client.execute {
            url("https://google.com")
        }
    )
}
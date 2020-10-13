package me.syari.ptz_camera_command

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

fun OkHttpClient.execute(action: Request.Builder.() -> Unit): Response {
    return newCall(Request.Builder().apply(action).build()).execute()
}

fun main() {
    val client = OkHttpClient()
    val ipList = readIPList()
    println(ipList)
    println(
        client.execute {
            url("https://google.com")
        }
    )
}

fun readIPList(): Map<Int, String> {
    val ipList = mutableMapOf<Int, String>()
    println("---[ Initialize IP List ]---")
    while (true) {
        print("ID: ")
        val id = readLine()?.toIntOrNull() ?: return ipList
        print("IP: ")
        val ip = readLine() ?: return ipList
        ipList[id] = ip
        println("Add ($id, $ip)")
    }
}
package com.garzon.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
plugins {
    id("com.android.application") version "8.4.0" apply false
    id("org.jetbrains.kotlin.android") version "2.0.0" apply false
}

buildscript {
    dependencies {
        classpath("com.google.gms:google-services:4.4.0")
    }
}

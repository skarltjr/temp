import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    kotlin("jvm")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
}
tasks.withType<BootJar>{
    enabled = false
}
tasks.withType<Jar>{
    enabled = true
}
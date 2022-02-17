import org.springframework.boot.gradle.tasks.bundling.BootJar

group = "org.example"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":common"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}

tasks.withType<BootJar>{
    enabled = false
}
tasks.withType<Jar>{
    enabled = true
}
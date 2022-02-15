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
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
}
tasks.withType<BootJar>{
    enabled = false
}
tasks.withType<Jar>{
    enabled = true
}
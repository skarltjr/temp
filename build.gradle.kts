plugins {
    id("org.springframework.boot") version "2.4.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.31"
    kotlin("plugin.spring") version "1.5.31"
    kotlin("plugin.jpa") version "1.5.31"
    kotlin("kapt") version "1.5.31"
}

repositories {
    mavenCentral()
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-gradle-plugin:2.4.2")
    implementation("io.spring.gradle:dependency-management-plugin:0.6.0.RELEASE")
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "kotlin-kapt")

    group = "org.example"
    version = "1.0-SNAPSHOT"
    java.sourceCompatibility = JavaVersion.VERSION_11

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }
    repositories {
        mavenCentral()
    }
    // 전역적으로 사용되는 의존성
    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        // Test
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.0")
        testImplementation("org.springframework.boot:spring-boot-starter-test") {
            exclude("junit")
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

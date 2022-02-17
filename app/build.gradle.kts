import org.springframework.boot.gradle.tasks.bundling.BootJar

group = "org.example"
version = "1.0-SNAPSHOT"

plugins{
    kotlin("jvm")
}

dependencies {
    implementation(project(":common"))
    implementation(project(":user-api:user-domain"))
    implementation(project(":user-api:user-presentation"))
    implementation(project(":goal-api:goal-presentation"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<BootJar>{
    enabled = true
}
tasks.withType<Jar>{
    enabled = true
}

tasks.withType<Test> {
    useJUnitPlatform()
}

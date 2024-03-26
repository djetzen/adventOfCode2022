import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.10"
    application
    jacoco
    id("org.sonarqube") version "5.0.0.4638"
}

apply(plugin = "org.sonarqube")

group = "de.djetzen.advent"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

sonar.properties {
    property("sonar.projectKey", "adventOfCode2022")
    property("sonar.organization", "djetzen")
    property("sonar.host.url", "https://sonarcloud.io")
    property("sonar.sources", "src/main/")
    property("sonar.tests", "src/test/")
}

tasks.jacocoTestReport {
    reports {
        xml.isEnabled = true
        csv.isEnabled = false
    }
}

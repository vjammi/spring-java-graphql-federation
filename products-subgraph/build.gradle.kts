import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
	id("org.springframework.boot") version "3.1.4"
	id("io.spring.dependency-management") version "1.1.3"
	java
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
}

val federation_jvm_version: String = project.property("federation-jvm.version").toString()
dependencies {
    implementation("com.apollographql.federation:federation-graphql-java-support:$federation_jvm_version")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-graphql")
	implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:15.0.0")
    implementation("com.graphql-java:graphql-java-tools:5.2.4")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.boot:spring-boot-starter-webflux")
    testImplementation("org.springframework.graphql:spring-graphql-test")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.named<BootJar>("bootJar") {
    archiveFileName.set("products.jar")
}

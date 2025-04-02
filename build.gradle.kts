plugins {
    java
    id("org.springframework.boot") version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"
    id("jacoco")
}

group = "faang.school"
version = "1.0"
java.sourceCompatibility = JavaVersion.VERSION_17
java.targetCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    /** Spring Boot Starters */
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-logging")
    implementation("org.springframework.retry:spring-retry")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:4.1.0")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    /** Database */
    implementation("org.liquibase:liquibase-core")
    runtimeOnly("org.postgresql:postgresql")
    implementation("redis.clients:jedis:5.1.0")

    /** Utils & Logging */
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    implementation("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    implementation("org.mapstruct:mapstruct:1.5.5.Final")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")

    /** Test Containers */
    testImplementation(platform("org.testcontainers:testcontainers-bom:1.19.3"))
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:postgresql")
    testImplementation("com.redis.testcontainers:testcontainers-redis-junit-jupiter:1.6.0")

    /** Tests */
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.1")
    testImplementation("org.mockito:mockito-core:5.7.0")
    testImplementation("org.assertj:assertj-core:3.24.2")

    /** Swagger */
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
}

jacoco {
    toolVersion = "0.8.11"
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    reports {
        xml.required.set(true)
        csv.required.set(false)
        html.outputLocation.set(file("${buildDir}/jacocoHtml"))
    }

    classDirectories.setFrom(
        fileTree(project.buildDir) {
            include(
                "**/post_service/service/**",
                "**/post_service/validator/**",
                "**/post_service/filter/**",
                "**/post_service/controller/**"
            )
        }
    )
}

tasks.bootJar {
    archiveFileName.set("service.jar")
}
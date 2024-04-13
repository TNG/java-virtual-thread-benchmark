import org.apache.tools.ant.taskdefs.condition.Os

plugins {
    id("java")
    id("me.champeau.jmh") version "0.7.2"
}

jmh {
    iterations = 3
    warmupIterations = 1
    threads = 1

    jvmArgs.add("-Djava.util.logging.config.file=src/main/resources/logging.properties")

    includes = listOf("UDPRequestBenchmark")
}

group = "com.tngtech"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")

    testCompileOnly("org.projectlombok:lombok:1.18.30")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.30")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("org.postgresql:postgresql:42.5.1")
    implementation("com.zaxxer:HikariCP:5.1.0")

    implementation("org.openjdk.jmh:jmh-core:1.33")
    implementation("org.openjdk.jmh:jmh-generator-annprocess:1.33")

    implementation("io.projectreactor:reactor-core:3.4.10")
    implementation("io.projectreactor.netty:reactor-netty:1.1.18")

    if (Os.isFamily(Os.FAMILY_MAC)) {
        implementation("io.netty:netty-all:4.1.108.Final")
    }

    implementation("io.r2dbc:r2dbc-spi:1.0.0.RELEASE")
    implementation("io.r2dbc:r2dbc-pool:1.0.1.RELEASE")
    implementation("org.postgresql:r2dbc-postgresql:1.0.4.RELEASE")

    implementation("org.hibernate.orm:hibernate-core:6.4.4.Final")
    implementation("org.hibernate.orm:hibernate-hikaricp:6.4.4.Final")
}

tasks.withType<JavaCompile> {
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaExec> {
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

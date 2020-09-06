import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
	id("org.springframework.boot") version "2.4.0-SNAPSHOT"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"

	kotlin("jvm") version "1.4.0"
	kotlin("plugin.spring") version "1.4.0"
	id("org.jetbrains.kotlin.kapt") version "1.4.0"
}

group = "com.primawidget"
version = "0.0.1-SNAPSHOT"

java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
	maven("https://oss.sonatype.org/content/repositories/snapshots/")
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation ("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation ("org.springframework.boot:spring-boot-starter-validation:2.4.0-SNAPSHOT")

	implementation("org.seasar.doma.boot:doma-spring-boot-starter:1.1.1")
	kapt("org.seasar.doma:doma:2.24.0")
	implementation("org.seasar.doma:doma:2.24.0")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

val compileKotlin: KotlinCompile by tasks

kapt {
	arguments {
		arg("doma.resources.dir", compileKotlin.destinationDir)
	}
}

tasks.register("copyDomaResources",Sync::class){
	from("src/main/resources")
	into(compileKotlin.destinationDir)
	include("doma.compile.config")
	include("META-INF/**/*.sql")
	include("META-INF/**/*.script")
}

tasks.withType<KotlinCompile> {
	dependsOn(tasks.getByName("copyDomaResources"))
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}



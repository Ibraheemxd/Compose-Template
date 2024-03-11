# Jetpack Compose Startup Template

| Component | Versions |
|---|---|
| Android Studio | Jellyfish 2023.3.1 |
| Kotlin | 1.9.22 |
| AGP | 8.4.0-alpha13 |
| JVM | 1.8 |
| Compose | 1.5.10 |

## Table of Contents
- [Folder Structure](#folder-structure)
- [Dependencies](#dependencies)

## **Folder Structure**

## **Dependencies**
- [Startup](#startup)
- [Material Icons](#material-icons)
- [KSP](#ksp)
- [Dagger Hilt](#dagger-hilt)
- [Voyager](#voyager)
- [Room](#room)
- [Timber](#timber)

### Startup:
```toml
[versions]
agp = "8.4.0-alpha13"
kotlin = "1.9.22"
lifecycleRuntimeKtx = "2.7.0"
activityCompose = "1.8.2"
composeBom = "2024.02.02"

# Testing
junitVersion = "1.1.5"
espressoCore = "3.5.1"
junit = "4.13.2"

[libraries]
androidx-lifecycle-runtime-ktx = { group = "androidx.lifecycle", name = "lifecycle-runtime-ktx", version.ref = "lifecycleRuntimeKtx" }
androidx-activity-compose = { group = "androidx.activity", name = "activity-compose", version.ref = "activityCompose" }
androidx-compose-bom = { group = "androidx.compose", name = "compose-bom", version.ref = "composeBom" }
androidx-ui = { group = "androidx.compose.ui", name = "ui" }
androidx-ui-graphics = { group = "androidx.compose.ui", name = "ui-graphics" }
androidx-ui-tooling = { group = "androidx.compose.ui", name = "ui-tooling" }
androidx-ui-tooling-preview = { group = "androidx.compose.ui", name = "ui-tooling-preview" }
androidx-ui-test-manifest = { group = "androidx.compose.ui", name = "ui-test-manifest" }
androidx-ui-test-junit4 = { group = "androidx.compose.ui", name = "ui-test-junit4" }
androidx-material3 = { group = "androidx.compose.material3", name = "material3" }

# Testing
androidx-espresso-core = { group = "androidx.test.espresso", name = "espresso-core", version.ref = "espressoCore" }
androidx-junit = { group = "androidx.test.ext", name = "junit", version.ref = "junitVersion" }
junit = { group = "junit", name = "junit", version.ref = "junit" }

[plugins]
android-application = { id = "com.android.application", version.ref = "agp" }
jetbrains-kotlin-android = { id = "org.jetbrains.kotlin.android", version.ref = "kotlin" }
```
```kotlin
dependencies {
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
```
*💡 Apk size with proguard -> **641KB**, download size -> **569.7KB***

<hr>

### Material Icons:

```toml
composeMaterial = "1.7.0-alpha04"
```
```toml
androidx-material-icons-extended = { group = "androidx.compose.material", name = "material-icons-extended", version.ref="composeMaterial" }
```
```kotlin
implementation(libs.androidx.material.icons.extended)
```
*💡 Due to the very large size of this library, make sure to use R8/Proguard to strip unused icons if you are including this library as a direct dependency.*

<hr>

### KSP:
```toml
ksp = "1.9.22-1.0.18"
```
[plugins]
```toml
ksp = { id = "com.google.devtools.ksp", version.ref = "ksp" }
```
Project level (plugins):
```kotlin
alias(libs.plugins.hilt) apply false
```
Module level (plugins):
```kotlin
alias(libs.plugins.hilt)
```

<hr>

### Dagger Hilt:
```toml
hilt = "2.51"
androidxHiltNavigationCompose = "1.2.0"    
```
[libraries]
```toml
hilt-android = { group = "com.google.dagger", name = "hilt-android", version.ref = "hilt" }
hilt-compiler = { group = "com.google.dagger", name = "hilt-android-compiler", version.ref = "hilt" }
androidx-hilt-navigation-compose = { group = "androidx.hilt", name = "hilt-navigation-compose", version.ref = "androidxHiltNavigationCompose" }
```
[plugins]
```toml
hilt = { id = "com.google.dagger.hilt.android", version.ref = "hilt" }
```
Project level (plugins):
```kotlin
alias(libs.plugins.hilt) apply false
```
Module level (plugins):
```kotlin
alias(libs.plugins.hilt)
```
dependencies
```kotlin
implementation(libs.androidx.hilt.navigation.compose)
implementation(libs.hilt.android)
ksp(libs.hilt.compiler)
```

<hr>

### Voyager:
```toml
voyager = "1.0.0"
```
```toml
voyager-navigator = { module = "cafe.adriel.voyager:voyager-navigator", version.ref = "voyager" }
voyager-transitions = { module = "cafe.adriel.voyager:voyager-transitions", version.ref = "voyager" }   
```
```kotlin
implementation(libs.voyager.navigator)
implementation(libs.voyager.transitions)
```

<hr>

### Room:
```toml
room = "2.6.1"
```
```toml
androidx-room = { group = "androidx.room", name = "room-runtime", version.ref = "room" }
androidx-room-compiler = { group = "androidx.room", name = "room-compiler", version.ref = "room" }
androidx-room-ktx = { group = "androidx.room", name = "room-ktx", version.ref = "room" }  
```
```kotlin
implementation(libs.androidx.room)
implementation(libs.androidx.room.ktx)
ksp(libs.androidx.room.compiler)
```

<hr>

### Timber:
```toml
timber = "5.0.1"
```
```toml
timber = { module = "com.jakewharton.timber:timber", version.ref = "timber" } 
```
```kotlin
implementation(libs.timber)
```

<hr>

###

plugins {
    id("com.android.library")
}

apply(from = "$rootDir/compose-module.gradle")

android {
    namespace = "com.example.core_ui"
}
dependencies {
}
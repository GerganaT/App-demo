plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.appdemo"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.appdemo"
        minSdk = 28
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // Kotlin extensions
    implementation(libs.androidx.core.ktx)

    // Kotlin JSON serialization
    implementation(libs.kotlinx.serialization.json)

    //Kotlin lifecycle - related extensions
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Jetpack Compose activity
    implementation(libs.androidx.activity.compose)

    //A core set of Jetpack Compose libraries
    implementation(platform(libs.androidx.compose.bom))

    //Primitives that form the Compose UI Toolkit, such as drawing, measurement and layout
    implementation(libs.androidx.ui)

    //Compose graphics
    implementation(libs.androidx.ui.graphics)

    //Compose tooling library, related to IDE support
    implementation(libs.androidx.ui.tooling.preview)

    //Compose "Material-You" Design Components library
    implementation(libs.androidx.material3)

    //Compose Android lifecycle tools
    implementation(libs.androidx.lifecycle.runtime.compose)

    //Compose navigation
    implementation(libs.androidx.compose.navigation)

    //Retrofit
    implementation(libs.retrofit)
    //Moshi implementation for Retrofit
    implementation(libs.retrofit.moshi.converter)

    //Moshi
    implementation(libs.moshi)

    //Network request logger
    implementation(libs.logging.interceptor)

    //Coroutines
    implementation(libs.kotlin.standard.library)
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)

    //Hilt
    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    ksp(libs.hilt.android.compiler)

    //Room
    implementation(libs.room)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)

    // Test - related libraries
    //Unit testing library
    testImplementation(libs.junit)

    //Instrumented tests' libraries
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //A compatible set of Jetpack Compose libraries
    androidTestImplementation(platform(libs.androidx.compose.bom))

    //Compose testing integration with JUnit4
    androidTestImplementation(libs.androidx.ui.test.junit4)

    //Compose UI tools
    debugImplementation(libs.androidx.ui.tooling)

    //Compose testing library that should be added as a debugImplementation dependency
    // to add properties to the debug manifest necessary for testing an application
    debugImplementation(libs.androidx.ui.test.manifest)
}

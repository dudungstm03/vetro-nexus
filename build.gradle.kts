plugins { 
    id("com.android.application") version "8.0.2"
    kotlin("android") version "1.8.0"
}

android { 
    namespace = "com.example.vetronexus"
    compileSdk = 34

    defaultConfig { 
        applicationId = "com.example.vetronexus"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes { 
        release { 
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions { 
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies { 
    implementation("com.google.firebase:firebase-bom:31.3.0")
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")
    implementation("androidx.room:room-runtime:2.5.0")
    kapt("androidx.room:room-compiler:2.5.0")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.security:security-crypto:1.1.0-alpha02")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
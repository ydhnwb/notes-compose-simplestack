plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "com.ydhnwb.notesappsimplestack"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ydhnwb.notesappsimplestack"
        minSdk = 29
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
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

    packaging {
        resources.pickFirsts.add("META-INF/core-ktx_release.kotlin_module")
        resources.excludes.add("META-INF/DEPENDENCIES")
        resources.excludes.add("META-INF/LICENSE")
        resources.excludes.add("META-INF/LICENSE.txt")
        resources.excludes.add("META-INF/license.txt")
        resources.excludes.add("META-INF/NOTICE.txt")
        resources.excludes.add("META-INF/notice.txt")
        resources.excludes.add("META-INF/ASL2.0")
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }

    buildFeatures {
        viewBinding = true //add this
        compose = true
    }


}

dependencies {
    val composeVersion = "1.5.4"
    val material3Version = "1.1.2"
    val simpleStackVersion = "2.3.3"

    // appcompat legacy (xml, fragments)
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.activity:activity-ktx:1.8.0")
    implementation("androidx.fragment:fragment-ktx:1.6.2")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // additional plugins
    implementation("androidx.preference:preference-ktx:1.2.1")


    // testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$composeVersion")

    // compose
    implementation("androidx.compose.runtime:runtime-rxjava2:$composeVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.compose.material3:material3:$material3Version")

    // simple stack https://github.com/Zhuinden/simple-stack
    implementation("com.github.Zhuinden:simple-stack:2.8.0")
    implementation("com.github.Zhuinden.simple-stack-extensions:core-ktx:$simpleStackVersion")
    implementation("com.github.Zhuinden.simple-stack-extensions:fragments:$simpleStackVersion")
    implementation("com.github.Zhuinden.simple-stack-extensions:fragments-ktx:$simpleStackVersion")
    implementation("com.github.Zhuinden.simple-stack-extensions:navigator-ktx:$simpleStackVersion")
    implementation("com.github.Zhuinden.simple-stack-extensions:services:$simpleStackVersion")
    implementation("com.github.Zhuinden.simple-stack-extensions:services-ktx:$simpleStackVersion")
    implementation("com.github.Zhuinden:simple-stack-compose-integration:0.12.2")

    // simple stack state flow replacement
    implementation("com.github.Zhuinden:live-event:1.3.0")
    implementation("com.github.Zhuinden:rx-combinetuple-kt:1.3.0")
    implementation("com.github.Zhuinden:rx-validateby-kt:2.1.1")


    //rx relay. please keep it v2.x.x because it's used by other libs
    implementation("io.reactivex.rxjava2:rxkotlin:2.4.0")
    implementation("com.jakewharton.rxrelay2:rxrelay:2.1.1")


}
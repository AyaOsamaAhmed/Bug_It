import org.gradle.api.artifacts.dsl.DependencyHandler

object AppDependencies {

    const val material = "com.google.android.material:material:${Versions.material}"

    // Coroutines
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"

    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.converterGson}"
    const val okhttp3Logging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3Logging}"

    // Navigation components
    const val navigationFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigationFragmentKtx}"

    // Dagger Hilt
    const val daggerHilt = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
    const val daggerHiltCompiler =
        "com.google.dagger:hilt-android-compiler:${Versions.daggerHiltCompiler}"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}"

    //firebase
    const val crashlytics = "com.google.firebase:firebase-crashlytics:${Versions.crashlytics}"
    const val analytics = "com.google.firebase:firebase-analytics:${Versions.analytics}"
    const val common = "com.google.firebase:firebase-common-ktx:${Versions.common}"

    //firebase
    val firebase = arrayListOf<String>().apply {
        add(crashlytics)
        add(analytics)
        add(common)
    }

    val coroutines = arrayListOf<String>().apply {
        add(coroutinesCore)
        add(coroutinesAndroid)
    }


    val daggerHiltDependencies = arrayListOf<String>().apply {
        add(daggerHilt)
    }

}


fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}
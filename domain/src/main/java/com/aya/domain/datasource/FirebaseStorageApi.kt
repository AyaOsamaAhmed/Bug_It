package com.aya.domain.datasource

import android.net.Uri


interface FirebaseStorageApi {
    suspend fun uploadImage(imageUri: Uri): String
}
package com.aya.data.datasource


import android.net.Uri
import com.aya.domain.datasource.FirebaseStorageApi
import javax.inject.Inject

class FirebaseStorageImpl @Inject constructor() : FirebaseStorageApi {

    override suspend fun uploadImage(imageUri: Uri): String {
        TODO("Not yet implemented")
    }
}
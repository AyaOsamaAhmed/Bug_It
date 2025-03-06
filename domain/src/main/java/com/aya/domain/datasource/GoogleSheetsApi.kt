package com.aya.data.datasource

import com.aya.domain.model.Bug

interface GoogleSheetsApi {

    suspend fun uploadBug(bug: Bug): Boolean

    suspend fun fetchBugs(): List<Bug>
}
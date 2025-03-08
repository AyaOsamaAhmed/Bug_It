package com.aya.data.datasource

import com.aya.domain.model.Bug

class GoogleSheetsImpl: GoogleSheetsApi {
    override suspend fun uploadBug(bug: Bug): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun fetchBugs(): List<Bug> {
        TODO("Not yet implemented")
    }
}
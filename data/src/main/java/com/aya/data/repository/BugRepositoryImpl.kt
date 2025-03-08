package com.aya.data.repository

import com.aya.data.datasource.GoogleSheetsApi
import com.aya.domain.datasource.FirebaseStorageApi
import com.aya.domain.model.Bug
import com.aya.domain.repository.BugRepository
import javax.inject.Inject

class BugRepositoryImpl @Inject constructor(
    private val googleSheetsApi: GoogleSheetsApi,
    private val firebaseStorageApi: FirebaseStorageApi
) : BugRepository {

    override suspend fun submitBug(bug: Bug): Boolean {
        return googleSheetsApi.uploadBug(bug)
    }

    override suspend fun getBugs(): List<Bug> {
        return googleSheetsApi.fetchBugs()
    }
}
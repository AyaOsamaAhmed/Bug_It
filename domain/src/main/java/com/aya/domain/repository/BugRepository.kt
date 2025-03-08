package com.aya.domain.repository

import com.aya.domain.model.Bug

interface BugRepository {
    suspend fun submitBug(bug: Bug): Boolean
    suspend fun getBugs(): List<Bug>
}
package com.example.domain.usecase

import com.example.domain.model.Bug
import com.example.domain.repository.BugRepository
import javax.inject.Inject

class SubmitBugUseCase @Inject constructor(
    private val repository: BugRepository
) {
    suspend operator fun invoke(bug: Bug): Boolean {
        return repository.submitBug(bug)
    }
}
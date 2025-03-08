package com.aya.domain.usecase

import com.aya.domain.model.Bug
import com.aya.domain.repository.BugRepository
import javax.inject.Inject

class SubmitBugUseCase @Inject constructor(
    private val repository: BugRepository
) {
    suspend operator fun invoke(bug: Bug): Boolean {
        return repository.submitBug(bug)
    }
}
package com.campusresolve.app.data.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.campusresolve.app.data.repository.FirestoreIssueRepository


class IssueFactory(
    private val repository: FirestoreIssueRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {
        if (modelClass.isAssignableFrom(IssueViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return IssueViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

package com.campusresolve.app.data.model
import androidx.lifecycle.ViewModel
import com.campusresolve.app.data.repository.FirestoreIssueRepository
import com.campusresolve.app.data.repository.IssueReport
import com.google.firebase.firestore.ListenerRegistration
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class IssueViewModel(
    private val repository: FirestoreIssueRepository
) : ViewModel() {

    private val _issues =
        MutableStateFlow<List<IssueReport>>(emptyList())
    val issues: StateFlow<List<IssueReport>> =
        _issues.asStateFlow()

    private val _locations =
        MutableStateFlow<List<CampusLocation>>(emptyList())
    val locations: StateFlow<List<CampusLocation>> =
        _locations.asStateFlow()

    private var issuesListener: ListenerRegistration? = null

    init {
        issuesListener = repository.listenToIssues(
            onSuccess = { reports ->
                _issues.value = reports
            },
            onFailure = { error ->
                android.util.Log.e(
                    "IssueViewModel",
                    "Failed to load reports",
                    error
                )
            }
        )
    }

    fun loadLocations(
        onFailure: (Exception) -> Unit
    ) {
        repository.getLocations(
            onSuccess = { result ->
                _locations.value = result
            },
            onFailure = { error ->
                onFailure(error)
            }
        )
    }

    fun addIssue(
        title: String,
        description: String,
        location: String,
        onSuccess: () -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        repository.addIssue(
            title = title,
            description = description,
            location = location,
            onSuccess = onSuccess,
            onFailure = onFailure
        )
    }

    fun updateIssueStatus(
        issueId: String,
        newStatus: String,
        onSuccess: () -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        repository.updateIssueStatus(
            issueId = issueId,
            newStatus = newStatus,
            onSuccess = onSuccess,
            onFailure = onFailure
        )
    }

    fun updateIssueDetails(
        issueId: String,
        title: String,
        description: String,
        location: String,
        onSuccess: () -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        repository.updateIssueDetails(
            issueId = issueId,
            title = title,
            description = description,
            location = location,
            onSuccess = onSuccess,
            onFailure = onFailure
        )
    }

    fun deleteIssue(
        issueId: String,
        onSuccess: () -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        repository.deleteIssue(
            issueId = issueId,
            onSuccess = onSuccess,
            onFailure = onFailure
        )
    }

    override fun onCleared() {
        issuesListener?.remove()
        super.onCleared()
    }
}

package com.campusresolve.app.data.repository

import com.campusresolve.app.data.model.Issue

class IssueRepositoryImpl : IssueRepository {

    private val issues = mutableListOf<Issue>()

    override fun getIssues(): List<Issue> {
        return issues.toList()
    }

    override fun getIssueById(id: Long): Issue? {
        return issues.find { it.id == id }
    }

    override fun addIssue(issue: Issue) {
        issues.add(issue)
    }

    override fun updateIssue(issue: Issue) {
        val index = issues.indexOfFirst { it.id == issue.id }

        if (index != -1) {
            issues[index] = issue
        }
    }

    override fun deleteIssue(id: Long) {
        issues.removeIf { it.id == id }
    }
}
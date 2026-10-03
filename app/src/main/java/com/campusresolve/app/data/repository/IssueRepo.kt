package com.campusresolve.app.data.repository

import com.campusresolve.app.data.model.Issue

interface IssueRepository {

    fun getIssues(): List<Issue>

    fun getIssueById(id: Long): Issue?

    fun addIssue(issue: Issue)

    fun updateIssue(issue: Issue)

    fun deleteIssue(id: Long)
}
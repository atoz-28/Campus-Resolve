package com.campusresolve.app.data.model

data class Issue(
    val id: Long,
    val title: String,
    val description: String,
    val location: String,
    val category: IssueCategory,
    val priority: IssuePriority,
    val status: IssueStatus,
    val reporterId: Long,
    val createdAt: Long
)
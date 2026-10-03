
package com.campusresolve.app.data.model

data class Issue(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    val location: String = "",
    val status: IssueStatus? = null,
    val reporterId: String = "",
    val createdAt: Long = 0L
)

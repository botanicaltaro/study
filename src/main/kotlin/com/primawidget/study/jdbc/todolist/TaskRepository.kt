package com.primawidget.study.jdbctodolist

import com.primawidget.study.jdbctodolist.Task

interface TaskRepository {
    fun create(content:String): Task
    fun update(task: Task)
    fun findAll():List<Task>
    fun findById(id:Long): Task?
}


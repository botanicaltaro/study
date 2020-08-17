package com.primawidget.study.doma2.todolist

import org.seasar.doma.*

@Entity(immutable = true)
@Table(name = "memo")
data class MemoEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,
        val content: String,
        val done: Boolean)

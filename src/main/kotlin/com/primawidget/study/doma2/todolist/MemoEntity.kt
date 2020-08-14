package com.primawidget.study.doma2.todolist

import org.seasar.doma.*

@Entity(immutable = true)
@Table(name="memo")
data class MemoEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(sequence = "MEMO_ID_SEQ")
        val id:Long?=null,
        val content: String,
        val done: Boolean)

package com.primawidget.study.jdbc.todolist

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import org.springframework.jdbc.core.RowMapper

@Repository
class JdbcTaskRepository(private val jdbcTemplate: JdbcTemplate) : TaskRepository {
    private val tasks: MutableList<Task> = mutableListOf()

    private val rowMapper = RowMapper<Task> { rs, _ -> Task(rs.getLong("id"), rs.getString("content"), rs.getBoolean("done")) }

    private val maxId: Long
        get() = tasks.map(Task::id).max() ?: 0


    override fun create(content: String): Task {
        jdbcTemplate.update("INSERT INTO task(content)VALUES(?)", content)
        val id = jdbcTemplate.queryForObject("SELECT currval('task_id_seq')", Long::class.java)
                ?: throw NullPointerException()
        return Task(id, content, false)
    }

    override fun update(task: Task) {
        jdbcTemplate.update("UPDATE task SET content =?,done=? WHERE id=?", task.content, task.done, task.id)
    }

    override fun findAll(): List<Task> = jdbcTemplate.query("SELECT id,content,done FROM task", rowMapper)

    override fun findById(id: Long): Task? = jdbcTemplate.query("SELECT id,content,done FROM task WHERE id=?", rowMapper, id).firstOrNull()
}

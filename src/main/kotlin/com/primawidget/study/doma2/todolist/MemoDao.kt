package com.primawidget.study.doma2.todolist

import org.seasar.doma.*
import org.seasar.doma.boot.ConfigAutowireable
import org.seasar.doma.jdbc.Result

@Dao
@ConfigAutowireable
interface MemoDao {
    @Insert
    fun create(memoEntity: MemoEntity): Result<MemoEntity>

    @Update
    fun update(memoEntity: MemoEntity): Result<MemoEntity>

    @Select
    fun findAll(): List<MemoEntity>

    @Select
    fun findById(id: Long): MemoEntity?

    @Delete
    fun delete(memoEntity: MemoEntity): Result<MemoEntity>
}

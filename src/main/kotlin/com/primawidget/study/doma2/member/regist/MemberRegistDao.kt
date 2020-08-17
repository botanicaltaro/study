package com.primawidget.study.doma2.member.regist

import org.seasar.doma.*
import org.seasar.doma.boot.ConfigAutowireable
import org.seasar.doma.jdbc.Result
import org.springframework.stereotype.Repository

@Dao
@ConfigAutowireable
interface MemberRegistDao {
    @Insert
    fun regist(memberRegistEntity: MemberRegistEntity): Result<MemberRegistEntity>

//    @Update
//    fun update(memberRegistEntity: MemberRegistEntity): Result<MemberRegistEntity>
//
//    @Select
//    fun findAll(): List<MemberRegistEntity>
//
//    @Select
//    fun findById(id: Long): MemberRegistEntity?
//
//    @Delete
//    fun delete(memberRegistEntity: MemberRegistEntity): Result<MemberRegistEntity>
}

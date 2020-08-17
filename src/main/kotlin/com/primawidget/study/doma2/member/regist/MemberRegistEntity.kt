package com.primawidget.study.doma2.member.regist

import org.seasar.doma.*
import java.time.LocalDateTime

@Entity(immutable = true)
@Table(name = "memberInfo")
data class MemberRegistEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val memberId: Long = 0,
        val memberName: String,
        val memberNameKana: String,
        val memberAge:Int,
        val memberAddress: String,
        val memberZipCode: String,
        val memberPassword:String,
        val memberMailAddress:String,
        val updateTime:LocalDateTime,
        val registTime:LocalDateTime)

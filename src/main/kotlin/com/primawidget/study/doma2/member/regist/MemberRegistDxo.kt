package com.primawidget.study.doma2.member.regist

import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class MemberRegistDxo {

    fun formConvertEntity(form: MemberRegistForm): MemberRegistEntity {

        return MemberRegistEntity(
                memberName = form.memberName,
                memberNameKana = form.memberNameKana,
                memberAge = form.memberAge,
                memberAddress = form.memberAddress,
                memberZipCode = form.memberZipCode,
                memberMailAddress = form.memberMailAddress,
                memberPassword = form.memberPassword,
                registTime = LocalDateTime.now(),
                updateTime = LocalDateTime.now())
    }
}

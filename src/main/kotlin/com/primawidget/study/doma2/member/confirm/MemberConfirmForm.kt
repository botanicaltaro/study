package com.primawidget.study.doma2.member.confirm

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

class MemberConfirmForm {

    //会員名
    @Size(max = 20)
    var memberName: String = ""

    //会員名カナ
    var memberNameKana: String = ""

    //年齢
    var memberAge: Int = 0

    //会員住所
    var memberAddress: String = ""

    //郵便番号
    var memberZipCode: String = ""

    //パスワード
    var memberPassword: String = ""

    //メールアドレス
    var memberMailAddress:String = ""



}

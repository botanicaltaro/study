package com.primawidget.study.doma2.member.regist

import com.primawidget.study.jdbc.todolist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import com.primawidget.study.doma2.member.regist.MemberRegistDao
import com.primawidget.study.doma2.todolist.MemoCreateForm
import java.time.LocalDateTime

@Controller
@RequestMapping("member/regist")
class MemberRegistController {

    //会員登録Dao
    @Autowired
    lateinit var memberRegistDao: MemberRegistDao
    //会員登録Dxo
    @Autowired
    lateinit var memberRegistDxo:MemberRegistDxo

    @GetMapping("")
    fun index(form: MemberRegistForm): String {
        return "member/regist/memberregist"
    }

    @PostMapping("")
    fun regist(@Validated form: MemberRegistForm, bindingResult: BindingResult): String {
        if (bindingResult.hasErrors()) {
            return "memberregist.html"
        }
        var memoEntity =memberRegistDxo.formConvertEntity(form)

        memberRegistDao.regist(memoEntity)
        return "redirect:memberregist.html"
    }

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFoundException(): String = "tasks/not_found"

}

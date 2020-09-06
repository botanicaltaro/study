package com.primawidget.study.doma2.member.regist

import com.primawidget.study.jdbc.todolist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("member/regist")
class MemberRegistController {

    //‰ïˆõ“o˜^Dao
    @Autowired
    lateinit var memberRegistDao: MemberRegistDao
    //‰ïˆõ“o˜^Dxo
    @Autowired
    lateinit var memberRegistDxo:MemberRegistDxo

    @GetMapping("")
    fun index(form: MemberRegistForm): String {
        return "member/regist/index"
    }

    @PostMapping("")
    fun regist(@Validated form: MemberRegistForm, bindingResult: BindingResult): String {
        if (bindingResult.hasErrors()) {
            return "index.html"
        }
        var memoEntity =memberRegistDxo.formConvertEntity(form)

        memberRegistDao.regist(memoEntity)
        return "redirect:/member/confirm"
    }

    @PostMapping("confirm")
    fun confirm(form: MemberRegistForm): String {
        return "confirm"
    }

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFoundException(): String = "tasks/not_found"

}

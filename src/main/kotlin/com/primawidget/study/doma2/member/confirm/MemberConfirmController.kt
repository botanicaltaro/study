package com.primawidget.study.doma2.member.confirm

import com.primawidget.study.jdbc.todolist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import com.primawidget.study.doma2.member.regist.MemberRegistDao
import com.primawidget.study.doma2.member.regist.MemberRegistForm
import com.primawidget.study.doma2.todolist.MemoCreateForm
import java.time.LocalDateTime

@Controller
class MemberConfirmController {




    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFoundException(): String = "tasks/not_found"

}

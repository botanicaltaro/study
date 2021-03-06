package com.primawidget.study.top

import com.primawidget.study.jdbc.todolist.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("top")
class TopController {

    @GetMapping("")
    fun index(model: Model):String{
        return "top/index"
    }

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFoundException():String = "tasks/not_found"

}

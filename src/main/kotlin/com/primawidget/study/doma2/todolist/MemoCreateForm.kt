package com.primawidget.study.doma2.todolist

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

class MemoCreateForm {
    @NotBlank
    @Size(max = 20)
    var content: String? = null
}

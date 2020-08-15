package com.primawidget.study.doma2.todolist

import com.primawidget.study.jdbc.todolist.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("memo")
class MemoController {

    //メモDao
    @Autowired
    lateinit var  memoDao: MemoDao

    @GetMapping("")
    fun index(model: Model):String{
        val memo = memoDao.findAll()
        model.addAttribute("memo",memo)
        return "memo/index"
    }

    @GetMapping("new")
    fun new(form: MemoCreateForm):String{
        return "memo/new"
    }

    @PostMapping("")
    fun create(@Validated form: MemoCreateForm, bindingResult:BindingResult):String{
        if(bindingResult.hasErrors()){
            return "memo/new"
        }
        val content = requireNotNull(form.content)
        var memoEntity = MemoEntity(content = content,done = false)
        memoDao.create(memoEntity)
        return "redirect:/memo"
    }

    @GetMapping("{id}/edit")
    fun edit(@PathVariable("id")id:Long,form: MemoUpdateForm):String{
        val memo = memoDao.findById(id) ?: throw NotFoundException()
        form.content = memo.content
        form.done = memo.done
        return "memo/edit"
    }

    @PostMapping(value = ["{id}"],params= ["update"])
    fun update(@PathVariable("id")id:Long, @Validated form: MemoUpdateForm, bindingResult: BindingResult):String {
        if (bindingResult.hasErrors()) {
            return "memo/edit"
        }
        val memoEntity = memoDao.findById(id) ?:throw NotFoundException()
        val newMemoEntity = memoEntity.copy(content = requireNotNull(form.content),done=(form.done))
        memoDao.update(newMemoEntity)
    return "redirect:/memo"
    }

    @PostMapping(value = ["{id}"],params=["delete"])
    fun delete(@PathVariable("id")id:Long, @Validated form: MemoUpdateForm, bindingResult: BindingResult):String {
        if (bindingResult.hasErrors()) {
            return "memo/edit"
        }
        val memoEntity = memoDao.findById(id) ?:throw NotFoundException()
        memoDao.delete(memoEntity)
        return "redirect:/memo"
    }

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFoundException():String = "tasks/not_found"

}

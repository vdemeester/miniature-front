package com.github.vdemeester.miniature.controller;

import com.github.vdemeester.miniature.model.Todo;
import com.github.vdemeester.miniature.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Scope("request")
@RequestMapping("/todos")
public class TodoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TodoController.class);

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Todo> todoList() {
        LOGGER.debug("Get JSON todo list");
        return todoService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Todo todo(@PathVariable Integer id) {
        LOGGER.debug("Get JSON todo with id : {}", id);
        return todoService.findOne(id);
    }
    @RequestMapping(method = RequestMethod.PUT)
    public String save(Todo todo) {
        LOGGER.debug("Save todo : {}", todo);
        todoService.save(todo);
        return "redirect:/appointments";
    }
}

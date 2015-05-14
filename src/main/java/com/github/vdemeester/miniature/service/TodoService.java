package com.github.vdemeester.miniature.service;

import com.github.vdemeester.miniature.model.Todo;

import java.util.List;

public interface TodoService {

    Todo findOne(Integer id);

    List<Todo> findAll();

    void save(Todo todo);
}

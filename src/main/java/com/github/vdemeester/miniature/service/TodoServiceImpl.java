package com.github.vdemeester.miniature.service;

import com.github.vdemeester.miniature.repository.TodoRepository;
import com.github.vdemeester.miniature.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TodoServiceImpl.class);

    private final TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo findOne(Integer id) {
        LOGGER.debug("Find one with : {}", id);
        return todoRepository.get(id);
    }

    @Override
    public List<Todo> findAll() {
        LOGGER.debug("Find all.");
        return todoRepository.findAll();
    }

    @Override
    public void save(Todo todo) {
        LOGGER.debug("Save : {}", todo);
        throw new NotImplementedException();
    }
}

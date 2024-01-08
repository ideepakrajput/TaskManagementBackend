package com.deepak.taskmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deepak.taskmanagement.model.Task;

public interface TaskDao extends JpaRepository<Task, Long> {

}
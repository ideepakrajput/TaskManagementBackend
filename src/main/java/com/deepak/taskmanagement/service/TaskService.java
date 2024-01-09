package com.deepak.taskmanagement.service;

import com.deepak.taskmanagement.response.BasicResponseMsg;
import com.deepak.taskmanagement.response.TaskRequest;

public interface TaskService {

	BasicResponseMsg saveTask(TaskRequest taskRequest);

	BasicResponseMsg getTask();

	BasicResponseMsg updateTask(TaskRequest taskRequest);

	BasicResponseMsg deleteTask(TaskRequest taskRequest);

}

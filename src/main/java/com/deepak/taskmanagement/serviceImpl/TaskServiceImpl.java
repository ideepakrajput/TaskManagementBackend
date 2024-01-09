package com.deepak.taskmanagement.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepak.taskmanagement.dao.TaskDao;
import com.deepak.taskmanagement.model.Task;
import com.deepak.taskmanagement.response.BasicResponseMsg;
import com.deepak.taskmanagement.response.TaskRequest;
import com.deepak.taskmanagement.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDao taskDao;

	@Override
	public BasicResponseMsg saveTask(TaskRequest taskRequest) {
		BasicResponseMsg response = new BasicResponseMsg();
		try {
			Task t = new Task();
			t.setTask(taskRequest.getTask());
			t.setIsComplete(taskRequest.getIsComplete());

			Task save = taskDao.save(t);

			response.setData(save.getId());
			response.setMessage("Task Created");
			response.setStatus(200);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public BasicResponseMsg getTask() {
		BasicResponseMsg response = new BasicResponseMsg();
		try {
//			Optional<Task> tasks = taskDao.findById(Long.valueOf(taskRequest.getId()));
			List<Task> tasks = taskDao.findAll();

			if (!tasks.isEmpty()) {
//				Task t = tasks.get();
//				response.setData(t);
				response.setData(tasks);
				response.setMessage("Tasks Found");
				response.setStatus(200);
			} else {
				response.setStatus(400);
				response.setMessage("Tasks Not Found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public BasicResponseMsg updateTask(TaskRequest taskRequest) {
		BasicResponseMsg response = new BasicResponseMsg();
		try {
			Optional<Task> tasks = taskDao.findById(Long.valueOf(taskRequest.getId()));

			if (tasks.isPresent()) {
				Task t = tasks.get();
				t.setTask(taskRequest.getTask());
				t.setIsComplete(taskRequest.getIsComplete());

				Task savedT = taskDao.save(t);

				response.setData(savedT);
				response.setMessage("Task Updated");
				response.setStatus(200);
			} else {
				response.setStatus(400);
				response.setMessage("Task Not Found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public BasicResponseMsg deleteTask(TaskRequest taskRequest) {
		BasicResponseMsg response = new BasicResponseMsg();
		try {
			Optional<Task> tasks = taskDao.findById(Long.valueOf(taskRequest.getId()));

			if (tasks.isPresent()) {
				Task t = tasks.get();
				t.setTask(taskRequest.getTask());
				t.setIsComplete(taskRequest.getIsComplete());

				taskDao.delete(t);

				response.setMessage("Task Deleted");
				response.setStatus(200);
			} else {
				response.setStatus(400);
				response.setMessage("Task Not Found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}

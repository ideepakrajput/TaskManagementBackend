package com.deepak.taskmanagement.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deepak.taskmanagement.response.BasicResponseMsg;
import com.deepak.taskmanagement.response.TaskRequest;
import com.deepak.taskmanagement.service.TaskService;

@RestController
@CrossOrigin(origins = "*")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@PostMapping("saveTask")
	public ResponseEntity<BasicResponseMsg> saveTask(@RequestBody TaskRequest taskRequest) {

		BasicResponseMsg response = new BasicResponseMsg();
		try {
			response = taskService.saveTask(taskRequest);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("getTask")
	public ResponseEntity<BasicResponseMsg> getTask() {

		BasicResponseMsg response = new BasicResponseMsg();
		try {
			response = taskService.getTask();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("updateTask")
	public ResponseEntity<BasicResponseMsg> updateTask(@RequestBody TaskRequest taskRequest) {

		BasicResponseMsg response = new BasicResponseMsg();
		try {
			response = taskService.updateTask(taskRequest);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("deleteTask")
	public ResponseEntity<BasicResponseMsg> deleteTask(@RequestBody TaskRequest taskRequest) {

		BasicResponseMsg response = new BasicResponseMsg();
		try {
			response = taskService.deleteTask(taskRequest);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}

package com.spring.learn.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.learn.services.ManageTasksService;
import com.spring.learn.vo.TaskVO;

@RestController
public class TasksRestController {
	@Autowired
	ManageTasksService taskService;
	
	@RequestMapping (path="/tasks/{taskName}")
	public List<TaskVO> retrieveTasks(@PathVariable String taskName)
	{
		return taskService.retrieveTaskVOs(taskName);
	}
	
	@RequestMapping (path="/task/{taskID}")
	public TaskVO retrieveTask(@PathVariable int taskID)
	{
		return taskService.retrieveTaskVO(taskID);
	}
	
}

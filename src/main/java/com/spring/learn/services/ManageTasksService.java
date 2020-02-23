package com.spring.learn.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.learn.vo.TaskVO;

@Service
public class ManageTasksService {

	private static List<TaskVO> tasks = new ArrayList<TaskVO>();
	private static int todoCount = 6;

	static {
		tasks.add(new TaskVO(1, "Servlet", "Learn web appliation development", new Date(),
				false));
		tasks.add(new TaskVO(2, "Spring MVC", "Learn Fundamentals", new Date(), false));
		tasks.add(new TaskVO(3, "Spring MVC", "What is Dispatcher", new Date(), false));
		tasks.add(new TaskVO(4, "Spring MVC", "How Controller, view resolver & model works", new Date(), false));
		tasks.add(new TaskVO(5, "Spring MVC", "Use Hibernate", new Date(), false));
		tasks.add(new TaskVO(6, "Spring Boot", "Learn Springboot and convert Spring MVC to Spring boot", new Date(),
				false));
	}
	
	public List<TaskVO> retrieveTaskVOs(String taskName) {
		List<TaskVO> filteredTaskVOs = new ArrayList<TaskVO>();
		for (TaskVO todo : tasks) {
			if (todo.getTaskName().equals(taskName))
				filteredTaskVOs.add(todo);
		}
		return filteredTaskVOs;
	}
	
	public TaskVO retrieveTaskVO(int taskID) {
		for (TaskVO task : tasks) {
			if (task.getTaskID()==(taskID))
				return task;
		}
		return null;
	}
	
	public void updateTask(TaskVO task)
	{
		tasks.remove(task);//(retrieveTaskVO(task.getTaskID()));
		tasks.add(task);
	
	}

	public void addTaskVO(String name, String desc, Date targetDate, boolean isDone) {
		todoCount =tasks.size()+1;
		tasks.add(new TaskVO(++todoCount, name, desc, targetDate, isDone));
	}

	public void deleteTaskVO(int id) {
		Iterator<TaskVO> iterator = tasks.iterator();
		while (iterator.hasNext()) {
			TaskVO todo = iterator.next();
			if (todo.getTaskID() == id) {
				iterator.remove();
			}
		}
	}

}

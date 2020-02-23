package com.spring.learn.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.learn.services.ManageTasksService;
import com.spring.learn.vo.TaskVO;

@Controller
public class TaskController {
	
	private Log logger = LogFactory.getLog(TaskController.class);

	@Autowired
	ManageTasksService taskService;
	
	@InitBinder
	protected void customBinder (WebDataBinder binder)
	{
		// will give us the current time and date 
	    //LocalDateTime current = LocalDateTime.now();
	    
	    // to print in a particular format 
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");// hh:mm");
	    //DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");   
 
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@ExceptionHandler(value=Exception.class)
	public String handleException(HttpServletRequest request, Exception ex)
	{
		logger.error("Exception captured in TaskController for Request: " + request + " is: ", ex);
		return "error";
	}
	
	@RequestMapping(value = "/searchTaskForm", method = RequestMethod.GET)
	public String searchTaskForm(ModelMap model) {
		model.addAttribute("activeLogin", "active");
		return "searchTasks";
	}

	@RequestMapping(value = "/listTasks", method = RequestMethod.POST)
	public String listMyTasks(@RequestParam String taskName, ModelMap model) throws Exception {
		
		
		List<TaskVO> tasks = taskService.retrieveTaskVOs(taskName);
		model.addAttribute("taskName", taskName);
		model.addAttribute("taskCount", tasks.size());
		model.addAttribute("tasks", tasks);
		model.addAttribute("activeLogin", "active");
		//throw new Exception("Exception rendering task list");
		return "taskList";
	}

	@RequestMapping(value = "/addTaskForm", method = RequestMethod.GET)
	public String addTaskForm(ModelMap model) {
		model.addAttribute("taskVO", new TaskVO(0, "Spring MVC", "", new Date(), true));
		model.addAttribute("activeLogin", "active");
		return "addTaskForm";
	}

	@RequestMapping(value = "/addTaskAction", method = RequestMethod.POST)
	// public String addTask(@RequestParam String taskName, @RequestParam String
	// taskDesc, ModelMap model)
	public String addTaskAction(ModelMap model, @Valid TaskVO taskVO, BindingResult result)
	// public String addTask(TaskVO taskVO, ModelMap model)
	{
		//System.out.println("taskVO 111:  " + taskVO);
		if (result.hasErrors()) {
			model.addAttribute("validationErrors", "Please fix Validation errors!!!");
			model.addAttribute("taskVO", taskVO);
			return "addTaskForm";
		}
		//System.out.println("taskVO " + taskVO);
		
		if (taskVO != null && taskVO.getTaskID() == 0)
			taskService.addTaskVO(taskVO.getTaskName(), taskVO.getTaskDesc(), new Date(), true);
		else
		{
			taskService.updateTask(taskVO);
		}
		List<TaskVO> tasks = taskService.retrieveTaskVOs(taskVO.getTaskName());
		model.addAttribute("taskName", taskVO.getTaskName());
		model.addAttribute("taskCount", tasks.size());
		model.addAttribute("tasks", tasks);
		return "taskList";// "redirect:listTasks";
	}

	@RequestMapping(value = "/updateTaskAction", method = RequestMethod.GET)
	public String updateTaskAction(@RequestParam int taskID, ModelMap model) {
		TaskVO task = taskService.retrieveTaskVO(taskID);
		model.addAttribute("taskVO", task);
		return "addTaskForm";// "redirect:listTasks";
	}

	@RequestMapping(value = "/deleteTaskAction", method = RequestMethod.GET)
	public String deleteTaskAction(@RequestParam int taskID, @RequestParam String taskName, ModelMap model) {
		taskService.deleteTaskVO(taskID);
		List<TaskVO> tasks = taskService.retrieveTaskVOs(taskName);
		model.addAttribute("taskName", taskName);
		model.addAttribute("taskCount", tasks.size());
		model.addAttribute("tasks", tasks);
		return "taskList";// "redirect:listTasks";
	}
}

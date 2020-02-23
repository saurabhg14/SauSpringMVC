package com.spring.learn.vo;

import java.util.Date;

import javax.validation.constraints.Size;

public class TaskVO {
	private int taskID;
	private String taskName;
	
	@Size(min=5, message="minimum 5 characters required")
	private String taskDesc;
	
	
	private Date targetDate;
	private boolean isOpen;
	
	
	public TaskVO() {
	
	}
	public TaskVO(int taskID, String taskName, String taskDesc, Date targetDate, boolean isOpen) {
		super();
		this.taskID = taskID;
		this.taskName = taskName;
		this.taskDesc = taskDesc;
		this.targetDate = targetDate;
		this.isOpen = isOpen;
	}
	public int getTaskID() {
		return taskID;
	}
	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskDesc() {
		return taskDesc;
	}
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	@Override
	public String toString() {
		return "TaskVO [taskID=" + taskID + ", taskName=" + taskName + ", taskDesc=" + taskDesc + ", targetDate="
				+ targetDate + ", isOpen=" + isOpen + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + taskID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskVO other = (TaskVO) obj;
		if (taskID != other.taskID)
			return false;
		return true;
	}

}

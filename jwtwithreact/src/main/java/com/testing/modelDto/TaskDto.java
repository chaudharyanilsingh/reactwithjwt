package com.testing.modelDto;
import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.testing.enums.AllStatus.Status;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskDto {
	
	private int ticketNumber;
	private String ticketLink;
	private String estimatedHours;
	private Date dateOfAssignment;
	private Date dateOfDelivery;
	private Date deadLine;
	private  Status status;
	private Date createdBy;
	private LocalDate createdDate;
	private Date updatedBy;
	private LocalDate updatedDate;
	private boolean delay;
	public int getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public String getTicketLink() {
		return ticketLink;
	}
	public void setTicketLink(String ticketLink) {
		this.ticketLink = ticketLink;
	}
	public String getEstimatedHours() {
		return estimatedHours;
	}
	public void setEstimatedHours(String estimatedHours) {
		this.estimatedHours = estimatedHours;
	}
	public Date getDateOfAssignment() {
		return dateOfAssignment;
	}
	public void setDateOfAssignment(Date dateOfAssignment) {
		this.dateOfAssignment = dateOfAssignment;
	}
	public Date getDateOfDelivery() {
		return dateOfDelivery;
	}
	public void setDateOfDelivery(Date dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}
	public Date getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
		public boolean isDelay() {
		return delay;
	}
	public void setDelay(boolean delay) {
		this.delay = delay;
	}
	public Date getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Date createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Date updatedBy) {
		this.updatedBy = updatedBy;
	}
	public LocalDate getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}


}

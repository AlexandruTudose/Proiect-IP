package com.fiivirtualcatalog.modules.DTOs;

import java.util.Date;

import com.fiivirtualcatalog.modules.user.models.User;

public class CheckInDTO {
	private User user;
	private String subject;
	private String classType;
	private Date createDate;
	private long numberOfCheckedInUsers;
	private boolean finishingFlag;

	public CheckInDTO() {
	}

	public User getUser() {
		return user;
	}

	public String getSubject() {
		return subject;
	}

	public String getClassType() {
		return classType;
	}

	public long getNumberOfCheckedInUsers() {
		return numberOfCheckedInUsers;
	}

	public boolean getFinishingFlag() {
		return finishingFlag;
	}
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public void setNumberOfCheckedInUsers(long numberOfCheckedInUsers) {
		this.numberOfCheckedInUsers = numberOfCheckedInUsers;
	}

	public void setFinishingFlag(boolean finishingFlag) {
		this.finishingFlag = finishingFlag;
	}

	private CheckInDTO(User user, String subject, String classType, long numberOfCheckedInUsers,
			boolean finishingFlag, Date createDate) {
		this.user = user;
		this.subject = subject;
		this.classType = classType;
		this.numberOfCheckedInUsers = numberOfCheckedInUsers;
		this.finishingFlag = finishingFlag;
		this.createDate = createDate;
	}

	public class Builder {
		private User user;
		private String subject;
		private String classType;
		private long numberOfCheckedInUsers;
		private boolean finishingFlag;
		private Date createDate;

		public Builder() {
		}

		public Builder user(User user) {
			this.user = user;
			return this;
		}

		public Builder subject(String subject) {
			this.subject = subject;
			return this;
		}

		public Builder classType(String classType) {
			this.classType = classType;
			return this;
		}

		public Builder numberOfCheckedInUsers(long numberOfCheckedInUsers) {
			this.numberOfCheckedInUsers = numberOfCheckedInUsers;
			return this;
		}

		public Builder finishingFlag(boolean finishingFlag) {
			this.finishingFlag = finishingFlag;
			return this;
		}
		
		public Builder createDate (Date createDate){
			this.createDate = createDate;
			return this;
		}

		public CheckInDTO create() {
			return new CheckInDTO(this.user, this.subject, this.classType, this.numberOfCheckedInUsers,
					this.finishingFlag, this.createDate);
		}

	}
}

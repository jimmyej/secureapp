package pe.com.dev.domain;

import java.io.Serializable;

public class Question implements Serializable {

	private static final long serialVersionUID = -1640728977531182778L;
	
	private int questionId;
	private String secureQuestion;
	private boolean actived;
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getSecureQuestion() {
		return secureQuestion;
	}
	public void setSecureQuestion(String secureQuestion) {
		this.secureQuestion = secureQuestion;
	}
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", secureQuestion=" + secureQuestion + ", actived=" + actived
				+ "]";
	}
}

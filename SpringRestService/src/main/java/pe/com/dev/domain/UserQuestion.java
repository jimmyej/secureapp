package pe.com.dev.domain;

import java.io.Serializable;

public class UserQuestion implements Serializable {

	private static final long serialVersionUID = 894495492624002754L;
	
	private int userId;
	private int questionId;
	private String secureAnswer;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getSecureAnswer() {
		return secureAnswer;
	}
	public void setSecureAnswer(String secureAnswer) {
		this.secureAnswer = secureAnswer;
	}
	@Override
	public String toString() {
		return "UserQuestion [userId=" + userId + ", questionId=" + questionId + ", secureAnswer=" + secureAnswer + "]";
	}
}

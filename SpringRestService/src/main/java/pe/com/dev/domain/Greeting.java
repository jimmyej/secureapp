package pe.com.dev.domain;

public class Greeting {
	private String content;
	
    public Greeting(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }
	@Override
	public String toString() {
		return "Greeting [content=" + content + "]";
	}
}

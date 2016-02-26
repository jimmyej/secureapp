package pe.com.dev.domain;

public class HelloMessage {

    private String name;
    
    public String getName() {
        return name;
    }

	@Override
	public String toString() {
		return "HelloMessage [name=" + name + "]";
	}
}
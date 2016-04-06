package pe.com.jse.constants;

public class URIConstants {
	public static final String DUMMY_USER = "/rest/user/dummy/info";
	
    public static final String GET_USER = "/rest/user/info/{userId}";
    public static final String GET_ALL_USER = "/rest/users";
    public static final String CREATE_USER = "/rest/user/create";
    public static final String UPDATE_USER = "/rest/user/update";
    public static final String DELETE_USER = "/rest/user/delete/{userId}";
    
    public static final String GET_QUESTION = "/rest/question/info/{questionId}";
    public static final String GET_ALL_QUESTION = "/rest/questions";
    public static final String CREATE_QUESTION = "/rest/question/create";
    public static final String UPDATE_QUESTION = "/rest/question/update";
    public static final String DELETE_QUESTION = "/rest/question/delete/{questionId}";
    
}

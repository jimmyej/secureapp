package pe.com.dev.constant;

public class URIConstants {
	
	/*
	 * Common Services
	 * */
	
	//UPLOAD FILE(s)
	public static final String COMMON_FS_SIMPLE_UPLOAD = "/rest/common/fs/upload/simple";
	public static final String COMMON_FS_MULTIP_UPLOAD = "/rest/common/fs/upload/multiple";
	public static final String COMMON_DB_SIMPLE_UPLOAD = "/rest/common/db/upload/simple";
	
	public static final String COMMON_FS_SIMPLE_DOWNLOAD = "/rest/common/fs/download/simple";
	public static final String COMMON_DB_SIMPLE_DOWNLOAD = "/rest/common/db/download/simple";
	
	public static final String COMMON_SIMPLE_EMAIL = "/rest/common/email/simple";
	
    public static final String DUMMY_EMP = "/rest/emp/dummy";
    public static final String GET_EMP = "/rest/emp/{id}";
    public static final String GET_ALL_EMP = "/rest/emps";
    public static final String CREATE_EMP = "/rest/emp/create";
    public static final String UPDATE_EMP = "/rest/emp/update";
    public static final String DELETE_EMP = "/rest/emp/delete/{id}";
    
    public static final String GET_USER_BY_ID = "/rest/user/byid/{id}";
    public static final String GET_USER_BY_NAME = "/rest/user/byname/{name}";
    public static final String GET_ALL_USER = "/rest/users";
    public static final String CREATE_USER = "/rest/user/create";
    public static final String UPDATE_USER = "/rest/user/update";
    public static final String DELETE_USER = "/rest/user/delete/{id}";
    
    public static final String GET_ROLE_INFO = "/rest/role/byid/{id}";
    public static final String GET_ALL_ROLE = "/rest/roles";
    public static final String GET_ROLES_BY_USER = "/rest/roles/byname/{name}";
    public static final String CREATE_ROLE = "/rest/role/create";
    public static final String UPDATE_ROLE = "/rest/role/update";
    public static final String DELETE_ROLE = "/rest/role/delete/{id}";
}

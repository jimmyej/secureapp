package pe.com.dev.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.com.dev.dao.RoleDao;
import pe.com.dev.dao.exec.SqlExecutor;
import pe.com.dev.domain.Role;

@Repository("roleDao")
public class RoleDaoImpl implements RoleDao {

	@Autowired
	SqlExecutor exec;
	
	public void setExec(SqlExecutor exec) {
		this.exec = exec;
	}

	@Override
	public Role getRole(int id) {
		return null;
	}

	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Role> getRolesByUser(String username) {
		List<Role> result = null;
		Map<String, Object> inParams = new HashMap<String, Object>();
		inParams.put("user_name", username);
		Map<String, Object> data = exec.execute("SP_ROLES_BY_USER", inParams);
		if(!data.isEmpty()){
			List<Map<String,Object>> resultSet = (List<Map<String, Object>>) data.get("#result-set-1");
			if(!resultSet.isEmpty()){
				result = new ArrayList<Role>();
				for (Map<String, Object> map : resultSet) {
					Role role = new Role();
					role.setRoleId(Integer.parseInt(map.get("ROLE_ID").toString()));
					role.setRoleName(String.valueOf(map.get("ROLE_NAME")));
					role.setDescription(String.valueOf(map.get("DESCRIPTION")));
					role.setActived(Boolean.parseBoolean(map.get("ACTIVED").toString()));
					result.add(role);
				}
			}
		}
		return result;
	}
	
	@Override
	public int addRole(Role role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updRole(Role role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delRole(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addRoleByUser(String username, String rolename) {
		Map<String, Object> inParams = new HashMap<String, Object>();
		inParams.put("USER_NAME_X", username);
		inParams.put("ROLE_NAME_X", rolename);
		Map<String, Object> data = exec.execute("SP_ADD_ROLE_BY_USER", inParams);
		System.out.println(data);
		return 0;
	}
}

package pe.com.dev.dao.exec;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class SqlExecutor {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	private SimpleJdbcCall sp;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Object queryForObject(String sql, Class<?> c, Object...obj){
		Object object = null;
		if(c!=null && obj !=null && !sql.isEmpty()){
			object = getJdbcTemplate().queryForObject(sql, obj, new BeanPropertyRowMapper<>(c.getClass()));
		}
		return object;
	}
	public Object queryForList(String sql, Class<?> c, Object...obj){
		Object object = null;
		if(c!=null && obj !=null && !sql.isEmpty()){
			object = getJdbcTemplate().query(sql, obj, new BeanPropertyRowMapper<>(c.getClass()));
		}
		return object;
	}
	public Object queryForCUD(String sql, Object...obj){
		Object object = null;
		if(obj !=null && !sql.isEmpty()){
			object = getJdbcTemplate().update(sql, obj);
		}
		return object;
	}
	public Map<String, Object> execute(String spName, Map<String, Object> inParams){
		this.sp = new SimpleJdbcCall(getJdbcTemplate()).withProcedureName(spName);
		Map<String, Object> outMap = sp.execute(inParams);
		return outMap;
	}
}

package pe.com.dev.dao;

import java.util.List;

import pe.com.dev.domain.MenuItem;

public interface MenuitemDao {
	public MenuItem getMenuitem(int id);
	public List<MenuItem> getAllMenuitems();
	public int addMenuitem(MenuItem item);
	public int updMenuitem(MenuItem item);
	public int delMenuitem(int id);
}

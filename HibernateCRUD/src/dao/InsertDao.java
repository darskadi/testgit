package dao;

import java.util.List;

import vo.InsertVo;



public interface InsertDao {

	public void insert(InsertVo insertVo);
	public List view(InsertVo insertVo);
	public void delete(InsertVo insertVo);
	public List search(InsertVo insertVo);
	public void update(InsertVo insertVo);
}

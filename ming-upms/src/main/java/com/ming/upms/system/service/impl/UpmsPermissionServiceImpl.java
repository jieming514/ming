package com.ming.upms.system.service.impl;

import com.ming.upms.common.domain.Tree;
import com.ming.upms.common.util.BuildTree;
import com.ming.upms.system.dao.UpmsPermissionDao;
import com.ming.upms.system.domain.UpmsPermissionDO;
import com.ming.upms.system.service.UpmsPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UpmsPermissionServiceImpl implements UpmsPermissionService {
	@Autowired
	private UpmsPermissionDao upmsPermissionDao;
	
	@Override
	public UpmsPermissionDO get(Long permissionId){
		return upmsPermissionDao.get(permissionId);
	}
	
	@Override
	public List<UpmsPermissionDO> list(Map<String, Object> map){
		return upmsPermissionDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return upmsPermissionDao.count(map);
	}
	
	@Override
	public int save(UpmsPermissionDO upmsPermission){
		return upmsPermissionDao.save(upmsPermission);
	}
	
	@Override
	public int update(UpmsPermissionDO upmsPermission){
		return upmsPermissionDao.update(upmsPermission);
	}
	
	@Override
	public int remove(Long permissionId){
		return upmsPermissionDao.remove(permissionId);
	}
	
	@Override
	public int batchRemove(Long[] permissionIds){
		return upmsPermissionDao.batchRemove(permissionIds);
	}

	/**
	 * 通过用户ID查找资源信息
	 * @param userId
	 * @return
	 */
	@Override
	public Set<String> getPermsByUserId(Long userId) {
		return upmsPermissionDao.getPermsByUserId(userId);
	}

	/**
	 * 通过用户ID查找权限信息
	 */
	@Override
	public List<UpmsPermissionDO> getPermissionByUserId(Long userId){
		return upmsPermissionDao.getPermissionByUserId(userId);
	}

	/**
	 *
	 */
	@Override
	public List<Tree<UpmsPermissionDO>> getTreeByUserId(Long userId) {
		List<Tree<UpmsPermissionDO>> trees = new ArrayList<Tree<UpmsPermissionDO>>();
		List<UpmsPermissionDO> upmsPermissionDOSet = getPermissionByUserId(userId);
		for (UpmsPermissionDO permission : upmsPermissionDOSet) {
			Tree<UpmsPermissionDO> tree = new Tree<>();
			tree.setId(permission.getPermissionId().toString());
			tree.setText(permission.getName());
			tree.setParentId(permission.getPid().toString());
			Map<String, Object> attributes = new HashMap<>(16);
			attributes.put("url", permission.getUri());
			attributes.put("icon", permission.getIcon());
			tree.setAttributes(attributes);
			trees.add(tree);
		}
		List<Tree<UpmsPermissionDO>> list = BuildTree.buildList(trees, "0");
		return list;
	}

	@Override
	public List<UpmsPermissionDO> getSystemPermissionList(Map<String, Object> map) {
		return upmsPermissionDao.getSystemPermissionList(map);
	}

}

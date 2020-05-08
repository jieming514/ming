package com.ming.upms.system.service.impl;

import com.ming.upms.common.domain.Tree;
import com.ming.upms.common.util.BuildTree;
import com.ming.upms.system.dao.UpmsOrganizationDao;
import com.ming.upms.system.domain.UpmsOrganizationDO;
import com.ming.upms.system.service.UpmsOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Service
public class UpmsOrganizationServiceImpl implements UpmsOrganizationService {
	@Autowired
	private UpmsOrganizationDao upmsOrganizationDao;
	
	@Override
	public UpmsOrganizationDO get(Long organizationId){
		return upmsOrganizationDao.get(organizationId);
	}
	
	@Override
	public List<UpmsOrganizationDO> list(Map<String, Object> map){
		return upmsOrganizationDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return upmsOrganizationDao.count(map);
	}
	
	@Override
	public int save(UpmsOrganizationDO upmsOrganization){
		return upmsOrganizationDao.save(upmsOrganization);
	}
	
	@Override
	public int update(UpmsOrganizationDO upmsOrganization){
		return upmsOrganizationDao.update(upmsOrganization);
	}
	
	@Override
	public int remove(Long organizationId){
		return upmsOrganizationDao.remove(organizationId);
	}
	
	@Override
	public int batchRemove(Long[] organizationIds){
		return upmsOrganizationDao.batchRemove(organizationIds);
	}

	@Override
	public UpmsOrganizationDO getOrganizationById(Long organizationId) {
		return upmsOrganizationDao.getOrganizationById(organizationId);
	}

	/**
	 * 获取完整的机构数
	 * @return
	 */
	@Override
	public Tree<UpmsOrganizationDO> getTree() {
		List<Tree<UpmsOrganizationDO>> trees = new ArrayList<Tree<UpmsOrganizationDO>>();
		List<UpmsOrganizationDO> UpmsOrganizationList = list(new HashMap<>());
		for (UpmsOrganizationDO organizationDO : UpmsOrganizationList) {
			Tree<UpmsOrganizationDO> tree = new Tree<UpmsOrganizationDO>();
			tree.setId(organizationDO.getOrganizationId().toString());
			tree.setText(organizationDO.getName());
			tree.setParentId(organizationDO.getPid().toString());
			Map<String, Object> state = new HashMap<>();
			state.put("opened", true);
			tree.setState(state);
			trees.add(tree);
		}
		Tree<UpmsOrganizationDO> t = BuildTree.build(trees);
		return t;
	}



}

package com.kim.biz.member.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kim.biz.member.MemberVO;

@Repository("memberDAO")
public class MemberDAO3 {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertMember(MemberVO vo) {
		mybatis.insert("MemberDAO.insertMember",vo);
		//mybatis.commit();
	}
	
	void updateMember(MemberVO vo) {
		mybatis.update("MemberDAO.updateMember",vo);
		//mybatis.commit();
	}
	
	void deleteMember(MemberVO vo) {
		mybatis.delete("MemberDAO.deleteMember",vo);
		//mybatis.commit();
	}
	
	MemberVO selectOneMember(MemberVO vo) {
		//System.out.println("셀렉트원 멤버 로그");
		return mybatis.selectOne("MemberDAO.selectOneMember",vo);
	}
	
	public List<MemberVO> selectAllMember(MemberVO vo) {
		return mybatis.selectList("MemberDAO.selectAllMember",vo);
	}
	
}

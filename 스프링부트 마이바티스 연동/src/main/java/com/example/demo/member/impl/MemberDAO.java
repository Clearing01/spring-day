package com.example.demo.member.impl;

import com.example.demo.member.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("memberDAO")
public class MemberDAO {

    @Autowired
    private SqlSessionTemplate mybatis;

    public void insertMember(MemberVO vo) {
        System.out.println("회원가입 로그");
        mybatis.insert("com.example.demo.member.MemberService.insertMember", vo);
    }

    void updateMember(MemberVO vo) {

        mybatis.update("com.example.demo.member.MemberService.updateMember", vo);
    }

    void deleteMember(MemberVO vo) {

        mybatis.delete("com.example.demo.member.MemberService.deleteMember", vo);
    }

    MemberVO selectOneMember(MemberVO vo) {

        return mybatis.selectOne("com.example.demo.member.MemberService.selectOneMember", vo);
    }

    public List<MemberVO> selectAllMember(MemberVO vo) {

        return mybatis.selectList("com.example.demo.member.MemberService.selectAllMember", vo);
    }
}
package com.example.demo.member.impl;

import com.example.demo.member.MemberService;
import com.example.demo.member.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("memberServiceImpl")
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDAO memberDAO;

    @Override
    public void insertMember(MemberVO vo) {
        memberDAO.insertMember(vo);
    }

    @Override
    public void deleteMember(MemberVO vo) {
        memberDAO.deleteMember(vo);
    }

    @Override
    public void updateMember(MemberVO vo) {
        memberDAO.updateMember(vo);
    }

    @Override
    public MemberVO selectOneMember(MemberVO vo) {
        return memberDAO.selectOneMember(vo);
    }

    @Override
    public List<MemberVO> selectAllMember(MemberVO vo) {
        return memberDAO.selectAllMember(vo);
    }

}

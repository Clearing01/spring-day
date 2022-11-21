package com.example.demo.member;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberService {
    void insertMember(MemberVO vo);
    void deleteMember(MemberVO vo);
    void updateMember(MemberVO vo);
    MemberVO selectOneMember(MemberVO vo);
    List<MemberVO> selectAllMember(MemberVO vo);
}

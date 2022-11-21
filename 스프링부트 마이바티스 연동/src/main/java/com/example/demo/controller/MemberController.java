package com.example.demo.controller;

import com.example.demo.member.MemberService;
import com.example.demo.member.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("member")
public class MemberController {

    @Autowired
    @Qualifier("memberServiceImpl")
    private MemberService memberService;


    @RequestMapping(value="/", method=RequestMethod.GET)
    public String index() {

        return "login";
    }

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String login() {

        return "login";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String selectOneMember(MemberVO mVO,Model model) {

        mVO=memberService.selectOneMember(mVO);
        if(mVO==null) {
            System.out.print("없는 아이디");
            return "login";
        }
        else {
            System.out.print("있는 아이디");
            model.addAttribute("member",mVO);
            return "main";
        }

    }

    @RequestMapping("/main.do")
    public String main(){

        return "main";
    }

    @RequestMapping("/signUp.do")
    public String signUp(MemberVO mVO) {

        return "signUp";

    }

    @RequestMapping(value="/signUp", method=RequestMethod.POST)
    public String insertMember(MemberVO mVO) {

        memberService.insertMember(mVO);

        return "login";

    }

    @RequestMapping("/mypage")
    public String mypage(MemberVO mVO){

        return "mypage";

    }

    @RequestMapping(value="/updateM", method=RequestMethod.POST)
    public String updateMember(MemberVO mVO, HttpSession httpSession){
        httpSession.invalidate();
        memberService.updateMember(mVO);

        return "login";

    }

    @RequestMapping("/deleteM")
    public String deleteMember(MemberVO mVO,HttpSession httpSession){
        httpSession.invalidate();
        memberService.deleteMember(mVO);

        return "login";

    }
}

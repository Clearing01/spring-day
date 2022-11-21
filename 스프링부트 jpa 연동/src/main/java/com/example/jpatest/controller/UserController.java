package com.example.jpatest.controller;

import com.example.jpatest.entity.UserEntity;
import com.example.jpatest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@RestController
@SessionAttributes("member")
public class UserController {
    @Autowired
    @Qualifier("JpaUserRepository")
    UserRepository userRepository;

    @GetMapping("/")
    public ModelAndView login(ModelAndView mv, UserEntity user) {

        mv.setViewName("login");

        return mv;
    }

    @GetMapping("/signUp")
    public ModelAndView signUp(ModelAndView mv, UserEntity user){
        mv.setViewName("signUp");
        return mv;
    }

    @PostMapping("/login")
    public ModelAndView main(ModelAndView mv, UserEntity user) {
        Optional<UserEntity> data = userRepository.findById(user.getId());
        List<UserEntity> datas =userRepository.findAll();
        System.out.println(data);

        if(data.isEmpty()){
            mv.setViewName("login");
        }
        else {
            UserEntity member = data.get();
            mv.addObject("member",member);
            mv.setViewName("main");
        }

        mv.addObject("datas",datas);


        return mv;
    }

    @PostMapping(value="/insertM")
    public ModelAndView insertMember(ModelAndView mv,UserEntity user) {
        userRepository.save(user);
        mv.setViewName("login");

        return mv;

    }

    @GetMapping("/mypage")
    public ModelAndView mypage(ModelAndView mv, UserEntity user){
        mv.setViewName("mypage");
        return mv;
    }


    @GetMapping("/deleteM")
    public ModelAndView deleteM(ModelAndView mv, @ModelAttribute("member") UserEntity user, HttpSession httpSession){

        userRepository.delete(user.getId());

        mv.setViewName("login");
        httpSession.invalidate();
        return mv;
    }

    @PostMapping(value="/updateM")
    public ModelAndView updateM(ModelAndView mv, UserEntity user, HttpSession httpSession) {
        userRepository.update(user);
        mv.setViewName("login");
        httpSession.invalidate();

        return mv;

    }

}

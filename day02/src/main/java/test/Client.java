package test;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kim.biz.board.BoardService;
import com.kim.biz.board.BoardVO;
import com.kim.biz.member.MemberService;
import com.kim.biz.member.MemberVO;

public class Client {
	public static void main(String[] args) {
		// Spring 컨테이너를 동작시킬수있도록 코드작성
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService bs=(BoardService)factory.getBean("boardService");
		MemberService ms = (MemberService)factory.getBean("memberService");
		
//		BoardVO vo=new BoardVO();
		MemberVO vo = new MemberVO();
		BoardVO bvo = new BoardVO();
		Scanner sc=new Scanner(System.in);
		
//		System.out.println(ms.selectAllMember(vo));
		System.out.println("=====================");
//		System.out.println(bs.selectAllBoard(bvo));
		
		
//-------------------------------------- 로그인		
		System.out.print("아이디: ");
		String id = sc.next();
		System.out.print("비밀번호: ");
		String pw = sc.next();
		 
		vo.setMid(id);
		vo.setMpw(pw);
		vo = ms.selectOneMember(vo);
		System.out.println(vo);
		
		
		
//-------------------------------------- 회원가입		
//		System.out.print("아이디: ");
//		String id = sc.next();
//		System.out.print("비밀번호: ");
//		String pw = sc.next();
//		System.out.print("이름: ");
//		String name = sc.next();
//		System.out.print("역할: ");
//		String role = sc.next();
//		
//		vo.setMid(id);
//		vo.setMpw(pw);
//		vo.setName(name);
//		vo.setRole(role);
//		ms.insertMember(vo);
		
// -------------------------------------- 글작성
//		System.out.print("내용작성 >> ");
//		String msg=sc.nextLine();
//		vo.setContent(msg);
//		vo.setTitle("글 제목");
//		vo.setWriter("작은 티모");
//		bs.insertBoard(vo);
		

//		List<BoardVO> datas=bs.selectAllBoard(vo);
//		for(BoardVO v:datas) {
//			System.out.println(v);
//		}
		
		factory.close();
		
		// Spring 컨테이너야, 나 폰 객체를 가지고싶어!
		// == Lookup == 객체요청: 컨테이너야, 가지고있는 객체중에서 이름이 "phone"인 객체를 줘!
		/*
		Phone phone=(Phone)factory.getBean("gp");
		phone.powerOn();
		phone.volumeUp();
		phone.volumeDown();
		phone.powerOff();
		factory.close();
		*/
		
		/*
		BeanFactory bf=new BeanFactory();
		Phone phone=(Phone)bf.getBean(args[0]);
		phone.powerOn();
		phone.volumeUp();
		phone.volumeDown();
		phone.powerOff();
		*/
	}
}

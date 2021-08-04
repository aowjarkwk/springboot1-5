package com.study.Ex01_DI;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

//8080 포트는 오라클 11g xe에서 사용중...
//server.port=8090
//서버포트를 8090으로 사용

//eclipse - Dynamic Web Project는 C:\톰캣서버 8.5를 연동해서 사용! -> 8081포토
//STS4는 내장 톰켓 서버를 사용함.(이클립스안에 내장) -> 8090포트를 사용!

//Spring Framework : 자바 백엔드 지원 클래스의 모임.
//                   여러개의 조합으로 이루어짐.
//                   중/대/공기업에서 표준 솔루션으로 많이 사용함.
//Framework : 뼈대, SW라이브러리(클래스) 모음 - 큰 규모
//Library : SW함수(클래스) 모임 - 작은 규모
//API : Application Protocal Interface - 함수(클래스)모임. 
//SDK : Softward Development Kit - SW함수(클래스) 모임.

//의존 주입 : DI Dependency Injection
	// 장점 : null safety 지원, 싱글톤 공급, new 자동으로 해줌.

//강한 결합 : 직접 new로 클래스 객체를 생성해서 사용하는 것.
    // 단점 : null safety하지 않다.
	//      : 싱글톤유지를 해주지 않는다.

//@SpringBootApplication
public class Ex01DiApplication {

	public static void main(String[] args) {
		//SpringApplication.run(Ex01DiApplication.class, args);
		
		//직접 new해서 사용 - 강한 결합
		//Member m = new Member();
		
		//m = null;
		
		Member m = Member.getInstance();
		
		printName( m );
	}
	//외부에서 생성된 객체를 매개변수 입력(주입)받는다.
	//의존 주입 : 장점 - 외부의 환경에 영향을 적게 받는다.
	public static void printName( Member m ) {
		// Member m = new Member(); 직접 생성하지 않는다.
		System.out.println(m.name);
	}
}

class Member {
	String name = "홍길동";
	String nickname ="의적";
	
	//싱글톤 만들기
	private static Member m = null;
	public static Member getInstance() {
		if(m==null) {
			m = new Member();
		}
		return m;
	}
	
	public Member() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}

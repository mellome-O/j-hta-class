package homework;

import java.util.List;

public class Program {
	public static void main(String[] args) {
		/*1) Oracle 데이터베이스에서 MEMBER 테이블의 레코드를 담을 수 있는 Member 클래스는 정의하시오.*/

		
		/*2) 다음 메소드를 제공할 것이라는 약속으로 com.newlecture.dao.MemberDao를 정의하시오.*/

	   /*Member get(String id);
			   List<Member> getList();
			   List<Member> getList(String query); // 이름에 query 문자가 포함된 회원을 검색
		*/
	   

		/* 3) MemberDao 인터페이스를 구현하는 JdbcMemberDao 클래스 코드를 작성하시오. */
	   
	  JdbcMemberDao jmd = new JdbcMemberDao();
	  System.out.println(jmd.get("newlec").getId());
	  
	 List<Member> a = jmd.getList();
	 
	 for(Member e: a)
		 System.out.println(e);
		  
	 

	}

}


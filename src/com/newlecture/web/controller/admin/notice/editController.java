package com.newlecture.web.controller.admin.notice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.oracle.OracleNoticeDao;
import com.newlecture.web.entity.Notice;

//�޼ҵ尡������ 405?
@WebServlet("/admin/notice/edit")
public class editController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Integer id = Integer.parseInt(request.getParameter("id"));
	
//������ �Ѿ �� 2����
//������� ���� �̾ �۾��� ���� ���� �� 
//���巺Ʈ�� �۾��� ������ ���ο� ������ ���������� ���

//��½� �ѱ������ �����°��
//�������� �ѱ��� �������� �ʴ� �����ڵ�����ڵ��Ѱ��
//���������� utf-8�� ���ڵ��ؼ��������� �������� �ٸ��ڵ���߸��ؼ��Ѱ��
//response.setCharacterEncoding("UTF-8");
//response.setContentType("type=");
//�Է��� �� ������ ��쿡�� �Է¹ޱ� ���� request.setCharacterEncoding("UTF-8"); �� �־�����Ѵ�

//������ ����
//��Ĺ�� ���� ���������� ����Ǵµ�
//������ �� �߰��� ����,������ �� ����
//����̳� �Է¿� ���� ���� �̸� �����س��� ��


//������ Ǯ��
		
NoticeDao noticeDao  = new OracleNoticeDao();
		
Notice notice = new Notice();
notice.setId(id);
notice.setTitle(title);
notice.setContent(content);
		
int result=0;
try {
	result = noticeDao.update(notice);
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println("wkrna"+result);
if(result !=1)
	response.sendRedirect("error");
else
	response.sendRedirect("detail?id="+id);
		
	}		
		
		
//		NoticeDao noticeDao  = new OracleNoticeDao();
//		
//		try {
//			noticeDao.update(new Notice(id,title,content,"",null,0));
//			request.setAttribute("notice",noticeDao.get(id));
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		request.getRequestDispatcher("../WEB-INF/view/notice/detail.jsp").forward(request, response);
//	}
	
	
    @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //hello?cnt3 ->3?
    //hello? -> ""
    //hello -> null
    	
    	
      NoticeDao noticeDao  = new OracleNoticeDao();
      
      Integer id = Integer.parseInt(request.getParameter("id"));
  
       try {
		request.setAttribute("notice",  noticeDao.get(id));
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       
       request.getRequestDispatcher("../WEB-INF/view/notice/edit.jsp").forward(request, response);

   }
   
   
}
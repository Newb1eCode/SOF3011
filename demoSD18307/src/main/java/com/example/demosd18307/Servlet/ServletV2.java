package com.example.demosd18307.Servlet;

import com.example.demosd18307.moudel.SinhVien;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletV2", value ={ "/trang-chu","/addSv"})
public class ServletV2 extends HttpServlet {
    ArrayList<SinhVien> lst ;

    public ServletV2() {
       lst = new ArrayList<>();
        SinhVien sv = new SinhVien("Thanh",20,"Nam","PH32846","SD18307");
        lst.add(sv);
        lst.add(new SinhVien("Thanh",20,"Nam","PH32846","SD18307"));

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       String ten = "Thanhdx";
//       int tuoi = 20;
//       String fact = "Game";
//       String img = "https://cdn.vjshop.vn/tin-tuc/10-buoc-huong-dan-chup-anh-duong-pho/huong-dan-chup-anh-duong-pho-11.jpg";
//       request.setAttribute("age",tuoi);
//       request.setAttribute("fav",fact);
//       request.setAttribute("name",ten);
//       request.setAttribute("img",img);


//        request.getRequestDispatcher("/Sinhvien/home.jsp").forward(request,response);

//        str.add("A");
//        str.add("S");
//        str.add("D");
//        str.add("F");
        request.setAttribute("listSv",lst);
        request.getRequestDispatcher("/Sinhvien/Sinhvien.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("/Sinhvien/AddSV.jsp").forward(request,response);
        String id = request.getParameter("id");
        String ten = request.getParameter("name");
        Integer tuoi = Integer.parseInt(request.getParameter("age"));
        String gioiTinh = request.getParameter("sex");
        System.out.println(gioiTinh);
        String lop = request.getParameter("class");
        SinhVien sv3 = new SinhVien(ten,tuoi,gioiTinh,id,lop);
        System.out.println(sv3.toString());
        lst.add(sv3);

        response.sendRedirect("/trang-chu");
    }
}

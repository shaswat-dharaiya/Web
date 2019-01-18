/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vvp.java;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class SignUp extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            boolean redirecting=false;
            String usn = request.getParameter("Username");
            if(usn == null)
            {
                redirecting = true;
            }
            char[] username = usn.toCharArray();
            for(int i=0;i<username.length;i++)
            {
                if(!Character.isLetter(username[i]))
                {
                    redirecting = true;
                }
            }
            out.println(usn + "<br>");
            
            
            String psw = request.getParameter("Password");
            String conPsw = request.getParameter("Confirm Password");
            if(!psw.equals(conPsw))
            {
                redirecting = true;
            }
            else
            {
                    out.println(psw + "<br>");
                    out.println(conPsw + "<br>");
            }
             
            String emailID = request.getParameter("Email Id");
            if(emailID.indexOf('@')==-1)
            {
                redirecting = true;
                
            }
            else
            {
                out.println(emailID + "<br>");
                String[] arrOfEmail = emailID.split("@");
                out.println(arrOfEmail[0] + "<br>" + arrOfEmail[1] + "<br>");
                char[] arrId1 = arrOfEmail[0].toCharArray();
                for(int i=0;i<arrId1.length;i++)
                {
                    if(!Character.isLetter(arrId1[i]))
                    {
                        if(arrId1[i]!='.' && arrId1[i]!='_')
                        {
                            redirecting = true;
                        }
                    }
                }
                char[] arrId2 = arrOfEmail[1].toCharArray();
                for(int i=0;i<arrId2.length;i++)
                {
                    if(!Character.isLetter(arrId2[i]))
                    {
                        if(arrId2[i]!='.')
                        {
                            redirecting = true;
                        }
                    }
                }    
            }

            String numbre = request.getParameter("phone");
            char[] num = numbre.toCharArray();
            {
                for(int i=0;i<num.length;i++)
                {
                    if(!Character.isDigit(num[i]))
                    {
                        redirecting = true;
                    }
                }
            }
            String code = "+91";
            numbre = code.concat(numbre);
            
            out.println(numbre + "<br>");
            
            
            
            
            int sem = Integer.parseInt(request.getParameter("Semester"));
            if(sem<5)
            {
                redirecting = true;
            }
            out.println("Sem " + sem + "<br>");
            
            String br = request.getParameter("Branch");
            if(!br.equals("CE") && !br.equals("EC") && !br.equals("IT"))
            {
                redirecting = true;
            }
            out.println(br + "<br>");
            
            String clg = request.getParameter("College");
            char[] clgName = clg.toCharArray();
            for(int i=0;i<clgName.length;i++)
            {
                if(!Character.isLetter(clgName[i]))
                {
                    if(clgName[i]!='.')
                    {
                        redirecting = true; 
                    }
                }
            }
            out.println(clg + "<br>");
            
            if(redirecting == true)
            {
                                        out.println("Redirect");
                        response.sendRedirect("signUp.html");
            }

        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

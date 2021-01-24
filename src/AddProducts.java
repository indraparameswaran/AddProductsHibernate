
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.*;
import javax.xml.bind.*;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ecommerce.HibernateUtil;
import com.ecommerce.Products;


/**
* Servlet implementation class InitHibernate
*/
@WebServlet("/AddProducts")
public class AddProducts extends HttpServlet {
        private static final long serialVersionUID = 1L;
       
        
        
    /**
* @see HttpServlet#HttpServlet()
*/
    public AddProducts() {
        super();
        // TODO Auto-generated constructor stub
        
    }

   
        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                 try {
                	 
                	     Products products = new Products();
                	     
                	    
                	     products.setName(request.getParameter("name"));
                	     products.setCategory(request.getParameter("category"));
                	     products.setStock_quantity(Integer.parseInt(request.getParameter("stock_quantity")));
                	     
                	     SessionFactory factory = HibernateUtil.getSessionFactory();
                         
                         Session session = factory.openSession();
                         
                         Transaction transaction = null;
                         
                         transaction = session.beginTransaction();
                         
                         session.save(products);
                         
                         transaction.commit();
                         
                         session.close();
                	     
                         PrintWriter out = response.getWriter();
                         out.println("<html><body>");

                         
                         out.println("Product Record Successfully Added.<br>");
                         
                         out.println(products.toString());
                                
                         out.println("</body></html>");
                            
                             
                         } catch (Exception ex) {
                                 throw ex;
                         }

        }

        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                doGet(request, response);
        }

}





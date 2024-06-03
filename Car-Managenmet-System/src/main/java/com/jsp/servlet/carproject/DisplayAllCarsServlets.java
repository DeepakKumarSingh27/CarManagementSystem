package com.jsp.servlet.carproject;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

@WebServlet("/DisplayAllCars")
public class DisplayAllCarsServlets extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Car.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session =sf.openSession();
		Transaction transaction= session.beginTransaction();
		
		Query<Car> query = session.createQuery("FROM Car");
		List<Car> cars = query.list();
		
		transaction.commit();
		session.close();
		
		req.setAttribute("CarList",cars);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("DisplayAllCars.jsp");
		requestDispatcher.forward(req, resp);
	}

}

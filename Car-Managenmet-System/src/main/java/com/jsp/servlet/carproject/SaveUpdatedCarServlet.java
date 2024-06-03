package com.jsp.servlet.carproject;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class SaveUpdatedCarServlet extends HttpServlet {
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			int carId = Integer.parseInt(req.getParameter("carId"));
			String carModel = req.getParameter("carModel");
			String carBrand = req.getParameter("carBrand");
			int carPrice = Integer.parseInt(req.getParameter("carPrice"));
			
			Car car = new Car();
			car.setCarId(carId);
			car.setCarModel(carModel);
			car.setCarBrand(carBrand);
			car.setCarPrice(carPrice);
			
			
			Configuration cfg = new Configuration().configure().addAnnotatedClass(Car.class);
			SessionFactory sf = cfg.buildSessionFactory();
			Session session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			
			session.update(car);
			
			Query<Car> query = session.createQuery("FROM Car");
			List<Car> cars = query.list();
			
			transaction.commit();
			session.close();
			
			req.setAttribute("carList",car);
			RequestDispatcher requestDispatcher =req.getRequestDispatcher("DisplayAllCars");
			requestDispatcher.forward(req, resp);
		}
}

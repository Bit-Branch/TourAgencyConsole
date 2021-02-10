package by.bsuir.java.dao.factory;

import by.bsuir.java.dao.*;
import by.bsuir.java.dao.impl.*;


public class DAOFactory {

	private static final DAOFactory instance = new DAOFactory();

	private final AccountDAO accountDAO = new FileAccountDAO();
	private final TourDAO tourDAO = new FileTourDAO();
	private final ClientDAO clientDAO = new FileClientDAO();
	private final EmployeeDAO employeeDAO = new FileEmployeeDAO();
	private final CountryDAO countryDAO = new FileCountryDAO();
	private final DiscountDAO discountDAO = new FileDiscountDAO();
	private final HotelDAO hotelDAO = new FileHotelDAO();
	private final ReturnDAO returnDAO = new FileReturnDAO();
	private final SaleDAO saleDAO = new FileSaleDAO();

	private DAOFactory() {
	}

	public EmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}

	public static DAOFactory getInstance() {
		return instance;
	}

	public AccountDAO getAccountDAO() {
		return accountDAO;
	}


	public ClientDAO getClientDAO() {
		return clientDAO;
	}

	public CountryDAO getCountryDAO() {
		return countryDAO;
	}

	public DiscountDAO getDiscountDAO() {
		return discountDAO;
	}

	public HotelDAO getHotelDAO() {
		return hotelDAO;
	}

	public ReturnDAO getReturnDAO() {
		return returnDAO;
	}

	public SaleDAO getSaleDAO() {
		return saleDAO;
	}

	public TourDAO getTourDAO() {
		return tourDAO;
	}
}
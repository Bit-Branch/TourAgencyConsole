package by.bsuir.java.dao.impl;


import by.bsuir.java.dao.TourDAO;
import by.bsuir.java.dao.converter.impl.TourConverter;
import by.bsuir.java.dao.datasource.DataSource;
import by.bsuir.java.dao.datasource.exception.DataSourceException;
import by.bsuir.java.dao.exception.DAOException;
import by.bsuir.java.dao.validator.DAOValidator;
import by.bsuir.java.entity.Tour;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FileTourDAO implements TourDAO, DAOValidator {

	private DataSource<Tour> dataSource;
	private TourConverter tourConverter;

	public FileTourDAO() {
		dataSource = new DataSource<>("/Tours.txt");
		tourConverter = new TourConverter();
	}

	public FileTourDAO(DataSource<Tour> dataSource, TourConverter accountConverter) {
		this.dataSource = dataSource;
		this.tourConverter = accountConverter;
	}

	public DataSource<Tour> getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource<Tour> dataSource) {
		this.dataSource = dataSource;
	}

	public TourConverter getTourConverter() {
		return tourConverter;
	}

	public void setTourConverter(TourConverter tourConverter) {
		this.tourConverter = tourConverter;
	}


	@Override
	public List<Tour> getAll() throws DAOException {
		List<Tour> users;
		try {
			users = dataSource.read(tourConverter);
		} catch (DataSourceException e) {
			String error = "Can not get all records in FileUserDAO: " + e.getMessage();
			throw new DAOException(error, e);
		}
		return users;
	}

	@Override
	public Tour getById(Integer id) throws DAOException {
		String error = "Unable to get user by id : ";
		if (isNull(id)) {
			throw new DAOException(error + "id has null value");
		}
		Tour profile = null;
		List<Tour> users = getAll();
		for (Tour user : users
		) {
			if (user.getId() == id) {
				profile = user;
				break;
			}
		}
		return profile;
	}

	@Override
	public Long add(Tour object) throws DAOException {
		String error = "Unable to add user: ";
		if (isNull(object)) {
			throw new DAOException(error + "user has null value");
		}
		try {
			dataSource.write(object, true, tourConverter);
		} catch (DataSourceException e) {
			throw new DAOException(error + e.getMessage(), e);
		}
		return object.getId();
	}

	@Override
	public void update(Tour object) throws DAOException {
		String error = "Unable to update user: ";
		if (isNull(object)) {
			throw new DAOException(error + "object has null value");
		}
		List<Tour> users = getAll();
		Iterator<Tour> userIterator = users.iterator();
		while (userIterator.hasNext()) {
			Tour nextUser = userIterator.next();
			if (nextUser.getId() == object.getId()) {
				nextUser.setName(object.getName());
				nextUser.setPrice(object.getPrice());
				nextUser.setDepartureTime(object.getDepartureTime());
				nextUser.setDepartureCity(object.getDepartureCity());
				nextUser.setAdultsCount(object.getAdultsCount());
				nextUser.setChildrenCount(object.getChildrenCount());
				nextUser.setDaysCount(object.getDaysCount());
				nextUser.setNightsCount(object.getNightsCount());
				nextUser.setHotelID(object.getHotelID());
				nextUser.setDiscountID(object.getDiscountID());

			}
		}
		try {
			dataSource.write(users, tourConverter);
		} catch (DataSourceException e) {
			throw new DAOException(error + e.getMessage(), e);
		}
	}

	@Override
	public void delete(Integer id) throws DAOException {
		String error = "Unable to delete user: ";
		if (isNull(id)) {
			throw new DAOException(error + "object has null value");
		}
		List<Tour> users = getAll();
		Iterator<Tour> userIterator = users.iterator();
		while (userIterator.hasNext()) {
			Tour nextUser = userIterator.next();
			if (nextUser.getId() == id) {
				userIterator.remove();
			}
		}
		try {
			dataSource.write(users, tourConverter);
		} catch (DataSourceException e) {
			throw new DAOException(error + e.getMessage(), e);
		}
	}

	@Override
	public List<Tour> getAllByHotelId(Integer idHotel) throws DAOException {
		String error = "Unable to get clients by id: ";
		if (isNull(idHotel)) {
			throw new DAOException(error + "idHotel has null value");
		}
		List<Tour> dataSourceExpenseList;
		List<Tour> expenseList = new ArrayList<>();
		try {
			dataSourceExpenseList = dataSource.read(tourConverter);
			for (Tour expense : dataSourceExpenseList
			) {
				if (idHotel == expense.getHotelID()) {
					expenseList.add(expense);
				}
			}
		} catch (DataSourceException e) {
			throw new DAOException(error + e.getMessage(), e);
		}
		return expenseList;
	}

	@Override
	public List<Tour> getAllByDiscountId(Integer idDiscount) throws DAOException {
		String error = "Unable to get clients by id: ";
		if (isNull(idDiscount)) {
			throw new DAOException(error + "idAccount has null value");
		}
		List<Tour> dataSourceExpenseList;
		List<Tour> expenseList = new ArrayList<>();
		try {
			dataSourceExpenseList = dataSource.read(tourConverter);
			for (Tour expense : dataSourceExpenseList
			) {
				if (idDiscount == expense.getDiscountID()) {
					expenseList.add(expense);
				}
			}
		} catch (DataSourceException e) {
			throw new DAOException(error + e.getMessage(), e);
		}
		return expenseList;
	}
}
package by.bsuir.java.service.factory;

import by.bsuir.java.entity.Discount;
import by.bsuir.java.service.*;
import by.bsuir.java.service.impl.*;



public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final AccountService accountService = new AccountServiceImpl();

    private final ClientService clientService = new ClientServiceImpl();

    private final TourService tourService = new TourServiceImpl();

    private final EmployeeService employeeService = new EmployeeServiceImpl();

    private final CountryService countryService = new CountryServiceImpl();

    private final DiscountService discountService = new DiscountServiceImpl();

    private final HotelService hotelService = new HotelServiceImpl();

    private final ReturnService returnService = new ReturnServiceImpl();

    private final SaleService saleService = new SaleServiceImpl();

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }

    public SaleService getSaleService() {
        return saleService;
    }

    public AccountService getAccountService(){
        return accountService;
    }

    public ClientService getClientService(){
        return clientService;
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public CountryService getCountryService() {
        return countryService;
    }

    public DiscountService getDiscountService() {
        return discountService;
    }

    public HotelService getHotelService() {
        return hotelService;
    }

    public ReturnService getReturnService() {
        return returnService;
    }

    public TourService getTourService() {
        return tourService;
    }
}

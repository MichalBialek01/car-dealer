package pl.bialek.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bialek.domain.*;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CarPurchaseService {

    private final CustomerService customerService;
    private final CarService carService;
    private final SalesmanService salesmanSercice;

    public Invoice purchase(CarPurchaseRequest carPurchaseRequest) {

        return carPurchaseRequest.getExistingCustomerEmail().isBlank()
                ? processFirstTimeCustomer(carPurchaseRequest)
                : processNextTimeCustomer(carPurchaseRequest);
    }

    private Invoice processFirstTimeCustomer(CarPurchaseRequest carPurchaseRequest) {
        CarToBuy carToBuy = carService.findCarToBuy(carPurchaseRequest.getCarVin());
        Salesman salesman = salesmanSercice.findSalesman(carPurchaseRequest.getSalesmanPesel());
        Invoice invoice = buildInvoice(carToBuy, salesman);

        Customer customer = buildCustomer(carPurchaseRequest,invoice);
        customerService.issueInvoice(customer);
        return invoice;
    }

    private Invoice processNextTimeCustomer(CarPurchaseRequest carPurchaseRequest) {
            Customer existingCustomer = customerService.findCustomer(carPurchaseRequest.getExistingCustomerEmail());
            CarToBuy car = carService.findCarToBuy(carPurchaseRequest.getCarVin());
            Salesman salesman = salesmanSercice.findSalesman(carPurchaseRequest.getSalesmanPesel());
            Invoice invoice = buildInvoice(car, salesman);
            Set<Invoice> existingInvoices = existingCustomer.getInvoices();
            existingInvoices.add(invoice);
            customerService.issueInvoice(existingCustomer.withInvoices(existingInvoices));
            return invoice;
    }


    private Customer buildCustomer(CarPurchaseRequest carPurchaseRequest, Invoice invoice) {
        return Customer.builder()
                .name(carPurchaseRequest.getCustomerName())
                .surname(carPurchaseRequest.getCustomerSurname())
                .phone(carPurchaseRequest.getCustomerPhone())
                .email(carPurchaseRequest.getCustomerEmail())
                .address(
                        Address.builder()
                                .country(carPurchaseRequest.getCustomerAddressCountry())
                                .city(carPurchaseRequest.getCustomerAddressCity())
                                .postalCode(carPurchaseRequest.getCustomerAddressPostalCode())
                                .address(carPurchaseRequest.getCustomerAddressStreet())
                                .build()
                )
                .invoices(Set.of(invoice))
                .build();
    }

    private Customer createNextTimeToBuyCustomer(CarPurchaseRequestInputData inputData) {
        Customer exisitngCustomer = customerService.findCustomer(inputData.getCustomerEmail());
        //Catching car - having single value (VIN)
        CarToBuy car = carService.findCarToBuy(inputData.getCarVin());
        //Caching Salesman - having single value (PESEL)
        Salesman salesman = salesmanSercice.findSalesman(inputData.getSalesmanPesel());
        //Building Invoice basing on buingCar and salesman
        Invoice invoice = buildInvoice(car, salesman);
        exisitngCustomer.getInvoices().add(invoice);
        return exisitngCustomer;
    }


    private Invoice buildInvoice(CarToBuy car, Salesman salesman) {
        return Invoice
                .builder()
                .invoiceNumber(UUID.randomUUID().toString())
                .dateTime(OffsetDateTime.now())
                .car(car)
                .salesman(salesman)
                .build();
    }


    public List<CarToBuy> availableCars() {
        return carService.findAvailableCars();
    }

    public List<Salesman> availableSalesmen() {
        return salesmanSercice.findAvailableSalesmen();
    }
}

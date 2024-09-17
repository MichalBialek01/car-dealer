package pl.bialek.business.dao;

import pl.bialek.domain.CarServiceRequest;
import pl.bialek.domain.ServiceMechanic;
import pl.bialek.domain.ServicePart;

public interface ServiceRequestProcessingDAO {
    void process(CarServiceRequest carServiceRequest, ServiceMechanic mechanic, ServicePart servicePart);

    void process(CarServiceRequest carServiceRequest, ServiceMechanic mechanic);
}

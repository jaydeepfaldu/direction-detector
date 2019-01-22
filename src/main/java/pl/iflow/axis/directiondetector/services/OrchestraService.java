package pl.iflow.axis.directiondetector.services;

public interface OrchestraService {

    void createVisitCall(String branchId, String entryPointId, String servicePointId, String serviceId);

    void callAndEndCall(String branchId, String entryPointId, String servicePointId, String serviceId);

}

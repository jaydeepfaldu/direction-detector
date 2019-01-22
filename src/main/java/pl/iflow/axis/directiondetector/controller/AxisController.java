package pl.iflow.axis.directiondetector.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.iflow.axis.directiondetector.services.OrchestraService;

@RestController
@RequestMapping("/axis")
public class AxisController {

    @Autowired
    OrchestraService orchestraService;

    @RequestMapping("/in")
    public String onCustomerComeIn(@RequestParam("branchId") String branchId,
                                   @RequestParam("entryPointId") String entryPointId,
                                   @RequestParam("servicePointId") String servicePointId,
                                   @RequestParam("serviceId") String serviceId){

        orchestraService.createVisitCall(branchId, entryPointId, servicePointId, serviceId);

        return "THIS IS ssaaasasaaa " + entryPointId;

    }

    @RequestMapping("/out")
    public String onCustomerComeOut(@RequestParam("branchId") String branchId,
                                    @RequestParam("entryPointId") String entryPointId,
                                    @RequestParam("servicePointId") String servicePointId,
                                    @RequestParam("serviceId") String serviceId){


        orchestraService.callAndEndCall(branchId, entryPointId, servicePointId, serviceId);


        return "THIS IS OUT " + branchId;

    }


}

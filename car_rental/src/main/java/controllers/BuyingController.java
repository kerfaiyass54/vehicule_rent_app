package controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.BuyingService;

@RestController
@RequestMapping("/buying")
@CrossOrigin(origins = "http://localhost:4200")
public class BuyingController {

    @Autowired
    private BuyingService buyingService;
}

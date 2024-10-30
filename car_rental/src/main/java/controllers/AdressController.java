package controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.AdressService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/adress")
public class AdressController {

    @Autowired
    private AdressService adressService;
}

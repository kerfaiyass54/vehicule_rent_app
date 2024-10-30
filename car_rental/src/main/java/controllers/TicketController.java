package controllers;


import entities.Client;
import entities.Repair;
import entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.TicketService;

@RestController
@RequestMapping("/ticket")
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/client/{name}")
    public Client getClient(@PathVariable String name){
        return ticketService.getClient(name);
    }

    @GetMapping("/repair/{name}")
    public Repair getRepair(@PathVariable String name){
        return ticketService.getRepair(name);
    }

    @GetMapping("/status/{id}")
    public void changeStatus(@PathVariable long id){
        ticketService.changeStatus(id);
    }

    @GetMapping("/ticket/{repairName}")
    public void addTicket(@RequestBody Ticket ticket,@PathVariable String repairName,@RequestParam String clientName){
        ticketService.addTicket(ticket, repairName, clientName);
    }

    @GetMapping("/remove")
    public void removeTicket(@RequestBody Ticket ticket){}
}

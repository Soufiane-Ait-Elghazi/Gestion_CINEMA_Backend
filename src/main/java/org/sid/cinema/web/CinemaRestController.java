package org.sid.cinema.web;
import lombok.Data;
import lombok.ToString;

import org.sid.cinema.dao.FilmRepository;
import org.sid.cinema.dao.TicketRepository;
import org.sid.cinema.entities.Film;
import org.sid.cinema.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


@RestController
@CrossOrigin(origins = "*")
public class CinemaRestController {
    @Autowired
    private FilmRepository filmRepository ;
    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping(path = "/listFilms")
    public   List<Film> films(){
        return filmRepository.findAll();
    }

  
    @GetMapping(path = "/photoFilm/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    @Transactional
    public byte[] image(@PathVariable(name = "id")Long id) throws Exception {
        Film f = filmRepository.findById(id).get();
        String photoName = f.getPhoto();
        File file = new File(System.getProperty("user.home")+"/cinema/images/"+photoName+".jpg");
           Path path = Paths.get(file.toURI());
           return Files.readAllBytes(path);
    }


    
     
    @PostMapping(path = "/payerTickets")
    @Transactional
    public List<Ticket> payerTickets(@RequestBody TicketForm ticketForm){
    	System.out.println(ticketForm.getCodePayement());
        List<Ticket> tickets =new ArrayList<>();
        ticketForm.getTickets().forEach(t->{
            Ticket T = ticketRepository.findById(t).get();
            T.setNomClient(ticketForm.getNomClient());
            T.setReserve(true);
            ticketRepository.save(T);
            tickets.add(T);
        });
        return tickets;
    }
}

@Data
@ToString
class TicketForm{
    private List<Long> tickets = new ArrayList<>();
    private String codePayement;
    private  String nomClient ;
}


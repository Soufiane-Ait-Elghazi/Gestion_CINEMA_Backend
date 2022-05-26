package org.sid.cinema.entities;

import org.springframework.data.rest.core.config.Projection;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
@Projection(name = "ticketProj",types = {org.sid.cinema.entities.Ticket.class})
public interface ticketProj {
    public Long getId();
    public String getNomClient();
    public double getPrix();
    public String getCodePayement();
    public Boolean getReserve();
    public Place getPlace();
    
}

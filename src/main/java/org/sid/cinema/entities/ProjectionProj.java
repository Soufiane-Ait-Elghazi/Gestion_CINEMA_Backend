package org.sid.cinema.entities;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1",types = {org.sid.cinema.entities.Projection.class})
public interface ProjectionProj {
  public Long  getId();
  public Double getPrix();
  public Date getDateProjection();
  public Salle getSalle();
  public Film getFilm();
  public Seance getSeance();
  public Collection<Ticket> getTickets();
  
  //http://localhost:8081/projections/1?projection=p1
  
  
  
  
  
}

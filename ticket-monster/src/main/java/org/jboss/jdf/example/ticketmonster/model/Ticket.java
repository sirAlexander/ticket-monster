package org.jboss.jdf.example.ticketmonster.model;

import java.io.Serializable;
import java.lang.Long;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.jboss.jdf.example.ticketmonster.model.Seat;
import org.jboss.jdf.example.ticketmonster.model.TicketCategory;

/**
 * <p>
 * A ticket represents a seat sold for a particular price.
 * </p>
 * 
 * @author Shane Bryzak
 * @author Marius Bogoevici
 * @author Pete Muir
 */
@Entity
public class Ticket implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	   
	/**
     * The synthetic id of the object.
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
     * <p>
     * The seat for which this ticket has been sold.
     * </p>
     * 
     * <p>
     * The seat must be specifed, and the Bean Validation constraint <code>@NotNull</code> ensures this.
     * </p>
     */
    @NotNull
	private Seat seat;
    
    /**
     * <p>
     * The ticket price category for which this ticket has been sold.
     * </p>
     * 
     * <p>
     * The ticket price category must be specifed, and the Bean Validation constraint <code>@NotNull</code> ensures this.
     * </p>
     */
    @ManyToOne
    @NotNull
	private TicketCategory ticketCategory;
    
    /**
     * The price which was charged for the ticket.
     */
	private float price;
	
	

	public Ticket() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public Seat getSeat() {
		return this.seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}   
	public TicketCategory getTicketCategory() {
		return this.ticketCategory;
	}

	public void setTicketCategory(TicketCategory ticketCategory) {
		this.ticketCategory = ticketCategory;
	}   
	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ticket [seat=").append(seat)
				.append(", ticketCategory=").append(ticketCategory)
				.append(", price=").append(price).append("]");
		return builder.toString();
	}
	
	
	
   
}

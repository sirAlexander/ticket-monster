package org.jboss.jdf.example.ticketmonster.model;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.jboss.jdf.example.ticketmonster.model.Venue;

/**
 * <p>
 * A section is a specific area within a venue layout. A venue layout may consist of multiple sections.
 * </p>
 * 
 * <p>
 * The name and venue form the natural id of this entity, and therefore must be unique. JPA requires us to use the class level
 * <code>@Table</code> constraint.
 * </p>
 * 
 */
@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"name", "venue_id"}))
public class Section implements Serializable {
	
	private static final long serialVersionUID = 1L;

	 /* Declaration of fields */

    /**
     * The synthetic id of the object.
     */
	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
     * <p>
     * The short name of the section, may be a code such as A12, G7, etc.
     * </p>
     * 
     * <p>
     * The
     * <code>@NotEmpty<code> Bean Validation constraint means that the section name must be at least 1 character.
     * </p>
     */
    @NotEmpty
	private String name;
    
    /**
     * <p>
     * The description of the section, such as 'Rear Balcony', etc.
     * </p>
     * 
     * <p>
     * The
     * <code>@NotEmpty<code> Bean Validation constraint means that the section description must be at least 1 character.
     * </p>
     */
    @NotEmpty
	private String description;
    
    /**
     * <p>
     * The venue to which this section belongs. The <code>@ManyToOne<code> JPA mapping establishes this relationship.
     * </p>
     * 
     * <p>
     * The <code>@NotNull</code> Bean Validation constraint means that the venue must be specified.
     * </p>
     */
    @ManyToOne
    @NotNull
	private Venue venue;
    
    /**
     * The number of rows that make up the section.
     */
	private int numberOfRows;
	
	/**
     * The number of seats in a row.
     */
	private int rowCapacity;
	

	public Section() {
		super();
	}   
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	
	public Venue getVenue() {
		return this.venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}   
	
	public int getNumberOfRows() {
		return this.numberOfRows;
	}

	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}   
	
	public int getRowCapacity() {
		return this.rowCapacity;
	}

	public void setRowCapacity(int rowCapacity) {
		this.rowCapacity = rowCapacity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((venue == null) ? 0 : venue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Section other = (Section) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (venue == null) {
			if (other.venue != null)
				return false;
		} else if (!venue.equals(other.venue))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Section [name=" + name + ", venue=" + venue + "]";
	}
	
	
	
	
	
   
}

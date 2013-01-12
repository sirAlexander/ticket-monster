package org.jboss.jdf.example.ticketmonster.model;

import javax.persistence.Entity;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.lang.Override;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@XmlRootElement
public class Venue implements Serializable
{

   /**
	 * 
	 */
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
     * The name of the event.
     * </p>
     * 
     * <p>
     * The name of the event forms it's natural identity and cannot be shared between events.
     * </p>
     * 
     * <p>
     * The name must not be null and must be one or more characters, the Bean Validation constrain <code>@NotEmpty</code>
     * enforces this.
     * </p>
     */
    @Column(unique = true)
    @NotEmpty
    private String name;
    
    /**
     * The address of the venue
     */
    private Address address = new Address();

    /**
     * A description of the venue
     */
    private String description;
    
    /**
     * <p>
     * A set of sections in the venue
     * </p>
     * 
     * <p>
     * The <code>@OneToMany<code> JPA mapping establishes this relationship. TODO Explain EAGER fetch. 
     * This relationship is bi-directional (a section knows which venue it is part of), and the <code>mappedBy</code>
     * attribute establishes this. We cascade all persistence operations to the set of performances, so, for example if a venue
     * is removed, then all of it's sections will also be removed.
     * </p>
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "venue")
    private Set<Section> sections = new HashSet<Section>();

    /**
     * The capacity of the venue
     */
    private int capacity;
    
    /**
     * An optional media item to entice punters to the venue. The <code>@ManyToOne</code> establishes the relationship.
     */
    @ManyToOne
    private MediaItem mediaItem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Section> getSections() {
		return sections;
	}

	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public MediaItem getMediaItem() {
		return mediaItem;
	}

	public void setMediaItem(MediaItem mediaItem) {
		this.mediaItem = mediaItem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Venue other = (Venue) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Venue [name=" + name + ", address=" + address + "]";
	}
	
	   
    

   
}
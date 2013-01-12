package org.jboss.jdf.example.ticketmonster.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



/**
 * <p>
 * Represents an event, which may have multiple performances with different dates and venues.
 * </p>
 * 
 * <p>
 * Event's principle members are it's relationship to {@link EventCategory} - specifying the type of event it is - and
 * {@link MediaItem} - providing the ability to add media (such as a picture) to the event for display. It also contains
 * meta-data about the event, such as it's name and a description.
 * </p>
 * 
 * 
 */

@Entity
public class Event implements Serializable {

    /* Declaration of fields */

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * The synthetic ID of the object.
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
     * Two constraints are applied using Bean Validation
     * </p>
     * 
     * <ol>
     * <li><code>@NotNull</code> &mdash; the name must not be null.</li>
     * <li><code>@Size</code> &mdash; the name must be at least 5 characters and no more than 50 characters. This allows for
     * better formatting consistency in the view layer.</li>
     * </ol>
     */
    @Column(unique = true)
    @NotNull
    @Size(min = 5, max = 50, message = "An event's name must contain between 5 and 50 characters")
    private String name;

    /**
     * <p>
     * A description of the event.
     * </p>
     * 
     * <p>
     * Two constraints are applied using Bean Validation
     * </p>
     * 
     * <ol>
     * <li><code>@NotNull</code> &mdash; the description must not be null.</li>
     * <li><code>@Size</code> &mdash; the name must be at least 20 characters and no more than 1000 characters. This allows for
     * better formatting consistency in the view layer, and also ensures that event organisers provide at least some description
     * - a classic example of a business constraint.</li>
     * </ol>
     */
    @NotNull
    @Size(min = 20, max = 1000, message = "An event's name must contain between 20 and 1000 characters")
    private String description;

    /**
     * <p>
     * A media item, such as an image, which can be used to entice a browser to book a ticket.
     * </p>
     * 
     * <p>
     * Media items can be shared between events, so this is modeled as a <code>@ManyToOne</code> relationship.
     * </p>
     * 
     * <p>
     * Adding a media item is optional, and the view layer will adapt if none is provided.
     * </p>
     * 
     */
    @ManyToOne
    private MediaItem mediaItem;

    /**
     * <p>
     * The category of the event
     * </p>
     * 
     * <p>
     * Event categories are used to ease searching of available of events, and hence this is modeled as a relationship
     * </p>
     * 
     * <p>
     * The Bean Validation constraint <code>@NotNull</code> indicates that the event category must be specified.
     */
    @ManyToOne
    @NotNull
    private EventCategory category;

    /* Boilerplate getters and setters */

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

    public MediaItem getMediaItem() {
        return mediaItem;
    }

    public void setMediaItem(MediaItem picture) {
        this.mediaItem = picture;
    }

    public EventCategory getCategory() {
        return category;
    }

    public void setCategory(EventCategory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Event other = (Event) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Event [name=").append(name).append(", description=")
				.append(description).append("]");
		return builder.toString();
	}
	
	    
    


}
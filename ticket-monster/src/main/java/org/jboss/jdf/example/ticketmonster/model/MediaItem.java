package org.jboss.jdf.example.ticketmonster.model;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

import org.hibernate.validator.constraints.URL;
import org.jboss.jdf.example.ticketmonster.model.MediaType;

/**
 * Entity implementation class for Entity: MediaItem
 *
 */
@Entity

public class MediaItem implements Serializable {
	
	private static final long serialVersionUID = 1L;

	   
	/**
     * The synthetic id of the object.
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	 /**
     * <p>
     * The type of the media, required to render the media item corectly.
     * </p>
     * 
     * <p>
     * The media type is a <em>closed set</em> - as each different type of media requires support coded into the view layers, it
     * cannot be expanded upon without rebuilding the application. It is therefore represented by an enumeration. We instruct
     * JPA to store the enum value using it's String representation, so that we can later reorder the enum members, without
     * changing the data. Of course, this does mean we can't change the names of media items once the app is put into
     * production.
     * </p>
     */
    @Enumerated(EnumType.STRING)
	private MediaType mediaType;
	
    
    /**
     * <p>
     * The URL from which the media item can be sourced
     * </p>
     * 
     * <p>
     * The url of the media item forms it's natural id and cannot be shared between event categories
     * </p>
     * 
     * <p>
     * The <code>@URL<code> Bean Validation ensures the the URL is, indeed, a valid URL.
     * </p>
     */
    @Column(unique = true)
    @URL
	private String url;
	

	public MediaItem() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public MediaType getMediaType() {
		return this.mediaType;
	}

	public void setMediaType(MediaType mediaType) {
		this.mediaType = mediaType;
	}   
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		MediaItem other = (MediaItem) obj;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "MediaItem [mediaType=" + mediaType.getDescription() + ", url=" + url + "]";
	}
	
	
   
}

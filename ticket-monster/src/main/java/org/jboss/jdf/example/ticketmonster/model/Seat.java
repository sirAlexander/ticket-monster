package org.jboss.jdf.example.ticketmonster.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

@Embeddable
public class Seat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Min(1)
    private int rowNumber;

    @Min(1)
    private int number;

    /**
     * The <code>@ManyToOne<code> JPA mapping establishes this relationship.
     */
    @ManyToOne
    private Section section;
    

	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		result = prime * result + rowNumber;
		result = prime * result + ((section == null) ? 0 : section.hashCode());
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
		Seat other = (Seat) obj;
		if (number != other.number)
			return false;
		if (rowNumber != other.rowNumber)
			return false;
		if (section == null) {
			if (other.section != null)
				return false;
		} else if (!section.equals(other.section))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Seat [rowNumber=").append(rowNumber)
				.append(", number=").append(number).append(", section=")
				.append(section).append("]");
		return builder.toString();
	}
	
	
    
    

}

package com.ankit.demo.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity(name = "Contact")
@Table(name ="contact")
@Data
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "The database generated contact ID")
	private Long id;

	@NotNull(message = "Name cannot be null")
	@ApiModelProperty(notes = "full Name", required = true)
	private String fullName;

	@NotNull(message = "DateOfBirth cannot be null")
	@ApiModelProperty(notes = "DateOfBirth", required = true)
	private LocalDate dateOfBirth;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id")
	private Address address;

}

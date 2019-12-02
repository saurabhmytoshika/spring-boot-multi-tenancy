package com.mytoshika.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@FilterDef(name = "orgnizationFilter", parameters = { @ParamDef(name = "orgnizationId", type = "string") })
@Filter(name = "orgnizationFilter", condition = "orgnization_id = :orgnizationId")
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements TenantSupport {
	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@CreatedBy
	@Column(name = "orgnization_id")
	private String orgnizationId;

	
}

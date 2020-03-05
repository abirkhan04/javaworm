package com.gov.configuration.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import lombok.Data;

@Data
@Entity
@Table(name = "committee")
public class Committee implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private UUID oid;

	@Column(name = "name_en")
	private String nameEn;

	@Column(name = "name_bn")
	private String nameBn;

	@Column(name = "member_quantity")
	private String memberQuantity;

	private String quorum;

	@Column(name = "formation_date")
	private String formationDate;

	private String purpose;

	@Column(name = "authorized_by")
	private String authorizedBy;

	@Column(name = "approved_by")
	private String approvedBy;

	@Column(name = "office_oid")
	private String officeOid;

	private boolean status;

	@CreatedBy
	@Column(name = "created_by")
	private String createdBy;

	@CreatedDate
	@Column(name = "created_on")
	private LocalDate createdOn;

	@LastModifiedBy
	@Column(name = "updated_by")
	private String updatedBy;

	@LastModifiedDate
	@Column(name = "updated_on")
	private LocalDate updatedOn;

}

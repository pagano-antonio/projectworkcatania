package com.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * The persistent class for the job_offer database table.
 * 
 */
@Entity
@Table(name = "job_offer")
@NamedQuery(name = "JobOffer.findAll", query = "SELECT j FROM JobOffer j")
public class JobOffer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idJobOffer;

	private String description;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date endDate;

	private int maxRal;

	private int minRal;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date startDate;

	private String title;

	// bi-directional many-to-one association to CompanyClient
	@ManyToOne
	@JoinColumn(name = "idCompanyClient")
	private CompanyClient companyClient;

	// bi-directional many-to-one association to ContractType
	@ManyToOne
	@JoinColumn(name = "idContractType")
	private ContractType contractType;

	// bi-directional many-to-one association to JobOfferSkill
	@OneToMany(mappedBy = "jobOffer")
	private List<JobOfferSkill> jobOfferSkills;

	public JobOffer() {
	}

	public int getIdJobOffer() {
		return this.idJobOffer;
	}

	public void setIdJobOffer(int idJobOffer) {
		this.idJobOffer = idJobOffer;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getMaxRal() {
		return this.maxRal;
	}

	public void setMaxRal(int maxRal) {
		this.maxRal = maxRal;
	}

	public int getMinRal() {
		return this.minRal;
	}

	public void setMinRal(int minRal) {
		this.minRal = minRal;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public CompanyClient getCompanyClient() {
		return this.companyClient;
	}

	public void setCompanyClient(CompanyClient companyClient) {
		this.companyClient = companyClient;
	}

	public ContractType getContractType() {
		return this.contractType;
	}

	public void setContractType(ContractType contractType) {
		this.contractType = contractType;
	}

	public List<JobOfferSkill> getJobOfferSkills() {
		return this.jobOfferSkills;
	}

	public void setJobOfferSkills(List<JobOfferSkill> jobOfferSkills) {
		this.jobOfferSkills = jobOfferSkills;
	}

	public JobOfferSkill addJobOfferSkill(JobOfferSkill jobOfferSkill) {
		getJobOfferSkills().add(jobOfferSkill);
		jobOfferSkill.setJobOffer(this);

		return jobOfferSkill;
	}

	public JobOfferSkill removeJobOfferSkill(JobOfferSkill jobOfferSkill) {
		getJobOfferSkills().remove(jobOfferSkill);
		jobOfferSkill.setJobOffer(null);

		return jobOfferSkill;
	}

}
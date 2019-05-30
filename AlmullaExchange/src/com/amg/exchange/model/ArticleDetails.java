package com.amg.exchange.model;

// Generated Jun 12, 2014 8:57:01 AM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * ArticleDetails generated by Chennai ODC
 */
@Entity
@Table(name = "FS_ARTICLE_DETAILS")
public class ArticleDetails implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal articleDetailId;
	private ArticleMaster fsArticleMaster;
	private String articleDesc;
	private BigDecimal weekly;
	private BigDecimal monthly;
	private BigDecimal yearly;
	
	private List<Customer> fsCustomers = new ArrayList<Customer>();

	public ArticleDetails() {
	}

	public ArticleDetails(BigDecimal articleDetailId) {
		this.articleDetailId = articleDetailId;
	}

	public ArticleDetails(BigDecimal articleDetailId,
			ArticleMaster articleMaster, String articleDesc,
			BigDecimal weekly, BigDecimal monthly, BigDecimal yearly,
			List<Customer> fsCustomers) {
		this.articleDetailId = articleDetailId;
		this.fsArticleMaster = articleMaster;
		this.articleDesc = articleDesc;
		this.weekly = weekly;
		this.monthly = monthly;
		this.yearly = yearly;
		this.fsCustomers = fsCustomers;
	}

	@Id
	@TableGenerator(name = "articledetailid", table = "fs_articledetailidpk", pkColumnName = "articledetailidkey", pkColumnValue = "articledetailidvalue", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "articledetailid")
	@Column(name = "ARTICLE_DETAIL_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getArticleDetailId() {
		return this.articleDetailId;
	}

	public void setArticleDetailId(BigDecimal articleDetailId) {
		this.articleDetailId = articleDetailId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ARTICLE_ID")
	public ArticleMaster getFsArticleMaster() {
		return this.fsArticleMaster;
	}

	public void setFsArticleMaster(ArticleMaster fsArticleMaster) {
		this.fsArticleMaster = fsArticleMaster;
	}

	@Column(name = "ARTICLE_DESC", length = 50)
	public String getArticleDesc() {
		return this.articleDesc;
	}

	public void setArticleDesc(String articleDesc) {
		this.articleDesc = articleDesc;
	}

	@Column(name = "WEEKLY", precision = 22, scale = 0)
	public BigDecimal getWeekly() {
		return this.weekly;
	}

	public void setWeekly(BigDecimal weekly) {
		this.weekly = weekly;
	}

	@Column(name = "MONTHLY", precision = 22, scale = 0)
	public BigDecimal getMonthly() {
		return this.monthly;
	}

	public void setMonthly(BigDecimal monthly) {
		this.monthly = monthly;
	}

	@Column(name = "YEARLY", precision = 22, scale = 0)
	public BigDecimal getYearly() {
		return this.yearly;
	}

	public void setYearly(BigDecimal yearly) {
		this.yearly = yearly;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fsArticleDetails")
	public List<Customer> getFsCustomers() {
		return fsCustomers;
	}

	public void setFsCustomers(List<Customer> fsCustomers) {
		this.fsCustomers = fsCustomers;
	}

	
}

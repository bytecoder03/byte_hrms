package com.byteCoder.hrms.Dto;


	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
	import javax.persistence.Transient;

	import org.hibernate.annotations.NotFound;
	import org.hibernate.annotations.NotFoundAction;

	import com.fasterxml.jackson.annotation.JsonIgnore;

	@Entity
	public class Account {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int acId;
		
		private int acno;
		
		

		public int getAcId() {
			return acId;
		}

		public void setAcId(int acId) {
			this.acId = acId;
		}

		public int getAcno() {
			return acno;
		}

		public void setAcno(int acno) {
			this.acno = acno;
		}
		
		
	}




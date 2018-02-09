/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.ana.library.business.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anama
 */
@Entity
@Table(name = "book_loan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookLoan.findAll", query = "SELECT b FROM BookLoan b")
    , @NamedQuery(name = "BookLoan.findById", query = "SELECT b FROM BookLoan b WHERE b.id = :id")
    , @NamedQuery(name = "BookLoan.findByLoanedAt", query = "SELECT b FROM BookLoan b WHERE b.loanedAt = :loanedAt")
    , @NamedQuery(name = "BookLoan.findByReturnedAt", query = "SELECT b FROM BookLoan b WHERE b.returnedAt = :returnedAt")})
public class BookLoan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "loaned_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date loanedAt;
    @Column(name = "returned_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnedAt;
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Member1 memberId;
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Book book;

    public BookLoan() {
    }

    public BookLoan(Integer id) {
        this.id = id;
    }

    public BookLoan(Integer id, Date loanedAt, Date returnedAt) {
        this.id = id;
        this.loanedAt = loanedAt;
        this.returnedAt = returnedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getLoanedAt() {
        return loanedAt;
    }

    public void setLoanedAt(Date loanedAt) {
        this.loanedAt = loanedAt;
    }

    public Date getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(Date returnedAt) {
        this.returnedAt = returnedAt;
    }

    public Member1 getMemberId() {
        return memberId;
    }

    public void setMemberId(Member1 memberId) {
        this.memberId = memberId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookLoan)) {
            return false;
        }
        BookLoan other = (BookLoan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hr.ana.library.business.entity.BookLoan[ id=" + id + " ]";
    }
    
}

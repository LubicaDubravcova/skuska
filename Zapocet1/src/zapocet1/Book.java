/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zapocet1;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Dell
 */
@NamedQueries({
    @NamedQuery(name="Book.FindByTitle",query="Select b from Book b where b.title=:title"),
    //@NamedQuery(name="Book.FindByName",query="Select p from  b where b.authors=:name")
   // @NamedQuery(name="Book.FindByTagAndAuthours",query="Select b from Book b where b.tags=:tag and b.authors=:name")
})
@Entity
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @ElementCollection
    private List<String> tags;
    @ManyToMany
    /*@JoinTable( name = "BOOK_PERSON",
                joinColumns = @JoinColumn(name = "book_fk"),
                inverseJoinColumns = @JoinColumn(name = "authors_fk"))*/
    private List<Person> authors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Person> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Person> authors) {
        this.authors = authors;
    }

    public Book(String title, List<String> tags, List<Person> authors) {
        this.title = title;
        this.tags = tags;
        this.authors = authors;
    }

    

    public Book() {
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
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "zapocet1.Book[ id=" + id + " ]";
    }
    
}

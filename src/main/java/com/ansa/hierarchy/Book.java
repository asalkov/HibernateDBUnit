package com.ansa.hierarchy;

import javax.persistence.*;

/**
 * Created by asalkov on 21.08.2015.
 */

@Entity
@org.hibernate.annotations.Entity
        (dynamicInsert = true, dynamicUpdate = true,
                optimisticLock=org.hibernate.annotations.OptimisticLockType.ALL)
public class Book {

    @Id
    @GeneratedValue (strategy= GenerationType.TABLE)
    private long isbn;

    @Version
    private Integer version;

    private String bookName;

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}

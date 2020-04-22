package Chan.BookShelvesMaven.DAO;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="account", uniqueConstraints={
    @UniqueConstraint(columnNames="account_seq"),
    @UniqueConstraint(columnNames="email")
})
@DynamicInsert
@DynamicUpdate
@Data
@EqualsAndHashCode
@ToString(includeFieldNames=true)
@RequiredArgsConstructor(staticName="of")
@NoArgsConstructor
public class Account implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="account_seq", nullable=false, unique=true)
    private Integer accountId;

    @Column(name="email", nullable=false, unique=true)
    @NonNull
    private String email;

    @NonNull
    private String password;

    @OneToOne(cascade=CascadeType.ALL, mappedBy="account")
    private AccountProfile profile;

//    @OneToOne(cascade=CascadeType.ALL, mappedBy="account")
//    private AccountSecurity security;
}
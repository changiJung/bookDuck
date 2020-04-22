package Chan.BookShelvesMaven.DAO;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name="account_profile", uniqueConstraints={
    @UniqueConstraint(columnNames={"account_seq"}),
    @UniqueConstraint(columnNames={"nickname"})
})
@DynamicInsert
@DynamicUpdate
@Data
@EqualsAndHashCode
@ToString(includeFieldNames=true)
@RequiredArgsConstructor(staticName="of")
@NoArgsConstructor
public class AccountProfile implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="account_seq", referencedColumnName="account_seq")
    private Account account;

    @Column(name="nickname", nullable=false)
    @NonNull
    private String nickname;

}
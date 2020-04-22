package Chan.BookShelvesMaven.DAO;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="community", uniqueConstraints = {
        @UniqueConstraint(columnNames="article_seq")
})
@DynamicInsert
@DynamicUpdate
@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString(includeFieldNames=true)
public class Community {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="article_seq", nullable=false, unique=true)
    private Long articleId;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="account_seq", referencedColumnName="account_seq")
    private Account account;

    @Column(name="title", nullable=false)
    private String title;

    @Column(name="content", nullable=false)
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="reg_dt")
    private Date date;

    @Column(name="read_cnt", nullable=false)
    private int readCount;

    @Column(name="attach_url")
    private String attachUrl;

    @Column(name="attach_filename")
    private String attachFileName;

//    @OneToMany(cascade=CascadeType.ALL, mappedBy="article")
//    private Set<CommunityReply> replies;
}
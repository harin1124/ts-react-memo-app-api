package react.memo.api.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="T_MEMO")
public class Memo {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int memoSeq;
    @Column
    private String ownerId;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private Date regDate;
	@Column
	private Date editDate;
	@Column
	private int isDel;
}
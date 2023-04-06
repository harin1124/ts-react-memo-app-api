package react.memo.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Memo {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int memoSeq;
    private int ownerSeq;
	private String title;
	private String description;
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm", timezone="Asia/Seoul")
	private Date regDate;
	private Date editDate;
	private int isDel;
}
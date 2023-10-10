package hu.czmarkob.joblistingsservice.job;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@ToString
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Job {

	@Id
	@GeneratedValue
	private Long id;

	@Lob
	@Column(nullable = false, length = 512)
	private String logoSrc;

	@Column(nullable = false)
	private String company;

	@Column(nullable = false)
	private String position;

	@CreatedDate
	@Column(nullable = false)
	private LocalDateTime created;

	@Column(nullable = false)
	private String location;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private JobType jobType;

	@Column(nullable = false)
	private boolean featured;

	@ElementCollection
	private List<String> tools = new ArrayList<>();
}

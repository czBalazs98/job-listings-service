package hu.czmarkob.joblistingsservice.job;

import java.util.List;

import lombok.Data;

@Data
public class JobDto {

	private Long id;

	private String logoSrc;

	private String company;

	private String position;

	private String created;

	private String location;

	private String jobType;

	private boolean featured;

	private List<String> tools;
}

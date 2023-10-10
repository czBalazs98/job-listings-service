package hu.czmarkob.joblistingsservice.job;

import org.mapstruct.Mapper;

@Mapper
public interface JobDtoMapper {

	JobDto toDto(Job job);

	Job fromDto(JobDto jobDto);
}

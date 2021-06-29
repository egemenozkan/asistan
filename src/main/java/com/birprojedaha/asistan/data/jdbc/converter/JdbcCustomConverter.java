package com.birprojedaha.asistan.data.jdbc.converter;

import com.birprojedaha.asistan.data.common.NoteType;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

import java.util.Arrays;

@Configuration
public class JdbcCustomConverter extends AbstractJdbcConfiguration {

	@Override
	public JdbcCustomConversions jdbcCustomConversions() {

		return new JdbcCustomConversions(Arrays.asList(new NoteTypeReadConverter(), new NoteTypeWriteConverter()));
	}

	@ReadingConverter
	static class NoteTypeReadConverter implements Converter<Integer, NoteType> {
		@Override
		public NoteType convert(Integer value) {
			return NoteType.getTypeById(value);
		}
	}

	@WritingConverter
	static class NoteTypeWriteConverter implements Converter<NoteType, Integer> {

		@Override
		public Integer convert(NoteType source) {
			return source.getId();
		}
	}
}
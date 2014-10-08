package com.consultafacil.converter;

import static com.google.common.base.Strings.isNullOrEmpty;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;
import javax.interceptor.Interceptor;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.ConversionException;
import br.com.caelum.vraptor.converter.ConversionMessage;
import br.com.caelum.vraptor.converter.Converter;

@Convert(Long.class)
@Alternative
@Priority(Interceptor.Priority.APPLICATION)
public class NullSafeLongConverter implements Converter<Long> {

	//@Override
	public Long convert(String value, Class<? extends Long> type) {

		if (isNullOrEmpty(value)) return Long.valueOf(0);

		try {
			return Long.valueOf(value);
		} catch (NumberFormatException e) {
			throw new ConversionException(
				new ConversionMessage("is_not_a_valid_integer", value));
		}
	}
}

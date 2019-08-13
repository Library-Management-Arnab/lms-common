package com.lms.svc.common.config;

import com.lms.svc.common.exception.InvalidFieldValueException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

@Component
public abstract class BaseDataLoader {
	protected final <T> T returnOrThrow(Collection<T> items, Predicate<T> condition, String input, Collection<String> validValues,
			String fieldName) {
		Optional<T> found = items.stream().filter(condition).findAny();

		if (found.isPresent()) {
			return found.get();
		}
		throw new InvalidFieldValueException(fieldName, input, validValues);
	}

	protected final <T> String getClientString(Collection<T> items, T input, Function<T, String> toExecute) {
		Predicate<T> predicate = item -> item.equals(input);
		Optional<T> found = items.stream().filter(predicate).findAny();

		if (found.isPresent()) {
			return toExecute.apply(found.get());
		}
		throw new IllegalArgumentException();
	}
}

package com.mia.itmf.projet.gestionrefugeanimal.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class MapTool {

	public static <K, V> List<V> getMapElements(Map<K, V> map, List<SearchCriteria<V>> searchCriteriaList) {
		return getMapElements(map, null, false, searchCriteriaList);
	}
	
	

	public static <K, V> List<V> getMapElements(Map<K, V> map, boolean exactMatch,
			List<SearchCriteria<V>> searchCriteriaList) {
		return getMapElements(map, null, exactMatch, searchCriteriaList);
	}

	public static <K, V, T> List<V> getMapElements(Map<K, V> map, Class<T> type, boolean exactMatch,
			List<SearchCriteria<V>> searchCriteriaList) {

		List<V> result = new ArrayList<>();

		for (Map.Entry<K, V> entry : map.entrySet()) {
			V value = entry.getValue();
			if (type == null || type.isInstance(value)) {
				boolean match = true;
				for (SearchCriteria<V> criteria : searchCriteriaList) {
					if (exactMatch) {
						match &= checkExactMatch(value, criteria.getPropertyFunc(), criteria.getValue());
					} else {
						match &= checkPartialMatch(value, criteria.getPropertyFunc(), criteria.getValue());
					}
				}
				if (match) {
					result.add(value);
				}
			}
		}
		return result;
	}

	public static <K, V, T> V getMapElement(Map<K, V> map, List<SearchCriteria<V>> searchCriteriaList) {
		return getMapElement(map, null, false, searchCriteriaList);
	}

	public static <K, V, T> V getMapElement(Map<K, V> map, boolean exactMatch,
			List<SearchCriteria<V>> searchCriteriaList) {
		return getMapElement(map, null, exactMatch, searchCriteriaList);
	}

	public static <K, V, T> V getMapElement(Map<K, V> map, Class<T> type, boolean exactMatch,
			List<SearchCriteria<V>> searchCriteriaList) {

		List<V> result = getMapElements(map, type, exactMatch, searchCriteriaList);
		if (!result.isEmpty()) {
			return result.get(0);
		}
		return null;
	}

	private static <V> boolean checkExactMatch(V value, Function<V, ?> propertyFunc, Object searchValue) {
		Object valueProperty = propertyFunc.apply(value);
		return valueProperty.equals(searchValue);
	}

	private static <V> boolean checkPartialMatch(V value, Function<V, ?> propertyFunc, Object searchValue) {
		Object valueProperty = propertyFunc.apply(value);
		if (valueProperty instanceof String) {
			String strValue = (String) valueProperty;
			String strSearch = (String) searchValue;
			return strValue.contains(strSearch);
		} else {
			return valueProperty.equals(searchValue);
		}
	}

	public static class SearchCriteria<V> {
		private Function<V, ?> propertyFunc;
		private Object value;

		public SearchCriteria(Function<V, ?> propertyFunc, Object value) {
			this.propertyFunc = propertyFunc;
			this.value = value;
		}

		public Function<V, ?> getPropertyFunc() {
			return propertyFunc;
		}

		public Object getValue() {
			return value;
		}
	}
}
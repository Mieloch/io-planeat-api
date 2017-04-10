package org.planeat.web.converter;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MappingUtils {


  public static <R, S> List<R> list(List<S> list, Function<S, R> mapping) {
    if (list == null) {
      return null;
    }
    return list.stream().map(mapping).collect(Collectors.toList());
  }
}

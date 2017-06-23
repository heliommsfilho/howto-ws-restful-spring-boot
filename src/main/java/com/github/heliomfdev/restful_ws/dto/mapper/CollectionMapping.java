package com.github.heliomfdev.restful_ws.dto.mapper;

import java.util.List;

public interface CollectionMapping<S extends List<S>, D extends List<D>>  {

    List<D> mapCollection(List<S> sourceList);
}

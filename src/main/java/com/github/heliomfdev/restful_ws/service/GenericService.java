package com.github.heliomfdev.restful_ws.service;

import com.github.heliomfdev.restful_ws.dto.mapper.ListMapper;


abstract class GenericService<S,D> {

   ListMapper<S,D> listMapper = new ListMapper<>();
}

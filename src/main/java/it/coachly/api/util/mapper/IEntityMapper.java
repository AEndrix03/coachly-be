package it.coachly.api.util.mapper;

import java.util.List;

public interface IEntityMapper<D, E> {

    E toEntity(D dto);

    default List<E> toEntity(List<D> dtos) {
        return dtos.stream().map(this::toEntity).toList();
    }
}

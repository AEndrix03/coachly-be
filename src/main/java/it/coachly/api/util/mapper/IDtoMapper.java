package it.coachly.api.util.mapper;

import java.util.List;

public interface IDtoMapper<D, E> {

    D toDto(E entity);

    default List<D> toDto(List<E> entities) {
        return entities.stream().map(this::toDto).toList();
    }
}

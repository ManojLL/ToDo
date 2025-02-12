package com.manojll.todo.mapper;

/**
 * The interface Mapper.
 *
 * @param <E> the type parameter
 * @param <D> the type parameter
 */
public interface Mapper <E,D>{

    /**
     * To entity e.
     *
     * @param dto the dto
     * @return the e
     */
    E toEntity(D dto);

    /**
     * To dto d.
     *
     * @param entity the entity
     * @return the d
     */
    D toDto(E entity);
}

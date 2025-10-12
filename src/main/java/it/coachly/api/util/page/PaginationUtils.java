package it.coachly.api.util.page;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.ComparableExpressionBase;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class PaginationUtils {

    public static Pageable of(Integer page, Integer size, String sort, String direction) {
        Pageable pageable;

        if (sort != null && !sort.isEmpty()) {
            Sort.Direction sortDirection = "desc".equalsIgnoreCase(direction)
                    ? Sort.Direction.DESC
                    : Sort.Direction.ASC;
            pageable = PageRequest.of(page, size, Sort.by(sortDirection, sort));
        } else {
            pageable = PageRequest.of(page, size);
        }

        return pageable;
    }

    public static <T> Page<T> findPaginated(JPAQuery<T> query, Pageable pageable) {
        long total = query.fetchCount();
        query.offset(pageable.getOffset());
        query.limit(pageable.getPageSize());
        Sort sort = pageable.getSort();
        if (sort != null && sort.isSorted()) {
            Object source = query.getMetadata().getJoins().get(0).getTarget();
            List<OrderSpecifier<?>> orderSpecifiers = new ArrayList<>();
            for (Sort.Order order : sort) {
                try {
                    Field field = source.getClass().getDeclaredField(order.getProperty());
                    field.setAccessible(true);
                    Object expr = field.get(source);
                    if (expr instanceof ComparableExpressionBase) {
                        Order qdslOrder = order.isAscending() ? Order.ASC : Order.DESC;
                        orderSpecifiers.add(new OrderSpecifier(qdslOrder, (ComparableExpressionBase<?>) expr));
                    }
                } catch (NoSuchFieldException | IllegalAccessException ignored) {
                }
            }
            if (!orderSpecifiers.isEmpty()) {
                query.orderBy(orderSpecifiers.toArray(new OrderSpecifier[0]));
            }
        }
        return new org.springframework.data.domain.PageImpl<>(query.fetch(), pageable, total);
    }
}

package io.github.yuokada;

import io.github.yuokada.model.TodoCreateRequest;
import io.github.yuokada.model.TodoDetail;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.jboss.logging.Logger;

public class TodoApplicationImpl implements
    TodoApplicationInterface {

    private static final Logger logger = Logger.getLogger(TodoApplicationImpl.class);

    private static final Map<Long, TodoDetail> todoList = new HashMap<>();

    private static final AtomicReference<Long> taskId = new AtomicReference<>(0L);

    @Override
    public Response getListOfTodo() {
        List<TodoDetail> todos = todoList.values().stream().filter(t -> !t.done()).toList();
        return Response.ok(todos).build();
    }

    @Override
    public Response getTaskDetail(Long id) {
        TodoDetail todoDetail = todoList.get(id);
        if (todoDetail == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.ok(todoDetail).build();
    }

    @Override
    public Response createTodo(TodoCreateRequest request) {
        logger.info(request.title() + " || default description");
        Long l = taskId.updateAndGet(id -> id + 1);
        TodoDetail todoDetail = new TodoDetail(
            l,
            request.title(),
            // request.description(),
            "default description",
            false
        );
        todoList.put(l, todoDetail);
        return Response.status(Status.CREATED)
            .entity(todoDetail)
            .build();
    }

    @Override
    public Response updateTodoDetail(Long id, TodoDetail todoDetail) {
        if (todoList.containsKey(id)) {
            TodoDetail detail = todoList.get(id);
            todoList.put(id, todoDetail);
            return Response.ok(todoDetail).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @Override
    public Response completeTodo(Long id) {
        if (todoList.containsKey(id)) {
            TodoDetail detail = todoList.get(id);
            TodoDetail todoDetail = new TodoDetail(
                detail.id(),
                detail.title(),
                detail.description(),
                true
            );
            todoList.put(id, todoDetail);
            return Response.ok(todoDetail).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }

    @Override
    public Response deleteTodo(Long id) {
        if (todoList.containsKey(id)) {
            todoList.remove(id);
            return Response.noContent().build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }
}

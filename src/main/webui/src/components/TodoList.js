import React from 'react';

function TodoList({todos}) {
  const todoList = todos.map((todo) => {
    return (
        <li key={todo.id}>
          {todo.title} | {todo.description}
        </li>
    )
  });
  return (
      <ul>
        {todoList}
      </ul>
  )
}

export default TodoList;
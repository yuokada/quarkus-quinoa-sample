import React, {useEffect, useState} from 'react';

function TodoApp() {
  const [todos, setTodos] = useState([]);
  const [newTodo, setNewTodo] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    // データを取得する非同期関数を定義
    const fetchData = async () => {
      try {
        const response = await fetch('/api/v1/todos/');
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        const data = await response.json();
        setTodos(data);
        setLoading(false);
      } catch (error) {
        setError(error);
        setLoading(false);
      }
    };
    fetchData();
  }, []); // 空の依存配列は、このエフェクトがマウント時に一度だけ実行されることを示す

  if (loading) {
    return <div>Loading...</div>;
  }

  if (error) {
    return <div>Error: {error.message}</div>;
  }

  const renderTodoList = (todos) => {
    if (todos.length === 0) {
      return <div>No todos available</div>;
    } else {
      return (
          <ul>
            {todos.map(todo => (
                <li key={todo.id}>
                  {todo.title} | {todo.description}
                  <button>Delete</button>
                  <button>Mark as Completed</button>
                </li>
            ))}
          </ul>
      );
    }
  };

  // 新しいTodoを追加する関数
  const handleAddTodo = (event) => {
    event.preventDefault(); // フォームのデフォルトの送信動作を防ぐ

    // if (newTodo.trim() === '') return; // 入力が空白の場合は何もしない

    const newTodoItem = {
      id: todos.length + 1,
      title: newTodo,
      completed: false
    };

    setTodos([...todos, newTodoItem]); // 新しいTodoをリストに追加
    setNewTodo(''); // 入力フィールドをクリア
  };

  return (
      <div>
        <h1>Todo List</h1>
        {renderTodoList(todos)}
        <div>
          <h2>Add Todo</h2>
          <form onSubmit={handleAddTodo}>
            <input
                type={"text"}
                name={"title"}
                placeholder={"Enter todo title"}
            />
            <span className={"form"}>
            <button type={"submit"}>Add todo</button>
            </span>
          </form>
        </div>
      </div>
  );
}

export default TodoApp;

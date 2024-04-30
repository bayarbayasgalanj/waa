import { BrowserRouter, Routes, Route } from 'react-router-dom';
import {TasksTodoList}from './TasksTodoList';
import {TasksDoneList}from './TasksDoneList';
import React, { useState } from 'react';

function App() {
  const initialList = [
    { number: "1", name: "Todo One" },
    { number: "2", name: "Todo Two" },
    { number: "3", name: "Todo Three" },
  ];
  const [tasklist, setTasklist] = useState(initialList);

  const initialListDone = [
    { number: "12", name: "Done One" },
    { number: "23", name: "Done Two" },
    { number: "34", name: "Done Three" },
  ];
  const [tasklistDone, setTasklistDone] = useState(initialListDone);

  const toDoneTask = (number) => {
    const task = tasklist.find(task => task.number === number);
    if (task) {
      setTasklist(tasklist.filter((task) => task.number !== number));
      setTasklistDone([...tasklistDone, task]);
    }
  }

  const toTodTask = (number) => {
    const task = tasklistDone.find(task => task.number === number);
    if (task) {
      setTasklistDone(tasklistDone.filter((task) => task.number !== number));
      setTasklist([...tasklist, task]);
    }
  }

  return (
    <div>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={
            <div>
              <TasksTodoList tasklist={tasklist} toDoneTaskFunction={toDoneTask} />
              <TasksDoneList tasklist={tasklistDone} toTodoTaskFunction={toTodTask} />
            </div>
          } />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;


import React from 'react';
import { useNavigate } from 'react-router-dom';
export const TasksDoneList = ({ tasklist, toTodoTaskFunction }) => {
    const navigate = useNavigate();
    const todoTask = (e) => {
        toTodoTaskFunction(e.target.value);
    }
    return (
        <div>
            <h1>Done List</h1>
            <table border="1">
                <thead><tr><th>Number</th><th>Name</th>
                </tr></thead>
                <tbody>
                    {tasklist.map(task => (
                        <tr key={task.number}>
                            <td>{task.number}</td>
                            <td>{task.name}</td>
                            <td><button onClick={todoTask} value={task.number} >to Do List</button></td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}
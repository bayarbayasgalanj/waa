import React from 'react';
import { useNavigate } from 'react-router-dom';
export const TasksTodoList = ({ tasklist, toDoneTaskFunction }) => {
    const navigate = useNavigate();
    const doneTask = (e) => {
        toDoneTaskFunction(e.target.value);
    }
    return (
        <div>
            <h1>To Do List</h1>
            <table border="1">
                <thead><tr><th>Number</th><th>Name</th>
                </tr></thead>
                <tbody>
                    {tasklist.map(task => (
                        <tr key={task.number}>
                            <td>{task.number}</td>
                            <td>{task.name}</td>
                            <td><button onClick={doneTask} value={task.number} >to Done List</button></td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}
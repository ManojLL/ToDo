import React from 'react';

const TaskForm = ({ newTask, setNewTask, addTask }) => (
    <div>
        <h2 className="title is-4">Add a Task</h2>
        <input className="input mb-2" type="text" placeholder="Title" value={newTask.title} onChange={(e) => setNewTask({ ...newTask, title: e.target.value })} />
        <input className="input mb-4" type="text" placeholder="Description" value={newTask.description} onChange={(e) => setNewTask({ ...newTask, description: e.target.value })} />
        <button className="button is-primary is-pulled-right" onClick={addTask}>Add</button>
    </div>
);

export default TaskForm;
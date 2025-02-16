import React from 'react';
import '../index.css';
import '@fortawesome/fontawesome-free/css/all.min.css';


const TaskForm = ({newTask, setNewTask, addTask}) => (
    <div className="fixed-grid has-5-cols">
        <div className="grid">
            <div className="cell is-col-span-5">
            <h2 className="title ">Add a To-DO Task</h2>
            <input className="input mb-2 is-dark" type="text" placeholder="Title" value={newTask.title}
                   onChange={(e) => setNewTask({...newTask, title: e.target.value})}/>
            <textarea className="textarea mb-4 is-dark" placeholder="Description" value={newTask.description} rows="2"
                   onChange={(e) => setNewTask({...newTask, description: e.target.value})}/>
                <div className="cell">
                    <button className="button is-warning is-rounded is-pulled-right" onClick={addTask}>
                        <span className="icon"><i className="fas fa-plus"></i> </span></button>
                </div>
            </div>

        </div>
    </div>
);

export default TaskForm;
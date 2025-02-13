import React, {useState, useEffect} from 'react';
import TaskItem from "../components/TaskItem";
import 'bulma/css/bulma.min.css';
import TaskForm from "../components/TaskForm";

const HomePage = () => {
    const [tasks, setTasks] = useState([]);
    const [newTask, setNewTask] = useState({title: '', description: ''});


    const addTask = () => {
        if (newTask.title && newTask.description) {
            const task = { ...newTask, id: Date.now() };
            setTasks([task, ...tasks].slice(0, 5));
            setNewTask({ title: '', description: '' });
        }
    };

    const completeTask = (id) => {
        setTasks(tasks.filter(task => task.id !== id));
    };
    return (
        <div className="section">
            <div className="container">
                <div className="columns">
                    <div className="column">
                        <TaskForm newTask={newTask} setNewTask={setNewTask} addTask={addTask}/>
                    </div>
                    <div className="column">
                        <div className="space-y-4">
                            {tasks.map((task, index) => (
                                <TaskItem key={task.id} task={task} completeTask={completeTask}/>
                            ))}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default HomePage;

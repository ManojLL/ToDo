import React, {useEffect, useState} from 'react';
import TaskItem from "../components/TaskItem";
import 'bulma/css/bulma.min.css';
import TaskForm from "../components/TaskForm";
import {completeTask, fetchTasks, saveTask} from "../services/TaskApiService";

const HomePage = () => {
    const [tasks, setTasks] = useState([]);
    const [newTask, setNewTask] = useState({title: '', description: '', completed: false});

    const loadTasks = async () => {
        const data = await fetchTasks().then();
        if (data) {
            setTasks(data);
        }
    };

    useEffect(() => {
        loadTasks();
    }, []);

    const addTask = async () => {
        if (newTask.title && newTask.description) {
            const savedTask = await saveTask(newTask);
            if(savedTask) {
                loadTasks()
            }
            setNewTask({title: '', description: '', completed: false});
        }
    };

    const makeCompleteTask = async (id, task) => {
        task.completed = true;
        const completedTask = await completeTask(id, task);
        if (completedTask) {
            loadTasks()
        }
    };

    return (
        <div className="">
            <div className='img'>
            </div>
            <div className="section">
                <div className="container box">
                    <div className="columns">
                        <div className="column">
                            <div>
                                <TaskForm newTask={newTask} setNewTask={setNewTask} addTask={addTask}/>
                            </div>
                            <div>
                                <hr className="has-background-grey-lighter"/>
                                {tasks.map((task) => (
                                    <div key={task.id}>
                                        <TaskItem task={task} completeTask={makeCompleteTask}/>
                                        <hr className="has-background-grey-lighter"/>
                                    </div>
                                ))}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default HomePage;

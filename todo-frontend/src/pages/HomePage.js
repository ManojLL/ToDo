import React, {useState, useEffect} from 'react';
import TaskItem from "../components/TaskItem";
import 'bulma/css/bulma.min.css';
import TaskForm from "../components/TaskForm";
import {fetchTasks, saveTask, completeTask} from "../services/taskApiService";

const HomePage = () => {
    const [tasks, setTasks] = useState([]);
    const [newTask, setNewTask] = useState({title: '', description: '', completed: false});

    const loadTasks = async () => {
        const data = await fetchTasks();
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
            setTasks([savedTask, ...tasks].slice(0, 5));
            setNewTask({title: '', description: '', completed: false});
        }
    };

    const makeCompleteTask = async (id, task) => {
        task.completed = true;
        const completedTask = await completeTask(id, task);
        if(completedTask) {
            setTasks(tasks.filter(task => task.id !== id))
        }
    };

    return (
        <div className="section">
            <div className='hero'>
            </div>
            <div className="container box">
                <div className="columns">
                    <div className="column">
                        <div>
                        <TaskForm newTask={newTask} setNewTask={setNewTask} addTask={addTask}/>
                        </div>
                        <div>
                            <hr className="has-background-grey-lighter" />
                            {tasks.map((task) => (
                                <div key={task.id}>
                                <TaskItem task={task} completeTask={makeCompleteTask}/>
                                    <hr className="has-background-grey-lighter" />
                                </div>
                            ))}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default HomePage;

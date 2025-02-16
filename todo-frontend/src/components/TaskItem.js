import React from 'react';
import '@fortawesome/fontawesome-free/css/all.min.css';

const TaskItem = ({task, completeTask}) => {
    return (
        <div className="is-bordered" >
            <div className="grid">
                <div className="cell is-col-span-4 ">
                    <div>
                        <h3 className="title is-5">{task.title}</h3>
                        <p>{task.description}</p>
                    </div>
                </div>
                <div className="cell">
                    <button className="button is-link is-rounded is-pulled-right"  style={{ display: 'flex', justifyContent: 'center' }} onClick={() => completeTask(task.id, task)}>
                        <span className="icon is-small"><i className="fas fa-check"></i></span>
                    </button>
                </div>
            </div>

        </div>
    )
};

export default TaskItem;
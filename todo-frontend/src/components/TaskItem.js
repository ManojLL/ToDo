import React from 'react';

const TaskItem = ({task, completeTask}) => {
    return (
        <div className="space-y-4">
            <div className="box">
                <h3 className="title is-5">{task.title}</h3>
                <p>{task.description}</p>
                <button className="button is-success mt-2 is-pulled-right" onClick={() => completeTask(task.id)}>Done
                </button>
            </div>
        </div>
    )
};

export default TaskItem;
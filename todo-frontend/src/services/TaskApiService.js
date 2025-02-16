const BACKEND_BASE_URL = 'http://localhost:8080';
const API_URL = BACKEND_BASE_URL+'/api/v1/tasks';

export const fetchTasks = () => {
    return fetch(`${API_URL}/topFive`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .catch(error => {
            console.log('Error fetching tasks:', error);
            throw error;
        });
};

export const saveTask = (task) => {
    return fetch(API_URL, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(task),
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .catch(error => {
            console.log('Error saving task:', error);
            throw error;
        });
};

export const completeTask = (taskId, task) => {
    return fetch(`${API_URL}/${taskId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(task),
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .catch(error => {
            console.log('Error completing task:', error);
            throw error;
        });
};

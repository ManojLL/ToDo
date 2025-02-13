import axios from 'axios';

const API_URL = 'http://localhost:8080/api/v1/tasks';

export const fetchTasks = async () => {
    try {
        const response = await axios.get(API_URL+"/topFive");
        return response.data;
    } catch (error) {
        console.error('Error fetching tasks:', error);
    }
};

export const saveTask = async (task) => {
    try {
        const response = await axios.post(API_URL, task);
        return response.data;
    } catch (error) {
        console.error('Error saving task:', error);
    }
};

export const completeTask = async (taskId,task) => {
    try {
        const response = await axios.put(`${API_URL}/${taskId}`, task);
        return response.data;
    } catch (error) {
        console.error('Error completing task:', error);
    }
};
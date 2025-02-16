import {fetchTasks, saveTask, completeTask} from "../services/TaskApiService";

global.fetch = jest.fn();

const BASE_URL = process.env.REACT_APP_BACKEND_URL

afterEach(() => {
    fetch.mockClear();
});

test('fetchTasks should fetch top five tasks successfully', async () => {
    const mockTasks = [{ id: 1, name: 'Task 1' }];
    fetch.mockResolvedValueOnce({
        ok: true,
        json: async () => mockTasks,
    });

    const tasks = await fetchTasks();
    expect(tasks).toEqual(mockTasks);
    expect(fetch).toHaveBeenCalledWith(`${BASE_URL}/api/v1/tasks/topFive`);
});

test('fetchTasks should throw an error when network response is not ok', async () => {
    fetch.mockResolvedValueOnce({
        ok: false,
        text: async () => 'Internal Server Error',
    });

    await expect(fetchTasks()).rejects.toThrow('Network response was not ok');
});

test('fetchTasks should throw an error when fetch fails', async () => {
    fetch.mockRejectedValueOnce(new Error('Network Error'));

    await expect(fetchTasks()).rejects.toThrow('Network Error');
});

test('saveTask should save a task successfully', async () => {
    const newTask = { name: 'New Task' };
    const savedTask = { id: 1, name: 'New Task' };
    fetch.mockResolvedValueOnce({
        ok: true,
        json: async () => savedTask,
    });

    const result = await saveTask(newTask);
    expect(result).toEqual(savedTask);
    expect(fetch).toHaveBeenCalledWith(`${BASE_URL}/api/v1/tasks`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(newTask),
    });
});

test('saveTask should throw an error when network response is not ok', async () => {
    const newTask = { name: 'New Task' };

    fetch.mockResolvedValueOnce({
        ok: false,
        text: async () => 'Bad Request',
    });

    await expect(saveTask(newTask)).rejects.toThrow('Network response was not ok');
});

test('completeTask should complete a task successfully', async () => {
    const taskId = 1;
    const updatedTask = { id: 1, name: 'Task 1', completed: true };
    fetch.mockResolvedValueOnce({
        ok: true,
        json: async () => updatedTask,
    });

    const result = await completeTask(taskId, updatedTask);
    expect(result).toEqual(updatedTask);
    expect(fetch).toHaveBeenCalledWith(`${BASE_URL}/api/v1/tasks/${taskId}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(updatedTask),
    });
});

test('completeTask should throw an error when network response is not ok', async () => {
    const taskId = 1;
    const updatedTask = { id: 1, name: 'Task 1', completed: true };

    fetch.mockResolvedValueOnce({
        ok: false,
        text: async () => 'Not Found',
    });

    await expect(completeTask(taskId, updatedTask)).rejects.toThrow('Network response was not ok');
});

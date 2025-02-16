import {fetchTasks, saveTask, completeTask} from "../services/TaskApiService";

global.fetch = jest.fn();

const BASE_URL = 'http://localhost:8080'

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

test('should handle fetch error when network response is not ok', async () => {
    fetch.mockResolvedValueOnce({
        ok: false,
    });

    const tasks = await fetchTasks();
    expect(tasks).toBeUndefined();
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

test('saveTask should handle error when network response is not ok', async () => {
    const newTask = { name: 'New Task' };

    fetch.mockResolvedValueOnce({
        ok: false,
    });

    const result = await saveTask(newTask);
    expect(result).toBeUndefined();
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

test('completeTask should handle an error when network response is not ok', async () => {
    fetch.mockResolvedValueOnce({
        ok: false,
        text: async () => 'Not Found',
    });

    const result = await completeTask(999, { completed: true });
    expect(result).toBeUndefined();
});

import React from 'react';
import { render, screen, fireEvent, waitFor } from '@testing-library/react';
import HomePage from "../pages/HomePage";
import { fetchTasks, saveTask, completeTask } from '../services/TaskApiService';

jest.mock('../services/TaskApiService');

test('renders TaskForm and TaskItems components', async () => {
    render(<HomePage />);

    expect(screen.getByRole('heading', { name: /Add a To-Do Task/i })).toBeInTheDocument();

    expect(screen.getByPlaceholderText('Title')).toBeInTheDocument();
    expect(screen.getByPlaceholderText('Description')).toBeInTheDocument();
});


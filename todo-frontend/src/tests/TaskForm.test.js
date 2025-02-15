import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import TaskForm from "../components/TaskForm";

const mockSetNewTask = jest.fn();
const mockAddTask = jest.fn();

const defaultProps = {
    newTask: {
        title: '',
        description: '',
    },
    setNewTask: mockSetNewTask,
    addTask: mockAddTask,
};

afterEach(() => {
    jest.clearAllMocks();
});

test('renders TaskForm correctly', () => {
    render(<TaskForm {...defaultProps} />);

    // Check if the title and description fields are present
    expect(screen.getByPlaceholderText('Title')).toBeInTheDocument();
    expect(screen.getByPlaceholderText('Description')).toBeInTheDocument();

    // Check if the button is present
    expect(screen.getByRole('button')).toBeInTheDocument();
});

test('updates title field on change', () => {
    render(<TaskForm {...defaultProps} />);

    const titleInput = screen.getByPlaceholderText('Title');
    fireEvent.change(titleInput, { target: { value: 'New Task Title' } });

    expect(mockSetNewTask).toHaveBeenCalledWith({ title: 'New Task Title', description: '' });
});

test('updates description field on change', () => {
    render(<TaskForm {...defaultProps} />);

    const descriptionInput = screen.getByPlaceholderText('Description');
    fireEvent.change(descriptionInput, { target: { value: 'New Task Description' } });

    expect(mockSetNewTask).toHaveBeenCalledWith({ title: '', description: 'New Task Description' });
});

test('calls addTask function on button click', () => {
    render(<TaskForm {...defaultProps} />);

    const addButton = screen.getByRole('button');
    fireEvent.click(addButton);

    expect(mockAddTask).toHaveBeenCalledTimes(1);
});

import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import TaskItem from "../components/TaskItem";

const mockCompleteTask = jest.fn();

const taskProps = {
    tasks: {
        id:1,
        title: 'task1',
        description: 'task desc',
    },
    completeTask : mockCompleteTask
};

afterEach(() => {
    jest.clearAllMocks();
});

test('renders Task item  correctly', () => {
    render(<TaskItem task={taskProps.tasks} completeTask={taskProps.completeTask} />);

    expect(screen.getByText('task1')).toBeInTheDocument();
    expect(screen.getByText('task desc')).toBeInTheDocument();
});

test('calls completeTask when button is clicked', () => {
    render(<TaskItem task={taskProps.tasks} completeTask={taskProps.completeTask} />);

    const completeButton = screen.getByRole('button');
    fireEvent.click(completeButton);

    expect(taskProps.completeTask).toHaveBeenCalledWith(taskProps.tasks.id, taskProps.tasks);
});